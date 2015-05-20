<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/bootstrap-them.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/courses.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>User Profile</title>
</head>
<body>
<%--

<c:forEach items="${courses}" var="coursesList">
&lt;%&ndash;<c:forEach items="${coursesList}" var="course">&ndash;%&gt;

<div>
<p>${coursesList.id}</p>
<p>   ${coursesList.name}<p>
<p>  ${coursesList.description} </p>
</div>
</c:forEach>
--%>

<div class="container">
    <div class="row">
        <div class="span5">
            <table class="table table-striped table-condensed">

                <thead>
                <tr>
                    <th>Name courses</th>
                    <th>Count question</th>
                    <th>Due date</th>
                    <th>Status</th>

                    <th>Time for test</th>

                    <th>Action  </th>

                </tr>
                </thead>
                <c:forEach items="${coursesList}" var="courses">

                    <tbody>
                    <tr>
                        <td>${courses.name}</td>


                        <c:forEach items="${courses.testConfigListBeens}" var="testConfig">
                            <td>${testConfig.questionCount}</td>
                            <td>${testConfig.dueDate}</td>
                            <td><span class="label label-success">${testConfig.status}</span></td>
                            <td>${testConfig.dateTimeToTest}</td>
                        </c:forEach>


                        <td><span class="label label-danger">
                            <a href="/student/deleteCourse/${courses.id}">Delete </a>
                            </span></td>

                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>
