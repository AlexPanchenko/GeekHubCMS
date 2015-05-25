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
  <link href="/resources/css/bootstrap-them.min.css" rel="stylesheet" type="text/css">
  <link href="/resources/css/courses.css" rel="stylesheet" type="text/css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<form>
  <table class="table table-striped">
    <thead>
    <tr>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${questions}" var="question">
      <tr>
        <td style="background-color: lightblue">${question.questionText}<input type="hidden" name="question${question.id}" value="${question.id}"></td>
      </tr>
      <tr>
      <c:forEach items="${question.answers}" var="answer">
        <table>
          <tr>
            <td width="30"><input type="checkbox" name="answer${answer.id}"></td>
            <td>${answer.answerText}</td>
          </tr>
        </table>
      </c:forEach>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <input type="submit" value="Submit" >
</form>
</body>
</html>
