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
<div class="container-fluid">
    <h3>Add a Game</h3>
    <c:url var="addAction" value="/games/game/add"></c:url>
    <form:form action="${addAction}" commandName="game" class="form-horizontal">
        <c:if test="${!empty game.firstClub}">
            <div class="form-group">
                <form:label path="id" class="control-label col-sm-2">
                    <spring:message text="ID"/>
                </form:label>
                <div class="col-sm-10">
                    <form:input path="id" class="form-control" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </div>
            </div>
        </c:if>
        <div class="form-group">
            <form:label path="firstClub" class="control-label col-sm-2">
                <spring:message text="First Club"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstClub" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstGoals" class="control-label col-sm-2">
                <spring:message text="First Goals"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstGoals" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstShoots" class="control-label col-sm-2">
                <spring:message text="First Shoots"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstShoots" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstShootsTarget" class="control-label col-sm-2">
                <spring:message text="First Shoots Target"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstShootsTarget" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstPasses" class="control-label col-sm-2">
                <spring:message text="First Passes"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstPasses" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstPassesTarget" class="control-label col-sm-2">
                <spring:message text="First Passes Target"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstPassesTarget" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstPossession" class="control-label col-sm-2">
                <spring:message text="First Possession"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstPossession" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstCorners" class="control-label col-sm-2">
                <spring:message text="First Corners"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstCorners" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstDuels" class="control-label col-sm-2">
                <spring:message text="First Duels"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstDuels" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="matchDate" class="control-label col-sm-2">
                <spring:message text="Match Date"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="matchDate" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondDuels" class="control-label col-sm-2">
                <spring:message text="Second Duels"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondDuels" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondCorners" class="control-label col-sm-2">
                <spring:message text="Second Corners"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondCorners" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondPossession" class="control-label col-sm-2">
                <spring:message text="Second Possession"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondPossession" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondPassesTarget" class="control-label col-sm-2">
                <spring:message text="Second Passes Target"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondPassesTarget" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondPasses" class="control-label col-sm-2">
                <spring:message text="Second Passes"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondPasses" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondShootsTarget" class="control-label col-sm-2">
                <spring:message text="Second Shoots Target"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondShootsTarget" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondShoots" class="control-label col-sm-2">
                <spring:message text="Second Shoots"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondShoots" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondGoals" class="control-label col-sm-2">
                <spring:message text="Second Goals"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondGoals" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondClub" class="control-label col-sm-2">
                <spring:message text="Second Club"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondClub" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:if test="${!empty game.firstClub}">
                    <input type="submit" class="btn btn-default"
                           value="<spring:message text="Edit Game"/>"/>
                </c:if>
                <c:if test="${empty game.firstClub}">
                    <input type="submit" class="btn btn-default"
                           value="<spring:message text="Add Game"/>"/>
                </c:if>
            </div>
        </div>
    </form:form>
    <h3>Games List</h3>
    <c:if test="${!empty listGames}">
        <table class="tg table table-hover">
            <tr>
                <th>Game ID</th>
                <th>First Club</th>
                <th>First Goals</th>
                <th>First Shoots</th>
                <th>First Shoots Target</th>
                <th>First Passes</th>
                <th>First Passes Target</th>
                <th>First Possession</th>
                <th>First Corners</th>
                <th>First Duels</th>
                <th>Match Date</th>
                <th>Second Duels</th>
                <th>Second Corners</th>
                <th>Second Possession</th>
                <th>Second Passes Target</th>
                <th>Second Passes</th>
                <th>Second Shoots Target</th>
                <th>Second Shoots</th>
                <th>Second Goals</th>
                <th>Second Club</th>
                <th>Edit</th>
                <th>Delete</th>
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
                    <td><a href="<c:url value='/games/edit/${game.id}' />">Edit</a></td>
                    <td><a href="<c:url value='/games/remove/${game.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
