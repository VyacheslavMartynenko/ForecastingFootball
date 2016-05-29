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
<div class="container-fluid">
    <h3>Add a Player</h3>
    <c:url var="addAction" value="/players/player/add"></c:url>
    <form:form action="${addAction}" commandName="player" class="form-horizontal">
        <c:if test="${!empty player.name}">
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
            <form:label path="name" class="control-label col-sm-2">
                <spring:message text="Name"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="name" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="surname" class="control-label col-sm-2">
                <spring:message text="Surname"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="surname" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="club" class="control-label col-sm-2">
                <spring:message text="Club"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="club" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="country" class="control-label col-sm-2">
                <spring:message text="Country"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="country" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="position" class="control-label col-sm-2">
                <spring:message text="Position"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="position" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="speed" class="control-label col-sm-2">
                <spring:message text="Speed"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="speed" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="dribbling" class="control-label col-sm-2">
                <spring:message text="Dribbling"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="dribbling" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="shoot" class="control-label col-sm-2">
                <spring:message text="Shoot"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="shoot" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="pass" class="control-label col-sm-2">
                <spring:message text="Pass"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="pass" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="defence" class="control-label col-sm-2">
                <spring:message text="Defence"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="defence" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="goalkeeper" class="control-label col-sm-2">
                <spring:message text="Goalkeeper"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="goalkeeper" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:if test="${!empty player.name}">
                    <input type="submit" class="btn btn-default"
                           value="<spring:message text="Edit Player"/>"/>
                </c:if>
                <c:if test="${empty player.name}">
                    <input type="submit" class="btn btn-default"
                           value="<spring:message text="Add Player"/>"/>
                </c:if>
            </div>
        </div>
    </form:form>
    <h3>Players List</h3>
    <c:if test="${!empty listPlayers}">
        <table class="tg table table-hover">
            <tr>
                <th>Player ID</th>
                <th>Player Name</th>
                <th>Player Surname</th>
                <th>Player Club</th>
                <th>Player Country</th>
                <th>Player Position</th>
                <th>Speed</th>
                <th>Dribbling</th>
                <th>Shoot</th>
                <th>Pass</th>
                <th>Defence</th>
                <th>Goalkeeper</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${listPlayers}" var="player">
                <tr>
                    <td>${player.id}</td>
                    <td>${player.name}</td>
                    <td>${player.surname}</td>
                    <td>${player.club}</td>
                    <td>${player.country}</td>
                    <td>${player.position}</td>
                    <td>${player.speed}</td>
                    <td>${player.dribbling}</td>
                    <td>${player.shoot}</td>
                    <td>${player.pass}</td>
                    <td>${player.defence}</td>
                    <td>${player.goalkeeper}</td>
                    <td><a href="<c:url value='edit/${player.id}' />">Edit</a></td>
                    <td><a href="<c:url value='remove/${player.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>