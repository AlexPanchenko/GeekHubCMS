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

    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>

<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">
        <h1>Test Types</h1>

        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-success text-center header-text">
                    <a href="/admin/testType/create"><i class="glyphicon glyphicon-plus pull-right"
                                                        title="Create new course"></i></a>
                    <h2>Test types</h2>
                </div>
                <table class="table text-black">
                    <thead class="alert alert-success">
                    <tr>
                        <th class="text-center"> Name</th>
                        <th class="text-center"> Course</th>
                        <th class="text-center"> Action</th>
                    </tr>
                    </thead>

                    <c:forEach items="${testTypeList}" var="testType">
                        <tr>
                            <td class="text-center">${testType.name}</td>
                            <td class="text-center">${testType.course.name}</td>
                            <td class="text-center">
                                <a href="/admin/testType/change/${testType.id}"><i
                                        class="fa fa-pencil-square-o"></i></a>
                                <a data-href="/admin/testType/delete/${testType.id}" data-toggle="modal"
                                   data-target="#delete-confirm"> <i class="fa fa-times"></i></a>
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
<jsp:include page="../shared/deleteConfirmation.jsp"></jsp:include>
</body>
</html>
