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
<h1>
    Add a Result
</h1>

<c:url var="addAction" value="/results/result/add"></c:url>

<form:form action="${addAction}" commandName="result">
    <table>
        <c:if test="${!empty result.algorithm}">
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
        <c:if test="${!empty result.algorithm}">
            <tr>
                <td>
                    <form:label path="firstRate">
                        <spring:message text="First Rate"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="firstRate" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="firstRate"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="algorithm">
                    <spring:message text="Algorithm"/>
                </form:label>
            </td>
            <td>
                <form:input path="algorithm"/>
            </td>
        </tr>
        <c:if test="${!empty result.algorithm}">
            <tr>
                <td>
                    <form:label path="secondRate">
                        <spring:message text="Second Rate"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="secondRate" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="secondRate"/>
                </td>
            </tr>
        </c:if>
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
                <c:if test="${!empty result.algorithm}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="Edit Result"/>"/>
                </c:if>
                <c:if test="${empty result.algorithm}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="Add Result"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Results List</h3>
<c:if test="${!empty listResults}">
    <table class="tg">
        <tr>
            <th width="80">Result ID</th>
            <th width="60">First Club</th>
            <th width="60">First Rate</th>
            <th width="60">Algorithm</th>
            <th width="60">Second Rate</th>
            <th width="60">Second Club</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listResults}" var="result">
            <tr>
                <td>${result.id}</td>
                <td>${result.firstClub}</td>
                <td>${result.firstRate}</td>
                <td>${result.algorithm}</td>
                <td>${result.secondRate}</td>
                <td>${result.secondClub}</td>
                <td><a href="<c:url value='edit/${result.id}' />">Edit</a></td>
                <td><a href="<c:url value='remove/${result.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>