<%--
  Created by IntelliJ IDEA.
  User: helldes
  Date: 20.05.2015
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Test</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/courses.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <h1 align="center">Test     <small>Course name:${questions.get(0).course.name}</small></h1>
            </div>
        </div>
<form>
    <input type="hidden" class="testId" id="${testId}">
    <c:forEach items="${questions}" var="question">
        <div class="radius">
            <div class="question" id="${question.id}">
                    ${question.questionText}
                <div class="questionCode">
                    <pre><b>${question.questionCode}</b></pre>
                </div>
            </div>
            <div class="answer" id="question${question.id}">
                <c:forEach items="${question.answers}" var="answer">
                    <c:choose>
                        <c:when test="${question.manyAnswers eq true}">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" id="${answer.id}" class="answer">
                                        <span class="cr"><i class="cr-icon fa fa-check"></i></span>${answer.answerText}
                                    </label>
                                </div>
                        </c:when>
                        <c:otherwise>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="${question.id}" id="${answer.id}" class="answer">
                                        <span class="cr"><i class="cr-icon fa fa-check"></i></span>${answer.answerText}
                                    </label>
                                </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
</form>
<button class="btn btn-primary js-submit" onclick="sendAnswers()">Submit</button>
<script src="/resources/js/testing.js" type="text/javascript"></script>
</div>
</body>
</html>
