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
<div class="container-fluid">
    <h3>Add a Club</h3>
    <c:url var="addAction" value="/clubs/club/add"></c:url>
    <form:form action="${addAction}" commandName="club" class="form-horizontal">
        <c:if test="${!empty club.name}">
            <div class="form-group">
                <form:label class="control-label col-sm-2" path="id">
                    <spring:message text="ID"/>
                </form:label>
                <div class="col-sm-10">
                    <form:input path="id" class="form-control" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </div>
            </div>
        </c:if>
        <div class="form-group">
            <form:label class="control-label col-sm-2" path="position">
                <spring:message text="Position"/>
            </form:label>
            <div class="col-sm-10">
                <form:input class="form-control" path="position"/>
            </div>
        </div>
        <div class="form-group">
            <form:label class="control-label col-sm-2" path="name">
                <spring:message text="Name"/>
            </form:label>
            <div class="col-sm-10">
                <form:input class="form-control" path="name"/>
            </div>
        </div>
        <div class="form-group">
            <form:label class="control-label col-sm-2" path="league">
                <spring:message text="League"/>
            </form:label>
            <div class="col-sm-10">
                <form:input class="form-control" path="league"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:if test="${!empty club.name}">
                    <input type="submit" class="btn btn-default"
                           value="<spring:message text="Edit Club"/>"/>
                </c:if>
                <c:if test="${empty club.name}">
                    <input type="submit" class="btn btn-default"
                           value="<spring:message text="Add Club"/>"/>
                </c:if>
            </div>
        </div>
    </form:form>

    <h3>Clubs List</h3>
    <c:if test="${!empty listClubs}">
        <table class="tg table table-hover">
            <tr>
                <th>Club ID</th>
                <th>Club Position</th>
                <th>Club Name</th>
                <th>Club League</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${listClubs}" var="club">
                <tr>
                    <td>${club.id}</td>
                    <td>${club.position}</td>
                    <td>${club.name}</td>
                    <td>${club.league}</td>
                    <td><a href="<c:url value='/clubs/edit/${club.id}' />">Edit</a></td>
                    <td><a href="<c:url value='/clubs/remove/${club.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
