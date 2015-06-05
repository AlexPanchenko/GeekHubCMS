<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
  <title>LogIn</title>

  <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
  <link href="<c:url value='/resources/vendors/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet"/>

</head>
<body>
<h1>LogIn</h1>

<form class="login-form well" action="/j_spring_security_check" method="post">


  <div class="form-group">
    <label for="email">Email address</label>
    <input type="email" class="form-control js-email" id="email" name="email" placeholder="Enter email">
  </div>

  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control js-pass" id="password" name="password" placeholder="Password">
  </div>

  <c:if test="${!empty SPRING_SECURITY_LAST_EXCEPTION}">
      <div class="err-msg">Invalid email or password</div>
  </c:if>
  <a href="/forgotPassword">forgot password</a>
  <input type="submit" value="Submit" class="btn btn-primary">
  <a href="/registration" class="pull-right" style="margin-top: 10px;">registration now</a>
</form>

<%--<script src="/resources/js/forms.js"></script>--%>

</body>
</html>
