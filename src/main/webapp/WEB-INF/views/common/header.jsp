<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div style="display: flex; align-items: center;">
    <a href="${contextPath}/main.do">
        <img src="${contextPath}/img/logo.png" alt="로고" />
    </a>
    <h1>스켈레톤 프로젝트</h1>
</div>

<div class="login-area">
    <c:choose>
        <c:when test="${isLogOn == true && member != null}">
            <h3>${member.name}님 환영합니다</h3>
            <a href="${contextPath}/member/logout.do">로그아웃</a>
        </c:when>
        <c:otherwise>
            <a href="${contextPath}/member/loginForm.do">로그인</a>
        </c:otherwise>
    </c:choose>
</div>

