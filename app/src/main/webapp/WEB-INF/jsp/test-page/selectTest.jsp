
<%--
  Created by IntelliJ IDEA.
  User: helldes
  Date: 20.05.2015
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
  function changeHref(href){
    $('a').attr('href',href);
  }
</script>
<html>
<head>
  <title>Select test</title>
  <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="/resources/css/bootstrap-them.min.css" rel="stylesheet" type="text/css">
  <link href="/resources/css/courses.css" rel="stylesheet" type="text/css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<div class="selectTest">

  <div>

    <h2>Select the test</h2>

    <form method="post" action="">
      <table class="table table-striped">
        <thead>
        <tr>
          <th>ID</th>
          <th>Title</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${testList}" var="test">
          <tr>
            <td width="300">${test.id}</td>
            <td>test №${test.id}</td>
            <td width="50">
              <div class="col-sm-12">
                <div class="radio">
                  <label style="font-size: 1.5em">
                    <input type="radio" name="courseId"  onclick="changeHref('/student/test/course/${course.id}/test/${test.id}')">
                    <span class="cr"><i class="cr-icon fa fa-check"></i></span>
                  </label>
                </div>
              </div>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </form>
    <a href="" name="link" class="btn btn-default">Select</a>
  </div>
</div>

</body>
</html>



