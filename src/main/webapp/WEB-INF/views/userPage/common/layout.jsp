<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><tiles:insertAttribute name="title" /></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userPage/common/layout.css">
</head>
<body>
<div id="container">
    <div id="header">
        <tiles:insertAttribute name="header"/>
    </div>

    <div class="layout-body">
        <div id="sidebar-left">
            <tiles:insertAttribute name="side"/>
        </div>
        <div id="content">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>

    <div id="footer">
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
</body>
</html>
