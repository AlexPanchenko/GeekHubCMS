<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <h1>Courses</h1>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="alert alert-success text-center">
                        <a href="/admin/course/create" ><i class="glyphicon glyphicon-pencil pull-left" title="Create new course"></i></a>
                        <b>Courses manage</b></h1>
                    <table class="table text-black">
                        <thead class="alert alert-success">
                        <tr>
                            <th class="text-center"> ID </th>
                            <th class="text-center"> Name </th>
                            <th class="text-center"> Description </th>
                            <th class="text-center"></th>
                            <th class="text-center"> Action</th>
                        </tr>
                        </thead>

                        <c:forEach items="${courses}" var="course">
                            <tr>
                                <td class="text-center">${course.id}</td>
                                <td class="text-center">${course.name}</td>
                                <td class="text-center">${course.description}</td>
                                <td class="text-center">
                                </td>
                                <td class="text-center">
                                    <a href="/admin/course/${course.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                    <a href="/admin/course-remove/${course.id}"> <i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>

</body>
</html>
