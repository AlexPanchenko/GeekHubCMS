<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Assign test</title>

    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>

<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-success text-center header-text">
                    <h2>Assignment tests</h2>
                </div>
                <div class="selectCourse">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="selectTestConfig">Select test config: </label>
                                <select class="form-control" id="selectTestConfig">
                                    <c:forEach items="${testConfigList}" var="testConfig">
                                        <option value="${testConfig.id}">${testConfig.testType.course.name}: ${testConfig.title}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <%--<ul>--%>
                        <%--<c:forEach items="${testConfigList}" var="testConfig">--%>
                            <%--<c:choose>--%>
                                <%--<c:when test="${testConfig.questionCount <= fn:length(testConfig.testType.questionList)}">--%>
                                    <%--<li><a class="titleSelect" href="/admin/assignTest/${testConfig.id}">--%>
                                    <%--${testConfig.testType.course.name} | ${testConfig.testType.name} ${testConfig.title}--%>
                                    <%--</a></li>--%>
                                <%--</c:when>--%>
                                <%--<c:otherwise>--%>
                                    <%--<p class="titleSelect">(${testConfig.testType.course.name}--%>
                                        <%--| ${testConfig.testType.name})--%>
                                            <%--${testConfig.title} <span class="alert-warning">Warning : Not enough questions</span>--%>
                                    <%--</p>--%>
                                <%--</c:otherwise>--%>
                            <%--</c:choose>--%>
                        <%--</c:forEach>--%>
                    <%--</ul>--%>
                <%--</div>--%>


                <form data-toggle="validator" role="form" action="/admin/assignTest/save"
                      method="POST"
                      class="form-horizontal">
                    <input type="hidden" name="testConfigId" value="${currentTestConfig.id}">
                    <c:if test="${!(currentTestConfig eq null)}">

                        <h3>(${currentTestConfig.testType.course.name}
                            | ${currentTestConfig.testType.name})
                                ${currentTestConfig.title}</h3>

                        <table class="table text-black">
                            <thead class="alert alert-success">
                            <tr>
                                <th class="text-center"> Name</th>
                                <th class="text-center"> Email</th>
                                <th class="text-center"> Action</th>
                            </tr>
                            </thead>

                            <c:forEach items="${page.list}" var="userWrapper">
                                <tr>
                                    <td class="text-center">${userWrapper.user.firstName}</td>
                                    <td class="text-center">${userWrapper.user.email}</td>
                                    <td class="text-center">
                                        <c:choose>
                                            <c:when test="${userWrapper.isRegistered}">
                                                <div class="col-sm-12">
                                                    <div class="checkbox">
                                                        <label style="font-size: 1.0em">
                                                            <input type="checkbox" value="${userWrapper.user.id}" name="userId" checked disabled>
                                                            <a href="/admin/assignTest/delete/${currentTestConfig.id}/${userWrapper.user.id}"> <i
                                                                    class="fa fa-times"></i></a>
                                                        </label>
                                                    </div>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="col-sm-12">
                                                    <div class="checkbox">
                                                        <label style="font-size: 1.0em">
                                                            <input type="checkbox" value="${userWrapper.user.id}" name="userId">
                                                            <span class="cr"><i class="cr-icon fa fa-check"></i></span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </c:otherwise>

                                        </c:choose>

                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <button type="submit" class="btn btn-primary btn-lg">Save</button>

                        <div align="center">
                        </div>
                    </c:if>
                </form>
            </div>
        </div>

        <c:if test="${not empty page}">
            <c:url var="firstUrl" value="/admin/assignTest/${testConfigId}?p=1"/>
            <c:url var="lastUrl" value="/admin/assignTest/${testConfigId}?p=${page.end}"/>
            <c:url var="prevUrl" value="/admin/assignTest/${testConfigId}?p=${page.current - 1}"/>
            <c:url var="nextUrl" value="/admin/assignTest/${testConfigId}?p=${page.current + 1}"/>
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
                            <c:url var="pageUrl" value="/admin/assignTest/${testConfigId}?p=${i}"/>
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

</body>
</html>
