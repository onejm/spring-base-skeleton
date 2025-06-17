<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<h2>사이드 메뉴</h2>
<ul class="side-menu">
    <li><a href="${contextPath}/user/listUsers.do">회원관리</a></li>
    <li><a href="${contextPath}/board/listArticles.do">게시판관리</a></li>
</ul>

