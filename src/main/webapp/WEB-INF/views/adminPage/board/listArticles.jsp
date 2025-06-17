<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
    <link rel="stylesheet" href="${contextPath}/css/adminPage/board/listArticles.css" />
</head>
<body>
<div class="article-container">
    <h2 class="title">게시판</h2>
    <table class="article-table">
        <thead>
        <tr>
            <th>글번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${empty articlesList}">
                <tr>
                    <td colspan="4" class="no-articles">등록된 글이 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="article" items="${articlesList}">
                    <tr>
                        <td>${article.articleNO}</td>
                        <td>${article.id}</td>
                        <td class="article-title">
                            <c:if test="${article.level > 1}">
                                <c:forEach begin="2" end="${article.level}" step="1">
                                    <span class="indent"></span>
                                </c:forEach>
                                <span class="reply-prefix">[답변]</span>
                            </c:if>
                            <a href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">
                                    ${article.title}
                            </a>
                        </td>
                        <td>${article.writeDate}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>

    <div class="write-button">
        <a href="javascript:fn_articleForm('${isLogOn}', '${contextPath}/board/articleForm.do', '${contextPath}/user/loginForm.do')">글쓰기</a>
    </div>
</div>

<script>
    function fn_articleForm(isLogOn, articleForm, loginForm) {
        if (isLogOn && isLogOn !== 'false') {
            location.href = articleForm;
        } else {
            alert("로그인 후 글쓰기가 가능합니다.");
            location.href = loginForm + '?action=' + articleForm;
        }
    }
</script>
</body>
</html>
