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
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value="/resources/css/courses.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/css.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/timer.js"/>" type="text/javascript"></script>
    <link href="<c:url value="/resources/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"
          type="text/css">
</head>
<body class="back">
<div>
    <div class="testMain">
        <%--<div>--%>
            <div class="test-header">
                <span class="pull-left">${questions.get(0).course.name} Test</span>
                <div class="timer pull-right">
                    <span>Time to end:</span>
                    <span id="my_timer">00:${timeToTest}:00</span>
                </div>
            </div>
            <form>
                <c:set var="count" value="0" scope="page"/>
                <input type="hidden" id="test-id" value="${testId}">
                <c:forEach items="${questions}" var="question" varStatus="status">

                    <div class="question panel panel-default panel-info" id="question-${question.id}">
                        <div class="panel-heading">
                            <span>${status.index + 1}. ${question.questionText}</span>
                        </div>
                        <div class="panel-body">
                            <c:if test="${!(question.questionCode).isEmpty()}">
                                <div class="questionCode">
                                    <pre><b>${question.questionCode}</b></pre>
                                </div>
                            </c:if>
                            <div class="answers">
                                <c:forEach items="${question.answers}" var="answer">
                                    <c:choose>
                                        <c:when test="${question.manyAnswers eq true}">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" id="${answer.id}" class="answer">
                                            <span class="cr"><i
                                                    class="cr-icon fa fa-check"></i></span>${answer.answerText}
                                                </label>
                                            </div>
                                        </c:when>
                                        <c:when test="${question.manyAnswers eq false}">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="${question.id}" id="answer-${answer.id}"
                                                           class="answer">
                                            <span class="cr"><i
                                                    class="cr-icon fa fa-check"></i></span>${answer.answerText}
                                                </label>
                                            </div>
                                        </c:when>
                                    </c:choose>

                                </c:forEach>
                                <c:if test="${question.myAnswer eq true}">
                                    <div class="myAnswer">
                                        <p>Custom answer:</p>
                                        <textarea class="form-control" cols="100" rows="5"></textarea>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </form>
            <button class="btn btn-lg btn-primary pull-right" id="send-answers">Send answers</button>
        </div>
    <%--</div>--%>
</div>
<p class="text-center">Ukraine 2015</p>
<script src="/resources/js/test-page/testing.js" type="text/javascript"></script>
</body>
</html>
