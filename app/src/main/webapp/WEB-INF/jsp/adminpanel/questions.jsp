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
                            <option id="0">All Courses</option>
                            <c:forEach items="${courses}" var="course">
                                <c:if test="${course.id != currentCourse}">
                                    <option id=${course.id}>${course.name}</option>
                                </c:if>
                                <c:if test="${course.id == currentCourse}">
                                    <option selected id=${course.id}>${course.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>

                        <div class="testTypeWrap">
                            <label for="selectTestType">Select test type:</label>
                            <select id="selectTestType" class="dropdown-toggle">
                                <option id="testType0">All TestType</option>
                                <c:forEach items="${testTypeList}" var="testType">
                                    <option id=${testType.id}>${testType.name}</option>
                                </c:forEach>
                                <option id="0">withoutTestType</option>
                            </select>
                        </div>
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
                        <%--<c:set var="courseIdNow" value="2"/>--%>
                        <c:forEach items="${questions}" var="question">
                            <%--<c:if test="${question.course.id == courseIdNow}">--%>
                            <tr>
                                <td>${question.id}</td>
                                <td>${question.questionText}</td>
                                <td>${question.questionWeight}</td>
                                <td>${question.questionStatus}</td>
                                <td>${question.myAnswer}</td>
                                <td>${question.manyAnswers}</td>
                                <td class="text-center">
                                    <a href="/admin/course/${question.course.id}/question/${question.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                    <a data-href="/admin/course/${question.course.id}/question/${question.id}/delete"
                                            data-target="#delete-confirm" data-toggle="modal"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <%--</c:if>--%>
                        </c:forEach>
                    </table>
                    <div class="text-center">
                        <nav>
                            <ul class="pagination">
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                            <a class="btn btn-success glyphicon glyphicon-plus pull-right" id="addQuestion">Add
                                question</a>
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
    <script src="<c:url value='/resources/js/adminpanel/questions.js'/>" type="text/javascript"></script>
</body>
</html>
