<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글보기</title>
    <link rel="stylesheet" href="${contextPath}/css/userPage/board/viewArticle.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function backToList(obj) {
            obj.action = "${contextPath}/board/listArticles.do";
            obj.submit();
        }

        function fn_enable(obj) {
            $("#i_title, #i_content, #i_imageFileName").prop("disabled", false);
            $("#tr_btn_modify, #tr_file_upload").show();
            $("#tr_btn").hide();
        }

        function fn_modify_article(obj) {
            obj.action = "${contextPath}/board/modArticle.do";
            obj.submit();
        }

        function fn_remove_article(url, articleNO) {
            const form = document.createElement("form");
            form.method = "post";
            form.action = url;

            const input = document.createElement("input");
            input.type = "hidden";
            input.name = "articleNO";
            input.value = articleNO;

            form.appendChild(input);
            document.body.appendChild(form);
            form.submit();
        }

        function fn_reply_form(url, parentNO) {
            const form = document.createElement("form");
            form.method = "post";
            form.action = url;

            const input = document.createElement("input");
            input.type = "hidden";
            input.name = "parentNO";
            input.value = parentNO;

            form.appendChild(input);
            document.body.appendChild(form);
            form.submit();
        }

        function readURL(input) {
            if (input.files && input.files[0]) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    $('#preview').attr('src', e.target.result);
                };
                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</head>
<body>
<form name="frmArticle" method="post" action="${contextPath}" enctype="multipart/form-data">
    <input type="hidden" name="articleNO" value="${article.articleNO}" />
    <div class="article-container">
        <table class="article-table">
            <tr><th>글번호</th><td><input type="text" value="${article.articleNO}" disabled /></td></tr>
            <tr><th>작성자</th><td><input type="text" value="${article.id}" name="writer" disabled /></td></tr>
            <tr><th>제목</th><td><input type="text" name="title" id="i_title" value="${article.title}" disabled /></td></tr>
            <tr><th>내용</th><td><textarea name="content" id="i_content" rows="10" disabled>${article.content}</textarea></td></tr>

            <c:choose>
                <c:when test="${not empty article.imageFileName && article.imageFileName != 'null'}">
                    <tr><th rowspan="2">이미지</th>
                        <td>
                            <input type="hidden" name="originalFileName" value="${article.imageFileName}" />
                            <img id="preview" src="${contextPath}/download.do?articleNO=${article.articleNO}&imageFileName=${article.imageFileName}" width="300" height="200" />
                        </td>
                    </tr>
                    <tr>
                        <td><input type="file" name="imageFileName" id="i_imageFileName" disabled onchange="readURL(this);" /></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr id="tr_file_upload">
                        <th rowspan="2">이미지</th>
                        <td><img id="preview" style="display:none;" /></td>
                    </tr>
                    <tr><td><input type="file" name="imageFileName" id="i_imageFileName" disabled onchange="readURL(this);" /></td></tr>
                </c:otherwise>
            </c:choose>

            <tr><th>등록일자</th><td><input type="text" value="<fmt:formatDate value='${article.writeDate}'/>" disabled /></td></tr>

            <tr id="tr_btn_modify" style="display:none">
                <td colspan="2" class="center">
                    <input type="button" value="수정반영하기" onclick="fn_modify_article(frmArticle)" />
                    <input type="button" value="취소" onclick="backToList(frmArticle)" />
                </td>
            </tr>

            <tr id="tr_btn">
                <td colspan="2" class="center">
                    <c:if test="${user.id == article.id}">
                        <input type="button" value="수정하기" onclick="fn_enable(this.form)" />
                        <input type="button" value="삭제하기" onclick="fn_remove_article('${contextPath}/board/removeArticle.do', ${article.articleNO})" />
                    </c:if>
                    <input type="button" value="리스트로 돌아가기" onclick="backToList(this.form)" />
                    <input type="button" value="답글쓰기" onclick="fn_reply_form('${contextPath}/board/replyForm.do', ${article.articleNO})" />
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
