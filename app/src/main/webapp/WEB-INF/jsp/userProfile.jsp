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
                <>
                <th>Name courses</th>
                <th>Title</th>
                <th>Count question</th>
                <th>Date start</th>
                <th>Date finish</th>
                <th>Time to test</th>
                <th>Status</th>
                <th>Action</th>

                </tr>
                </thead>
                <c:forEach items="${coursesList}" var="courses">

                    <tbody>
                    <tr>
                        <td>${courses.name}</td>


                        <c:forEach items="${courses.testConfigListBeens}" var="testConfig">
                            <td>${testConfig.tittle}</td>
                            <td align="center">${testConfig.questionCount}</td>
                            <td>${testConfig.dateStart}</td>
                            <td>${testConfig.dateFinish}</td>
                            <td align="center">${testConfig.timeToTest}</td>
                            <td><span class="label label-success">${testConfig.status}</span></td>
                            <td><span class="label label-danger"><a href="/student/deleteCourse/${courses.id}">Unregister </a>
                            </span></td>
                        </c:forEach>



                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>
