<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>LogIn</title>

    <link href="<c:url value='/resources/vendors/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet"/>
    <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js" />"></script>
    <link href="<c:url value="/resources/css/style.css"/> " rel="stylesheet" type="text/css">

</head>
<body class="auth-page">
    <div class="well center-block login-form">
        <form id="loginForm" method="POST" action="/j_spring_security_check" novalidate="novalidate">
            <div class="form-group">
                <label for="email" class="control-label">Username</label>
                <input type="email" class="form-control" id="email" name="email" value="" required=""
                       title="Please enter you email" placeholder="example@gmail.com">
                <span class="help-block"></span>
            </div>
            <div class="form-group">
                <label for="password" class="control-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" value="" required=""
                       title="Please enter your password">
                <span class="help-block"></span>
            </div>
            <c:if test="${!empty SPRING_SECURITY_LAST_EXCEPTION}">
                <div class="alert alert-danger">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Error!</strong> Username or password is incorrect.
                </div>
            </c:if>
            <button type="submit" class="btn btn-success btn-block">Login</button>
            <a href="/registration" class="btn btn-default btn-block">Sign up</a>
            <a href="/forgotPassword" class="btn btn-default btn-block">Forgot password?</a>
        </form>
    </div>
</body>
</html>
