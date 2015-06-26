<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="alert alert-success text-center">
                        <b>Questions manage</b>
                    </h1>

                    <div class="panel panel-heading">
                        <label for="selectCourse">Select course:</label>
                        <select id="selectCourse" class="dropdown-toggle">
                            <option value="0">All Courses</option>
                            <c:forEach items="${courses}" var="course">
                                <c:if test="${course.id != currentCourse}">
                                    <option value="${course.id}">${course.name}</option>
                                </c:if>
                                <c:if test="${course.id == currentCourse}">
                                    <option selected value="${course.id}">${course.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>

                        <div class="testTypeWrap" style="display:none">
                            <label for="selectTestType">Select test type:</label>
                            <select id="selectTestType" class="dropdown-toggle">
                                <option value="0">All TestType</option>
                                <c:forEach items="${testTypeList}" var="testType">
                                    <option value="${testType.id}">${testType.name}</option>
                                </c:forEach>
                                <option value="0">withoutTestType</option>
                            </select>
                        </div>
                        <button id="questionsFilter">Filter</button>
                    </div>

                    <table class="table">
                        <thead class="alert alert-success">
                        <tr>
                            <th> ID</th>
                            <th> Text question</th>
                            <th> Weigth</th>
                            <th> Status</th>
                            <th> Your answer</th>
                            <th> Many answer</th>
                            <th class="text-center"> Action</th>
                        </tr>
                        </thead>
                        <tbody class="questions-box">

                        </tbody>
                    </table>


                    <div class="text-center">
                        <nav>
                            <ul id="course" class="pagination">

                                <li>
                                    <a href="#" aria-label="Previous" id="first-page">
                                        <span aria-hidden="true">First</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" aria-label="Previous" id="prev-page">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" aria-label="Next" id="next-page">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" aria-label="Previous" id="last-page">
                                        <span aria-hidden="true">Last</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../shared/deleteConfirmation.jsp"></jsp:include>
    <script>
        var currentCourse = ${currentCourse};
    </script>
    <script src="<c:url value='/resources/js/pagination.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/adminpanel/questions.js'/>" type="text/javascript"></script>
</body>
</html>
