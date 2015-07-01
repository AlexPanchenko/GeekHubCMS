<%--
  Created by IntelliJ IDEA.
  User: Aleksander
  Date: 21.05.2015
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <jsp:include page="../source.jsp"></jsp:include>


</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6">
                    <form id="save-classroom">
                        <div class="form-group">
                            <label for="classroom-name">Classroom name</label>
                            <input type="text" id="classroom-name" name="classroom-name" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="classroom-description">Description</label>
                            <input type="text" id="classroom-description" name="classroom-description" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="course">Course</label>
                            <select id="course" class="form-control">
                                <c:forEach items="${courses}" var="course">
                                        <option value="${course.id}">${course.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="teacher">Teacher</label>
                            <select id="teacher" class="form-control">
                                <c:forEach items="${teachers}" var="teacher">
                                    <option value="${teacher.id}">${teacher.firstName}
                                        &nbsp; ${teacher.lastName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button class="btn btn-lg btn-primary" type="submit">Save</button>
                    </form>
                    <div id="alert-box"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/vendors/jquery-validation/dist/jquery.validate.min.js" />"></script>
<script src="<c:url value='/resources/js/adminpanel/classroom-edit.js'/>" type="text/javascript"></script>
</body>
</html>
