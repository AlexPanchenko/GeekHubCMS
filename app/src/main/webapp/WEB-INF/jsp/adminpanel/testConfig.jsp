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
        <h1>Test configs</h1>

        <div class="row">
            <div class="col-lg-12">
                <h1 class="alert alert-success text-center">
                    <a href="/admin/testConfig/create"><i class="glyphicon glyphicon-pencil pull-left"
                                                          title="Create new test config"></i></a>
                    <b>Test config manage</b></h1>
                <table class="table text-black" class="text-center">
                    <thead class="alert alert-success">
                    <tr class="text-center">
                        <th class="text-center">ID</th>
                        <th class="text-center">Title</th>
                        <th class="text-center">Test type</th>
                        <th class="text-center">Date start</th>
                        <th class="text-center">Date finish</th>
                        <th class="text-center">Time to test</th>
                        <th class="text-center">Status</th>
                        <th class="text-center">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${testConfigList}" var="testConfig">
                            <tr class="text-center">
                                <td class="text-center">${testConfig.id}</td>
                                <td class="text-center">${testConfig.title}</td>
                                <c:choose>
                                    <c:when test="${testConfig.testType eq null}">
                                        <td class="text-center">-</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td class="text-center">${testConfig.testType.name} (${testConfig.testType.course.name})</td>
                                    </c:otherwise>
                                </c:choose>

                                <td class="text-center"><fmt:formatDate type="date"
                                                                        value="${testConfig.dateStart}" /></td>
                                <td class="text-center"><fmt:formatDate type="date"
                                                                        value="${testConfig.dateFinish}" /></td>
                                <td class="text-center">${testConfig.timeToTest}m</td>
                                <td class="text-center">${testConfig.status}</td>

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




