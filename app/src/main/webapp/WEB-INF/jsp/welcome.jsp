<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>LogIn/SignIn</title>

    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/bootstrap-them.min.css" rel="stylesheet" type="text/css">

    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/forms.js" />"></script>
    <script src="<c:url value="/resources/js/sign-in.js" />"></script>
    <script src="<c:url value="http://code.jquery.com/jquery-1.11.3.min.js" />"></script>
</head>
<body>
<h1>LogIn/SignIn</h1>
<form class="login-form well" action="j_spring_security_check" method="post">

    <div class="form-group">
        <label for="email">Email address</label>
        <input type="email" class="form-control js-email" id="email" placeholder="Enter email">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control js-pass" id="password" placeholder="Password">
    </div>
    <div class="form-group field-reg js-field-reg">
        <label for="password">Confirm password</label>
        <input type="password" class="form-control js-confirm-pass" id="confirmPassword"
               placeholder="Repeat your password">
    </div>
    <div class="form-group js-field-reg field-reg">
        <label for="name">Name</label>
        <input type="text" class="form-control js-name" id="name" placeholder="Enter your name">
    </div>
    <div class="form-group js-field-reg field-reg">
        <label for="name">Last name</label>
        <input type="text" class="form-control js-lastName" id="lastName" placeholder="Enter your last name">
    </div>
    <div class="form-group js-field-reg field-reg">
        <label for="name">Phone</label>
        <input type="text" class="form-control js-phone" id="phone" placeholder="Enter your phone">
    </div>
    <div class="form-group js-field-reg field-reg">
        <label for="name">Skype</label>
        <input type="text" class="form-control js-skype" id="skype" placeholder="Enter your skype">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" class="js-register"/> I am a new user
        </label>
    </div>
    <input type="submit" >Submit</input>

</form>
<script src="/resources/js/forms.js"></script>
<script src="/resources/js/sign-in.js"></script>

</body>
</html>
