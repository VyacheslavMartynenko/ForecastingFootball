<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Clubs Page</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</head>
<body>
<h1>
    Add a Club
</h1>

<c:url var="addAction" value="/clubs/club/add"></c:url>

<form:form action="${addAction}" commandName="club">
    <table>
        <c:if test="${!empty club.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="league">
                    <spring:message text="League"/>
                </form:label>
            </td>
            <td>
                <form:input path="league"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty club.name}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="Edit Club"/>"/>
                </c:if>
                <c:if test="${empty club.name}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="Add Club"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Clubs List</h3>
<c:if test="${!empty listClubs}">
    <table class="tg">
        <tr>
            <th width="80">Club ID</th>
            <th width="120">Club Name</th>
            <th width="120">Club League</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listClubs}" var="club">
            <tr>
                <td>${club.id}</td>
                <td>${club.name}</td>
                <td>${club.league}</td>
                <td><a href="<c:url value='edit/${club.id}' />">Edit</a></td>
                <td><a href="<c:url value='remove/${club.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
