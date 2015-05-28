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
        <h1>Test type create</h1>

        <div class="row">
            <div class="col-lg-12">
                <h1 class="alert alert-success text-center">
                    <a href="/admin/testConfig/create"><i class="glyphicon glyphicon-pencil pull-left"
                                                          title="Create new test config"></i></a>
                    <b>Test config manage</b></h1>
                <table class="table text-black">
                    <thead class="alert alert-success">
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Test type</th>
                        <th>Date start</th>
                        <th>Date finish</th>
                        <th>Time to test</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${testConfigList}" var="testConfig">
                            <tr>
                                <td>${testConfig.id}</td>
                                <td>${testConfig.title}</td>
                                <td>${testConfig.testType.name}</td>
                                <td>${testConfig.dateStart}</td>
                                <td>${testConfig.dateFinish}</td>
                                <td>${testConfig.timeToTest}m</td>
                                <td>${testConfig.status}</td>

                                <td class="text-center">
                                    <a href="/admin/testConfig/edit/${testConfig.id}"><i
                                            class="fa fa-pencil-square-o"></i></a>
                                    <a href="/admin/testConfig/delete/${testConfig.id}"> <i class="fa fa-times"></i></a>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>




