<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Test type</title>

    <jsp:include page="source.jsp"></jsp:include>
</head>
<body>

<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="alert alert-success text-center">
                    <a href="/admin/testType/create"><i class="glyphicon glyphicon-pencil pull-left"
                                                        title="Create new course"></i></a>
                    <b>Test type manage</b></h1>
                <table class="table">
                    <thead class="alert alert-success">
                    <tr>
                        <th> ID</th>
                        <th> Name</th>
                        <th> Course</th>
                        <th class="text-center"> Action</th>
                    </tr>
                    </thead>

                    <c:forEach items="${testTypeList}" var="testType">
                        <tr>
                            <td>${testType.id}</td>
                            <td>${testType.name}</td>
                            <td>${testType.course.name}</td>
                            <td class="text-center">
                                <a href="/admin/testType/${testType.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                <a href="/admin/testType-remove/${testType.id}"> <i class="fa fa-times"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div align="center">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
