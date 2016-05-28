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
                <form:label path="firstShoots">
                    <spring:message text="First Shoots"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstShoots"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstShootsTarget">
                    <spring:message text="First Shoots Target"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstShootsTarget"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstPasses">
                    <spring:message text="First Passes"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstPasses"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstPassesTarget">
                    <spring:message text="First Passes Target"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstPassesTarget"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstPossession">
                    <spring:message text="First Possession"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstPossession"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstCorners">
                    <spring:message text="First Corners"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstCorners"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstDuels">
                    <spring:message text="First Duels"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstDuels"/>
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
                <form:label path="secondDuels">
                    <spring:message text="Second Duels"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondDuels"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondCorners">
                    <spring:message text="Second Corners"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondCorners"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondPossession">
                    <spring:message text="Second Possession"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondPossession"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondPassesTarget">
                    <spring:message text="Second Passes Target"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondPassesTarget"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondPasses">
                    <spring:message text="Second Passes"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondPasses"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondShootsTarget">
                    <spring:message text="Second Shoots Target"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondShootsTarget"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="secondShoots">
                    <spring:message text="Second Shoots"/>
                </form:label>
            </td>
            <td>
                <form:input path="secondShoots"/>
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
            <th width="60">First Shoots</th>
            <th width="60">First Shoots Target</th>
            <th width="60">First Passes</th>
            <th width="60">First Passes Target</th>
            <th width="60">First Possession</th>
            <th width="60">First Corners</th>
            <th width="60">First Duels</th>
            <th width="60">Match Date</th>
            <th width="60">Second Duels</th>
            <th width="60">Second Corners</th>
            <th width="60">Second Possession</th>
            <th width="60">Second Passes Target</th>
            <th width="60">Second Passes</th>
            <th width="60">Second Shoots Target</th>
            <th width="60">Second Shoots</th>
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
                <td>${game.firstShoots}</td>
                <td>${game.firstShootsTarget}</td>
                <td>${game.firstPasses}</td>
                <td>${game.firstPassesTarget}</td>
                <td>${game.firstPossession}</td>
                <td>${game.firstCorners}</td>
                <td>${game.firstDuels}</td>
                <td>${game.matchDate}</td>
                <td>${game.secondDuels}</td>
                <td>${game.secondCorners}</td>
                <td>${game.secondPossession}</td>
                <td>${game.secondPassesTarget}</td>
                <td>${game.secondPasses}</td>
                <td>${game.secondShootsTarget}</td>
                <td>${game.secondShoots}</td>
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
