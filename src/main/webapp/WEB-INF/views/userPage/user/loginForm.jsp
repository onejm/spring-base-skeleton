<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인창</title>
    <link rel="stylesheet" href="${contextPath}/css/userPage/user/loginForm.css" />

    <c:choose>
        <c:when test="${result == 'loginFailed'}">
            <script>
                window.onload = function () {
                    alert("아이디나 비밀번호가 틀립니다. 다시 로그인 하세요!");
                };
            </script>
        </c:when>
    </c:choose>
</head>

<body>
<div class="login-container">
    <form name="frmLogin" method="post" action="${contextPath}/user/login.do">
        <h2>로그인</h2>
        <div class="input-group">
            <label for="userId">아이디</label>
            <input type="text" id="userId" name="userId" />
        </div>
        <div class="input-group">
            <label for="pwd">비밀번호</label>
            <input type="password" id="pwd" name="pwd" />
        </div>
        <div class="button-group">
            <input type="submit" value="로그인" />
            <input type="reset" value="다시입력" />
        </div>
    </form>
</div>
</body>
</html>
