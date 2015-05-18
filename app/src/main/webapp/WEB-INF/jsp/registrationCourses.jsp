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
    <h2>REGISTRATION COURSES</h2>


    <form method="post" action="/registrationCourses">
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
            <c:forEach items="${listCourses}" var="course">


            <tr>
                <td width="50">${course.id}</td>
                <td width="300">${course.name}</td>
                <td>${course.description}</td>
                <td width="50">
                    <div class="col-sm-12">
                        <div class="checkbox">
                            <label style="font-size: 1.5em">
                                <input type="checkbox" name="courseId" value="${course.id}" >
                                <span class="cr"><i class="cr-icon fa fa-check"></i></span>
                            </label>
                        </div>
                    </div>
                </td>
            </tr>
            </c:forEach>
        </table>
        <tbody>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
<td><input type="checkbox" name="courseId" value="${course.id}"/></td>
</body>
</html>

