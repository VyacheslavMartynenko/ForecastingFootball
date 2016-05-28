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
                <form:label path="surname">
                    <spring:message text="Surname"/>
                </form:label>
            </td>
            <td>
                <form:input path="surname"/>
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
            <td>
                <form:label path="country">
                    <spring:message text="Country"/>
                </form:label>
            </td>
            <td>
                <form:input path="country"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="position">
                    <spring:message text="Position"/>
                </form:label>
            </td>
            <td>
                <form:input path="position"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="speed">
                    <spring:message text="Speed"/>
                </form:label>
            </td>
            <td>
                <form:input path="speed"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dribbling">
                    <spring:message text="Dribbling"/>
                </form:label>
            </td>
            <td>
                <form:input path="dribbling"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="shoot">
                    <spring:message text="Shoot"/>
                </form:label>
            </td>
            <td>
                <form:input path="shoot"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="pass">
                    <spring:message text="Pass"/>
                </form:label>
            </td>
            <td>
                <form:input path="pass"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="defence">
                    <spring:message text="Defence"/>
                </form:label>
            </td>
            <td>
                <form:input path="defence"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="goalkeeper">
                    <spring:message text="Goalkeeper"/>
                </form:label>
            </td>
            <td>
                <form:input path="goalkeeper"/>
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
            <th width="120">Player Surname</th>
            <th width="120">Player Club</th>
            <th width="120">Player Country</th>
            <th width="120">Player Position</th>
            <th width="60">Speed</th>
            <th width="60">Dribbling</th>
            <th width="60">Shoot</th>
            <th width="60">Pass</th>
            <th width="60">Defence</th>
            <th width="60">Goalkeeper</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
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
</body>
</html>