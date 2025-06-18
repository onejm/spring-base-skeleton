<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 출력창</title>
    <link rel="stylesheet" href="${contextPath}/css/adminPage/user/listAdmins.css">
</head>
<body>
<div class="user-container">
    <h2 class="title">회원 목록</h2>
    <table class="user-table">
        <thead>
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일</th>
            <th>작업</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${usersList}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.pwd}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.joinDate}</td>
                <td><a class="delete-btn" href="${contextPath}/user/removeUser.do?id=${user.id}">삭제</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="add-user-link">
        <a href="${contextPath}/user/userForm.do">회원가입 하기</a>
    </div>
</div>
</body>
</html>
