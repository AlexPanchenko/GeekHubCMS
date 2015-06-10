<%--
  Created by IntelliJ IDEA.
  User: helldes
  Date: 16.05.2015
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
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
                    <c:choose>
                        <c:when test="${action eq 'create'}">
                            <h1 class="page-header">Add new question for course ${courseName}</h1>

                            <form data-toggle="validator" name="create" id="create" role="form"
                                  action="/admin/course/${courseId}/question/create" method="POST"
                                  class="form-horizontal">
                                <fieldset>
                                    <dl class="dl-horizontal">
                                        <dt>
                                            <label class="pull-left control-label" for="questionText">Question
                                                text</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <textarea class="form-control" id="questionText" name="questionText"
                                                          placeholder="Enter the question text" rows="4"
                                                          required></textarea>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="control-label pull-left" for="questionWeight">Weigth
                                                question</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <input id="questionWeight" minlenght="1" maxlength="25"
                                                       name="questionWeight" type="text"
                                                       placeholder="enter the weight question"
                                                       class="form-control pull-left" required>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="control-label pull-left">Your answer</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <input type="checkbox" id="myAnswer" name="myAnswer" value="true">
                                                <input type="hidden" name="myAnswer" value="false">
                                            </div>
                                        </dd>
                                    </dl>
                                </fieldset>
                                <button type="submit" class="btn btn-primary btn-lg">Create</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <h1 class="page-header">Edit ${question.id}</h1>

                            <form data-toggle="validator" name="edit" id="edit" role="form"
                                  action="/admin/course/${question.course.id}/question/${question.id}/edit"
                                  method="POST" class="form-horizontal">
                                <fieldset>
                                    <dl class="dl-horizontal">
                                        <div class="form-group">
                                            <input class="form-control" id="id" name="id" type="hidden"
                                                   value="${question.id}">
                                            <input class="form-control" id="course" name="course" type="hidden"
                                                   value="${question.course.id}">
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
                                            <label class="pull-left control-label" for="questionText1">Question
                                                text</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <textarea class="form-control" id="questionText1" name="questionText"
                                                          placeholder="Enter the question text" rows="4"
                                                          required>${question.questionText}</textarea>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="pull-left control-label">Code text</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                                    <textarea class="form-control" name="questionCode"
                                                                              rows="4"
                                                                              required>${question.questionCode}</textarea>
                                            </div>
                                        </dd>

                                        <dt>
                                            <label class="control-label pull-left" for="questionWeight1">Weight
                                                question</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <input id="questionWeight1" minlenght="1" maxlength="25"
                                                       name="questionWeight" type="text"
                                                       value="${question.questionWeight}"
                                                       placeholder="enter the weight question"
                                                       class="form-control pull-left" required>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="control-label pull-left">Your answer</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <c:choose>
                                                    <c:when test="${question.myAnswer eq true}">
                                                        <input type="checkbox" id="myAnswerTrue" name="myAnswer"
                                                               checked>
                                                        <input type="hidden" name="myAnswer" value="false">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" id="myAnswerFalse" name="myAnswer">
                                                        <input type="hidden" name="myAnswer" value="false">
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </dd>
                                    </dl>
                                </fieldset>
                                <button type="submit" class="btn btn-primary btn-lg">Update question</button>
                            </form>
                            <table class="table">
                                <c:forEach items="${answers}" var="answer">
                                    <tr>
                                        <td>${answer.id}</td>
                                        <td>${answer.answerText}</td>
                                        <td>${answer.answerRight}</td>
                                        <td class="text-center">
                                            <a href="/admin/question/${questionId}/answer/${answer.id}/delete"><i
                                                    class="fa fa-times"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <form data-toggle="validator" role="form"
                                  action="/admin/course/${question.course.id}/question/${question.id}/answer/${answerSelect.id}/update"
                                  method="POST" class="form-horizontal">
                                <fieldset>
                                    <dl class="dl-horizontal">
                                        <dt>
                                            <label class="pull-left control-label" for="answerText">Answer text</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <textarea class="form-control" id="answerText" name="answerText"
                                                          placeholder="Enter the answer text" rows="2"
                                                          required>${answerSelect.answerText}</textarea>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="control-label pull-left">Answer right?</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <input type="checkbox" id="answerRight" name="answerRight">
                                                <input type="hidden" name="answerRight" value="false">
                                            </div>
                                        </dd>
                                    </dl>
                                </fieldset>
                                <button type="submit" class="btn btn-primary btn-lg">Update answer</button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                    <div class="container">

                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
    </div>

    <script src="<c:url value='/resources/js/adminpanel/answer-edit.js'/>" type="text/javascript"></script>
</body>
</html>
