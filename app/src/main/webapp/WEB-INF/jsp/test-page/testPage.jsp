<%--
  Created by IntelliJ IDEA.
  User: helldes
  Date: 20.05.2015
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form>
    <input type="hidden" class="testId" id="${testId}">
    <c:forEach items="${questions}" var="question">

        <div class="question" id="${question.id}">
        <pre>
                ${question.questionText}
        </pre>
        </div>
        <div id="question${question.id}">
            <c:forEach items="${question.answers}" var="answer">
                <c:choose>
                    <c:when test="${question.manyAnswers eq true}">
                        <div class="col-sm-12">
                            <div class="checkbox">
                                <label style="font-size: 1.5em">
                                    <input type="checkbox" id="${answer.id}" checked class="answer">
                                    <span class="cr"><i class="cr-icon fa fa-check"></i></span>${answer.answerText}
                                </label>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-sm-12">
                            <div class="radio">
                                <label style="font-size: 1.5em">
                                    <input type="radio" name="${question.id}" id="${answer.id}" class="answer">
                                    <span class="cr"><i class="cr-icon fa fa-check"></i></span>${answer.answerText}
                                </label>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </div>
    </c:forEach>


</form>
<button class="btn btn-primary js-submit" onclick="sendAnswers()">Submit</button>
<script src="/resources/js/testing.js" type="text/javascript"></script>
</body>
</html>
