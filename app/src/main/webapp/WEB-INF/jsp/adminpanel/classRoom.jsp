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
                    <h1 class="alert alert-success text-center">
                        <a href="/admin/createClassrom" class="pull-left">Create classrom </a>
                        <b>Classroom manage</b></h1>
                    <table class="table">
                        <thead class="alert alert-success">
                        <tr>
                            <th class="text-center"> СlassRoom_ID </th>
                            <th class="text-center"> Course_Name </th>
                            <th class="text-center"> Classroom_Name </th>
                            <th class="text-center"> Classroom_Description </th>
                            <th class="text-center"> Teachers</th>
                            <th class="text-center"> Students</th>
                            <th class="text-center"> Action</th>
                        </tr>
                        </thead>
                        <c:forEach items="${classRoomBeans}" var="classroom">
                            <tr>
                                <td>${classroom.id}</td>
                                <td>${classroom.courseId.name}</td>
                                <td>${classroom.name}</td>
                                <td>${classroom.description}</td>
                            <%--<td>${classroom.teachers}</td>--%>
                                <td><c:forEach items="${classroom.users}" var="user">
                                    <c:if test="${user.role == 'ROLE_TEACHER'}">
                                        ${user.lastName}<br>
                                    </c:if>
                                </c:forEach>
                                </td>
                                <td class="text-black">
                                    <c:forEach items="${classroom.users}" var="user">
                                        <c:if test="${user.role == 'ROLE_STUDENT'}">
                                            ${user.lastName}<br>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="text-center">
                                    <a href="/admin/classroom/${classroom.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                    <a href="/admin/classroom-remove/${classroom.id}"> <i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    </div>
                </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
</body>
</html>
