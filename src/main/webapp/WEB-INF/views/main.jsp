<%--suppress ALL --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Players Page</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</head>
<body>
<a href="<c:url value="/players"/>">Players List</a>
<a href="<c:url value="/clubs"/>">Clubs List</a>
<a href="<c:url value="/results"/>">Results List</a>
<a href="<c:url value="/games"/>">Games List</a>
</body>
</html>