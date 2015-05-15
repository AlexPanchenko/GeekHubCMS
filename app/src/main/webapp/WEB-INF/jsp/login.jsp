<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>LogIn</title>

  <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="/resources/css/bootstrap-them.min.css" rel="stylesheet" type="text/css">

  <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  <script src="<c:url value="/resources/js/forms.js" />"></script>
  <script src="<c:url value="/resources/js/sign-in.js" />"></script>
  <script src="<c:url value="http://code.jquery.com/jquery-1.11.3.min.js" />"></script>
</head>
<body>
<h1>LogIn</h1>
<c:if test="${not empty error}">
  <div class="error">${error}</div>
</c:if>

<form class="login-form well" action="/login" method="post">


  <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" class="form-control js-email" id="email" name="login" placeholder="Enter email">
  </div>

  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control js-pass" id="password" name="password" placeholder="Password">
  </div>

  <input type="submit" value="Submit">

</form>
<%--<script src="/resources/js/forms.js"></script>--%>
<script src="/resources/js/sign-in.js"></script>

</body>
</html>
