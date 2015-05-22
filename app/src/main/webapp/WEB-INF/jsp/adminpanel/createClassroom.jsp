<%--
  Created by IntelliJ IDEA.
  User: Aleksander
  Date: 21.05.2015
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <script src="<c:url value='/resources/js/jquery.min.js'/>" type="text/javascript"></script>
  <script src="<c:url value='/resources/js/jquery-2.1.4.min.js'/>" type="text/javascript"></script>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <link href="<c:url value='/resources/css/metisMenu.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/sb-admin-2.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/font-awesome.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/css.css'/>" rel="stylesheet">
  <script>
    function showUsers(course){
      $.ajax({
        url:"ajax/usersOnCourse",
        type:"post",
        data:{course:course},
        success:function(data) {
          $("#users").html(data);
        }
      });
    }
  </script>
</head>
<body>
  <p>Course name</p>
  <select size='1' id="course">
    <c:forEach items="${courses}" var="s">
      <option value="${s.id}">${s.name}</option>
    </c:forEach>
  </select>
  <p>Teacher name</p>
  <select size='1' id="teacher">
    <c:forEach items="${teachers}" var="t">
      <option value="${t.id}">${t.lastName}</option>
    </c:forEach>
  </select>
  <p><input type='button' value='Show users' onclick = 'showUsers($("#course").val());'/></p>
  <div id="users">  </div>
</body>
</html>
