<%--
  Created by IntelliJ IDEA.
  User: helldes
  Date: 20.05.2015
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Select course</title>
    <link href="<c:url value='/resources/vendors/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/bootstrap-theme.min.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/courses.css'/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value='/resources/vendors/jquery/dist/jquery.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/vendors/bootstrap/dist/js/bootstrap.min.js'/>" type="text/javascript"></script>


</head>
<body>

<div class="selectCourse">

    <div>

        <h2>Select the course</h2>

        <form name="form" method="get" action="">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${coursesList}" var="course">
                    <tr>
                        <td width="300">${course.name}</td>
                        <td>${course.description}</td>
                        <td width="50">
                            <div class="col-sm-12">
                                <div class="radio">
                                    <label style="font-size: 1.5em">
                                        <input type="radio" name="courseId"
                                               onclick="changeHref('/student/testing/course/${course.id}/selectTest')">
                                        <span class="cr"><i class="cr-icon fa fa-check"></i></span>
                                    </label>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
        <a href="" name="link" class="btn btn-default">Select</a>
    </div>
</div>

<script src="<c:url value="/resources/js/test-page/selectCourse.js"/>" type="text/javascript"></script>
</body>
</html>


