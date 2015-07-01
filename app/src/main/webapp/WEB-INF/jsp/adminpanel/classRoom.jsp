<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <jsp:include page="../source.jsp"></jsp:include>

</head>
<body>

<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="alert alert-success text-center header-text">
                        <a href="/admin/createClassrom" class="pull-right glyphicon glyphicon-plus"></a>

                        <h2>Classrooms</h2>
                    </div>
                    <table class="table">
                        <thead class="alert alert-success">
                        <tr>
                            <th> Course</th>
                            <th> Name</th>
                            <th> Description</th>
                            <th> Teachers</th>
                            <th> Action</th>
                        </tr>
                        </thead>
                        <c:forEach items="${classRoomBeans}" var="classroom">
                            <tr>
                                <td>${classroom.courseId.name}</td>
                                <td>${classroom.name}</td>
                                <td>${classroom.description}</td>
                                <td><c:forEach items="${classroom.users}" var="user">
                                    <c:if test="${user.role == 'ROLE_TEACHER'}">
                                        ${user.lastName}<br>
                                    </c:if>
                                </c:forEach>
                                </td>
                                <td>
                                    <a href="/admin/classroom/${classroom.id}/edit"><i
                                            class="fa fa-pencil-square-o"></i></a>
                                    <a data-href="/admin/classroom-remove/${classroom.id}" data-toggle="modal"
                                       data-target="#delete-confirm"> <i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->
    <jsp:include page="../shared/deleteConfirmation.jsp"></jsp:include>
</div>
</body>
</html>
