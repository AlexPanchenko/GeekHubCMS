<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
            <h1 class="alert alert-success text-center"><b>Users test result</b></h1>

            <h1>${fn:toUpperCase(courseName)}</h1>

            <div class="panel panel-heading">
                <div class="js-slide">
                    <select id="selectCourse">
                        <option disabled="disabled" selected>Select the course</option>
                        <c:forEach items="${coursesList}" var="course">
                            <option value="${course.name}" <c:if test="${course.name eq courseName}">selected</c:if> id="${course.id}">${course.name}</option>
                        </c:forEach>
                    </select>
                    <br>
                </div>
            </div>

            <table class="table table-striped table-condensed table-bordered">
                <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Course</th>
                    <th>Test</th>
                    <th>Date</th>
                    <th>Mark</th>
                    <th>Action</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${page.list}" var="wrap">
                    <tr>
                        <td>${wrap.user.firstName}</td>
                        <td>${wrap.user.lastName}</td>
                        <td>${wrap.user.email}</td>
                        <td>${wrap.course.name}</td>
                        <td>${wrap.testConfig.title}</td>
                        <td><fmt:formatDate type="both"
                                            value="${wrap.testAssignment.datePassed}" /></td>
                        <c:if test="${!wrap.review}">
                            <td>must be cheked</td>
                        </c:if>
                        <c:if test="${wrap.review}">
                            <td>${fn:substringBefore((wrap.score / wrap.testConfig.questionCount)*100, '.')}%</td>
                        </c:if>
                        <c:if test="${wrap.testAssignment.datePassed != null}">
                            <td class="text-center"><a href="/admin/answerResult/${wrap.user.id}" class="btn btn-default">see test</a></td>
                        </c:if>
                        <c:if test="${wrap.testAssignment.datePassed == null}">
                            <td class="text-center"><a class="btn btn-default" aria-disabled="true">Not finish</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


    <c:if test="${page.maxPages > 1}">
        <c:url var="firstUrl" value="/admin/userTestResult/${courseName}?p=1"/>
        <c:url var="lastUrl" value="/admin/userTestResult/${courseName}?p=${page.end}"/>
        <c:url var="prevUrl" value="/admin/userTestResult/${courseName}?p=${page.current - 1}"/>
        <c:url var="nextUrl" value="/admin/userTestResult/${courseName}?p=${page.current + 1}"/>
        <div align="center">
            <nav>
                <ul class="pagination">
                    <c:choose>
                        <c:when test="${page.current == 1}">
                            <li class="disabled"><a href="#">&lt;&lt;</a></li>
                            <li class="disabled"><a href="#">&lt;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${firstUrl}">&lt;&lt;</a></li>
                            <li><a href="${prevUrl}">&lt;</a></li>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach var="i" begin="${page.begin}" end="${page.end}">
                        <c:url var="pageUrl" value="/admin/userTestResult/${courseName}?p=${i}"/>
                        <c:choose>
                            <c:when test="${i ==page.current}">
                                <li class="active"><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${page.current == page.end}">
                            <li class="disabled"><a href="#">&gt;</a></li>
                            <li class="disabled"><a href="#">&gt;&gt;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${nextUrl}">&gt;</a></li>
                            <li><a href="${lastUrl}">&gt;&gt;</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </div>
    </c:if>
    </div>
</div>

    <script>
        (function () {
            var selectCourse = function () {
                var selectedCourse = $('#selectCourse option:selected');
                if (selectedCourse.attr('id') != 0) {
                    window.location.replace("/admin/userTestResult/" + selectedCourse.attr('id'));
                } else {
                    $("#addQuestion").show();
                    $(".testTypeWrap").show();

                    $('addQuestion').attr("href", "/admin/course/" + selectedCourse.attr('id') + "/question/create");
                    var redirectTo = "/admin/course/" + selectedCourse.attr('id') + "/questions/";
                    window.location.replace(redirectTo);
                }

            };

            //Event handlers
            $("#selectCourse").on("change", selectCourse);
        })();
    </script>


<!-- /#wrapper -->
</body>
</html>
