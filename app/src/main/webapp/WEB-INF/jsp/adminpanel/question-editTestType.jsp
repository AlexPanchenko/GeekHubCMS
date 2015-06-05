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

    <title>Question edit page</title>

    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>

<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">

        <div class="container-fluid">
            <div class="row">

                <div class="col-lg-10">

                    <h1 class="page-header">Edit question № ${question.id} for course ${courseName}</h1>

                    <form data-toggle="validator" name="edit" id="edit" role="form"
                          action="/admin/course/${question.course.id}/testType/question/${question.id}/edit"
                          method="POST" class="form-horizontal">
                        <fieldset>
                            <dl class="dl-horizontal">
                                <div class="form-group">
                                    <input class="form-control" id="id" name="id"
                                           type="hidden" value="${question.id}">
                                    <input class="form-control" id="course" name="course"
                                           type="hidden" value="${question.course.id}">
                                    <input class="form-control" id="oldTestTypeId" name="oldTestTypeId"
                                           type="hidden" value="${testTypeId}">
                                </div>
                                <dt>
                                    <label class="pull-left control-label"
                                           for="selectTestType2">TestType</label>
                                </dt>
                                <dd>
                                    <div class="form-group">
                                        <select id="selectTestType2" name="selectTestType2"
                                                onchange="changeValueUpdate()"
                                                class="dropdown-toggle form-control">
                                            <option id="0">All TestType</option>
                                            <c:forEach items="${listTestType}" var="testType">
                                                <c:choose>
                                                    <c:when test="${curentTestTypeId == testType.id}">
                                                        <option selected value="${testType.id}"
                                                                id=${testType.id}>${testType.name}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${testType.id}"
                                                                id=${testType.id}>${testType.name}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <input type="hidden" id="testTypeIdUpdate" name="testTypeIdUpdate"
                                           value=${curentTestTypeId}>
                                </dd>
                                <dt>
                                    <label class="pull-left control-label"
                                           for="questionText">Question text</label>
                                </dt>
                                <dd>
                                    <div class="form-group">
                                                                    <textarea class="form-control" id="questionText"
                                                                              name="questionText"
                                                                              placeholder="Enter the question text"
                                                                              rows="4">${question.questionText}</textarea>
                                    </div>
                                </dd>
                            </dl>
                        </fieldset>
                        <button type="submit" class="btn btn-primary btn-lg">Update
                            question
                        </button>
                    </form>


                    <div class="container">

                    </div>
                    <!-- /.col-lg-12 -->
                </div>

            </div>
        </div>
    </div>

    <!-- Page Content -->


    <script src="<c:url value='/resources/js/adminpanel/question-editTestType.js'/>" type="text/javascript"></script>
</div>
</body>
</html>
