<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글쓰기</title>
	<link rel="stylesheet" href="${contextPath}/css/adminPage/board/articleForm.css" />
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		function readURL(input) {
			if (input.files && input.files[0]) {
				const reader = new FileReader();
				reader.onload = function (e) {
					$('#preview').attr('src', e.target.result).show();
				};
				reader.readAsDataURL(input.files[0]);
			}
		}

		function backToList(obj) {
			obj.action = "${contextPath}/board/listArticles.do";
			obj.submit();
		}

		let cnt = 1;
		function fn_addFile() {
			$("#d_file").append(`<div class="file-input"><input type="file" name="file${cnt}" /></div>`);
			cnt++;
		}
	</script>
</head>

<body>
<div class="article-form-container">
	<h2 class="form-title">글쓰기</h2>
	<form name="articleForm" method="post" action="${contextPath}/board/addNewArticle.do" enctype="multipart/form-data">
		<div class="form-group">
			<label>작성자</label>
			<input type="text" name="writer" value="${user.name}" readonly />
		</div>

		<div class="form-group">
			<label>글제목</label>
			<input type="text" name="title" maxlength="500" />
		</div>

		<div class="form-group">
			<label>글내용</label>
			<textarea name="content" rows="10" maxlength="4000"></textarea>
		</div>

		<div class="form-group">
			<label>이미지파일 첨부</label>
			<input type="file" name="imageFileName" onchange="readURL(this);" />
			<img id="preview" src="#" alt="미리보기" class="preview-img" style="display:none;" />
		</div>

		<div class="form-group">
			<button type="button" onclick="fn_addFile()">파일 추가</button>
			<div id="d_file" class="file-add-container"></div>
		</div>

		<div class="form-buttons">
			<input type="submit" value="글쓰기" />
			<input type="button" value="목록보기" onclick="backToList(this.form)" />
		</div>
	</form>
</div>
</body>
</html>
