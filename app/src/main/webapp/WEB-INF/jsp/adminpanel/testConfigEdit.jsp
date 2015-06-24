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

    <title>Test config edit page</title>

    <jsp:include page="../source.jsp"></jsp:include>

</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div class="myW">
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-5">

                        <h1 class="page-header">Edit test config</h1>
                        <c:choose>
                            <c:when test="${empty testTypeList}">
                                <p>You must create "TestType"</p>
                            </c:when>
                            <c:otherwise>
                                <form data-toggle="validator" role="form"
                                      action="/admin/testConfig/edit/${testConfig.id}"
                                      method="POST">
                                    <fieldset>
                                        <div class="form-group">
                                            <label class="control-label" for="testType">Test type</label>
                                            <select class="form-control" id="testType" name="testType">
                                                <c:forEach items="${testTypeList}" var="testType">
                                                    <option value="${testType.id}"
                                                            <c:if test="${testType.id eq testConfig.testType.id}">selected</c:if>>${testType.name}
                                                        (${testType.course.name})
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label" for="title">Test config title</label>
                                            <input class="form-control" required type="text" id="title" min="0"
                                                   name="title"
                                                   value="${testConfig.title}">
                                        </div>


                                        <div class="form-group">
                                            <label class="pull-left control-label" for="questionCount">Question
                                                count</label>
                                            <input class="form-control" required type="number" id="questionCount"
                                                   min="0"
                                                   name="questionCount" value="${testConfig.questionCount}">
                                        </div>

                                        <div class="form-group">
                                            <label class="pull-left control-label" for="dateStart">Date start </label>
                                            <input required type="date" id="dateStart" class="form-control"
                                                   name="dateStart" ${testConfig.dateStart}
                                                   value='<fmt:formatDate type="date" value="${testConfig.dateStart}" pattern="yyyy-MM-dd" />'>
                                        </div>

                                        <div class="form-group">
                                            <label class="pull-left control-label" for="dateFinish">Date finish </label>
                                            <input required type="date" id="dateFinish" class="form-control"
                                                   name="dateFinish"
                                                   value='<fmt:formatDate type="date" value="${testConfig.dateFinish}" pattern="yyyy-MM-dd" />'>
                                        </div>

                                        <div class="form-group">
                                            <label class="pull-left control-label" for="timeToTest">Time to
                                                test</label>
                                            <input class="form-control" required type="number" min="0" id="timeToTest"
                                                   name="timeToTest" value="${testConfig.timeToTest}">
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label" for="status">Status</label>

                                            <select name="status"
                                                    class="btn btn-default dropdown-toggle form-control"
                                                    data-toggle="dropdown" aria-expanded="false"
                                                    id="status">
                                                <c:forEach items="${status}" var="status">
                                                    <option value="${status}"
                                                            <c:if test="${testConfig.status eq status}">selected</c:if>>${status}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </fieldset>
                                    <button type="submit" class="btn btn-primary">Save</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <!-- /.row -->
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
