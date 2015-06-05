<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>registration on courses</title>

    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>

    <jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Page Content -->
        <div id="page-content-wrapper">

            <div class="coursesRegisTable">

                <div>
                    <h2>REGISTRATION ON COURSES</h2>

                    <form method="post" action="/student/registrationCourses">
                        <table class="table table-striped text-black">
                            <thead>
                            <tr>
                                <th>Number</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Registration</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listCourses}" var="courseWrapper">

                            <tr>
                                <td width="50">${courseWrapper.course.id}</td>
                                <td width="300">${courseWrapper.course.name}</td>
                                <td>${courseWrapper.course.description}</td>
                                <td width="50">
                                    <c:choose>
                                        <c:when test="${courseWrapper.isRegistered}">
                                            <div class="col-sm-12">
                                                <div class="checkbox">
                                                    <label style="font-size: 1.5em">
                                                        <input type="checkbox" checked>
                                                    </label>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col-sm-12">
                                                <div class="checkbox">
                                                    <label style="font-size: 1.5em">
                                                        <input type="checkbox" name="courseId" value="${courseWrapper.course.id}">
                                                    </label>
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <button type="submit" class="btn btn-primary">Save</button>
                    </form>
                </div>
        </div>
        <!-- /#page-content-wrapper -->

</div>
</div>
</body>
</html>

