<%--
  Created by IntelliJ IDEA.
  User: helldes
  Date: 20.05.2015
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    function changeHref(href) {
        $('a').attr('href', href);
    }
</script>
<html>
<head>
    <title>Select test</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/courses.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js" />"></script>

</head>
<body>

<div class="selectTest">

    <div>
        <c:choose>
            <c:when test="${not empty testAssignmentList}">
                <h2>Select test</h2>

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Start Date</th>
                        <th>Finish Date</th>
                        <th>Status</th>
                        <th>Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${testAssignmentList}" var="testAssignment">

                        <tr>
                            <td>${testAssignment.id}</td>
                            <td>(${testAssignment.testConfig.testType.course.name}
                                | ${testAssignment.testConfig.testType.name})
                                    ${testAssignment.testConfig.title}</td>

                            <td><fmt:formatDate type="date"
                                                value="${testAssignment.testConfig.dateStart}" /></td>
                            <td><fmt:formatDate type="date"
                                                value="${testAssignment.testConfig.dateFinish}" /></td>
                            <td>${testAssignment.testStatusAssignment}</td>
                            <td width="50">
                                <a href="/student/testing/test/${testAssignment.id}"><button class="btn btn-primary">Start</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <h2>You not have any test</h2>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</body>
</html>



