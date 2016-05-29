<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Results Page</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
</head>
<body>
<div class="container-fluid">
    <h3>Add a Result</h3>
    <c:url var="addAction" value="/results/result/add"></c:url>
    <form:form action="${addAction}" commandName="result" class="form-horizontal">
        <c:if test="${!empty result.algorithm}">
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
            <form:label path="firstInjures" class="control-label col-sm-2">
                <spring:message text="First Injures"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstInjures" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstRest" class="control-label col-sm-2">
                <spring:message text="First Rest"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstRest" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstAttack" class="control-label col-sm-2">
                <spring:message text="First Attack"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstAttack" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="firstDefence" class="control-label col-sm-2">
                <spring:message text="First Defence"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="firstDefence" class="form-control"/>
            </div>
        </div>
        <c:if test="${!empty result.algorithm}">
            <div class="form-group">
                <form:label path="firstRate" class="control-label col-sm-2">
                    <spring:message text="First Rate"/>
                </form:label>
                <div class="col-sm-10">
                    <form:input path="firstRate" class="form-control" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="firstRate"/>
                </div>
            </div>
        </c:if>
        <div class="form-group">
            <form:label path="algorithm" class="control-label col-sm-2">
                <spring:message text="Algorithm"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="algorithm" class="form-control"/>
            </div>
        </div>
        <c:if test="${!empty result.algorithm}">
            <div class="form-group">
                <form:label path="secondRate" class="control-label col-sm-2">
                    <spring:message text="Second Rate"/>
                </form:label>
                <div class="col-sm-10">
                    <form:input path="secondRate" class="form-control" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="secondRate"/>
                </div>
            </div>
        </c:if>
        <div class="form-group">
            <form:label path="secondDefence" class="control-label col-sm-2">
                <spring:message text="Second Defence"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondDefence" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondAttack" class="control-label col-sm-2">
                <spring:message text="Second Attack"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondAttack" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondRest" class="control-label col-sm-2">
                <spring:message text="Second Rest"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondRest" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="secondInjures" class="control-label col-sm-2">
                <spring:message text="Second Injures"/>
            </form:label>
            <div class="col-sm-10">
                <form:input path="secondInjures" class="form-control"/>
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
                <c:if test="${!empty result.algorithm}">
                    <input type="submit" class="btn btn-default"
                           value="<spring:message text="Edit Result"/>"/>
                </c:if>
                <c:if test="${empty result.algorithm}">
                    <input type="submit" class="btn btn-default"
                           value="<spring:message text="Add Result"/>"/>
                </c:if>
            </div>
        </div>
    </form:form>
    <h3>Results List</h3>
    <c:if test="${!empty listResults}">
        <table class="tg table table-hover">
            <tr>
                <th>Result ID</th>
                <th>First Club</th>
                <th>First Injures</th>
                <th>First Rest</th>
                <th>First Attack</th>
                <th>First Defence</th>
                <th>First Rate</th>
                <th>Algorithm</th>
                <th>Second Rate</th>
                <th>Second Defence</th>
                <th>Second Attack</th>
                <th>Second Rest</th>
                <th>Second Injures</th>
                <th>Second Club</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${listResults}" var="result">
                <tr>
                    <td>${result.id}</td>
                    <td>${result.firstClub}</td>
                    <td>${result.firstInjures}</td>
                    <td>${result.firstRest}</td>
                    <td>${result.firstAttack}</td>
                    <td>${result.firstDefence}</td>
                    <td>${result.firstRate}</td>
                    <td>${result.algorithm}</td>
                    <td>${result.secondRate}</td>
                    <td>${result.secondDefence}</td>
                    <td>${result.secondAttack}</td>
                    <td>${result.secondRest}</td>
                    <td>${result.secondInjures}</td>
                    <td>${result.secondClub}</td>
                    <td><a href="<c:url value='edit/${result.id}' />">Edit</a></td>
                    <td><a href="<c:url value='remove/${result.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>