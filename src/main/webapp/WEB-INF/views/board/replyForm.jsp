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
	<title>답글쓰기</title>
	<link rel="stylesheet" href="${contextPath}/css/board/replyForm.css" />
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		function backToList(obj) {
			obj.action = "${contextPath}/board/listArticles.do";
			obj.submit();
		}

		function readURL(input) {
			if (input.files && input.files[0]) {
				const reader = new FileReader();
				reader.onload = function (e) {
					$('#preview').attr('src', e.target.result).show();
				};
				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>
</head>

<body>
<div class="reply-form-container">
	<h2 class="form-title">답글쓰기</h2>
	<form name="frmReply" method="post" action="${contextPath}/board/addReply.do" enctype="multipart/form-data">

		<div class="form-group">
			<label>작성자</label>
			<input type="text" name="writer" maxlength="100" />
		</div>

		<div class="form-group">
			<label>제목</label>
			<input type="text" name="title" maxlength="500" />
		</div>

		<div class="form-group">
			<label>내용</label>
			<textarea name="content" rows="10" maxlength="4000"></textarea>
		</div>

		<div class="form-group">
			<label>비밀번호</label>
			<input type="password" name="passwd" maxlength="12" />
		</div>

		<div class="form-group">
			<label>이미지파일 첨부</label>
			<input type="file" name="imageFileName" onchange="readURL(this);" />
			<img id="preview" src="#" class="preview-img" style="display:none;" />
		</div>

		<div class="form-buttons">
			<input type="submit" value="답글쓰기" />
			<input type="button" value="취소" onclick="backToList(this.form)" />
		</div>
	</form>
</div>
</body>
</html>
