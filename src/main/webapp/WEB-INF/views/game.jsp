<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Games Page</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</head>
<body>
<h1>
    Add a Game
</h1>

<c:url var="addAction" value="/games/game/add"></c:url>

<form:form action="${addAction}" commandName="game">
    <table>
        <c:if test="${!empty game.firstClub}">
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
                <form:label path="firstClub">
                    <spring:message text="First Club"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstClub"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstGoals">
                    <spring:message text="First Goals"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstGoals"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="matchDate">
                    <spring:message text="Match Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="matchDate"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondGoals">
                    <spring:message text="Second Goals"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondGoals"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondClub">
                    <spring:message text="Second Club"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondClub"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty game.firstClub}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="Edit Game"/>"/>
                </c:if>
                <c:if test="${empty game.firstClub}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="Add Game"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Games List</h3>
<c:if test="${!empty listGames}">
    <table class="tg">
        <tr>
            <th width="80">Game ID</th>
            <th width="60">First Club</th>
            <th width="60">First Goals</th>
            <th width="60">Match Date</th>
            <th width="60">Second Goals</th>
            <th width="60">Second Club</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listGames}" var="game">
            <tr>
                <td>${game.id}</td>
                <td>${game.firstClub}</td>
                <td>${game.firstGoals}</td>
                <td>${game.matchDate}</td>
                <td>${game.secondGoals}</td>
                <td>${game.secondClub}</td>
                <td><a href="<c:url value='edit/${game.id}' />">Edit</a></td>
                <td><a href="<c:url value='remove/${game.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
