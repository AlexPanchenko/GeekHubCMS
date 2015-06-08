<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>AdminPanel</title>

    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>

<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>

    <div id="page-content-wrapper">
        <h2>Schedulers</h2>
        <%--<table class="table table-striped table-condensed table-bordered">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<td>Name</td>--%>
                <%--<td>Time</td>--%>
                <%--<td>Period</td>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--<c:forEach var="i" begin="0" end="${fn:length(schedulerList)}">--%>
                <%--<tr>--%>
                    <%--<td>${schedulerList[i].class.simpleName}</td>--%>
                    <%--<td></td>--%>
                    <%--<td></td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>
        <%--</table>--%>
        <table class="table table-bordered table-striped table-hover">
            <thead>
            <tr>
                <th>Invoke</th>
                <th>Instance name</th>
                <th>Disable</th>
                <th>Enabled</th>
                <th>Last start date</th>
                <th>Last run duration (sec)</th>
                <th>Times started</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${schedulerList}" var="row">

                <tr>
                    <td><button onclick="document.location = 'bgprocess/run?name=${row.processTerminal.className}'" class="btn btn-primary"><b>Run</b></button></td>
                    <td><c:out value="${row.processTerminal.name}"></c:out></td>
                    <td>
                        <c:choose>
                            <c:when test="${row.processTerminal.schedulingOn}">
                                <font color="#400040">
                                    <button style="color: white" onclick="if(confirm('Do you realy want to disable this process?')) {document.location = '/admin/bgprocess/disable?name=${row.processTerminal.className}'}" class="btn btn-danger"><b>Disable</b></button>
                                </font>
                            </c:when>
                            <c:otherwise>
                                <font color="#400040">
                                    <button style="color: #ffffff" onclick="document.location = '/admin/bgprocess/enable?name=${row.processTerminal.className}'" class="btn btn-success"><b>Enable</b></button>
                                </font>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${row.processTerminal.schedulingOn}"></c:out></td>
                    <td><c:out value="${row.processTerminal.startDate}"></c:out></td>
                    <td><c:out value="${row.processTerminal.lastDuration}"></c:out></td>
                    <td><c:out value="${row.processTerminal.timesStarted}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
