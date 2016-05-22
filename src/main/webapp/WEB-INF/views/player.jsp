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
<h1>
    Add a Player
</h1>

<c:url var="addAction" value="/players/player/add"></c:url>

<form:form action="${addAction}" commandName="player">
    <table>
        <c:if test="${!empty player.name}">
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
                <form:label path="club">
                    <spring:message text="Club"/>
                </form:label>
            </td>
            <td>
                <form:input path="club"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty player.name}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="Edit Player"/>"/>
                </c:if>
                <c:if test="${empty player.name}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="Add Player"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Players List</h3>
<c:if test="${!empty listPlayers}">
    <table class="tg">
        <tr>
            <th width="80">Player ID</th>
            <th width="120">Player Name</th>
            <th width="120">Player Club</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPlayers}" var="player">
            <tr>
                <td>${player.id}</td>
                <td>${player.name}</td>
                <td>${player.club}</td>
                <td><a href="<c:url value='edit/${player.id}' />">Edit</a></td>
                <td><a href="<c:url value='remove/${player.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>