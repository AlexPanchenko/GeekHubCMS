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
        <table class="table table-striped table-condensed table-bordered">
            <thead>
            <tr>
                <td>Name</td>
                <td>Time</td>
                <td>Period</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="i" begin="0" end="${fn:length(schedulerList)}">
                <tr>
                    <td>${schedulerList[i].class.simpleName}</td>
                    <td></td>
                    <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
