<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>registration on courses</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/bootstrap-them.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/courses.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<div class="coursesRegisTable">

    <div>

        <h2>REGISTRATION ON COURSES</h2>

        <form method="post" action="/student/registrationCourses">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Number</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Registration</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listCourses}" var="courseWrapper">

                <tr>
                    <td width="50">${courseWrapper.course.id}</td>
                    <td width="300">${courseWrapper.course.name}</td>
                    <td>${courseWrapper.course.description}</td>
                    <td width="50">
                        <c:choose>
                            <c:when test="${courseWrapper.isRegistered}">
                                <div class="col-sm-12">
                                    <div class="checkbox">
                                    <label style="font-size: 1.5em">
                                        <input type="checkbox" checked disabled>
                                        <span class="cr"><i class="cr-icon fa fa-check"></i></span>
                                    </label>
                                </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="col-sm-12">
                                    <div class="checkbox">
                                        <label style="font-size: 1.5em">
                                            <input type="checkbox" name="courseId" value="${courseWrapper.course.id}">
                                            <span class="cr"><i class="cr-icon fa fa-check"></i></span>
                                        </label>
                                    </div>
                                </div>

                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <tbody>
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
    </div>
</div>

</body>
</html>

