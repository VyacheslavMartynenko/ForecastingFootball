<%--suppress ALL --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Main Page</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</head>
<body background="/resources/img/bg.jpg">
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/index"/>">Forecasting Football</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="<c:url value="/index"/>">Home</a></li>
            <li><a href="<c:url value="/players"/>">Players List</a></li>
            <li><a href="<c:url value="/clubs"/>">Clubs List</a></li>
            <li><a href="<c:url value="/results"/>">Results List</a></li>
            <li><a href="<c:url value="/games"/>">Games List</a></li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div style="width: 500; margin: auto">
            <h3 style="width: 500; margin: auto; text-align: center">Football Forecasting</h3>
            <img style="margin: auto" src="/resources/img/logo.png" alt="logo" width="500" height="480">
        </div>
    </div>
</div>
</body>
</html>