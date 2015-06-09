<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Registration</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/vendors/bootstrap/dist/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">

    <script src="<c:url value="/resources/vendors/jquery/dist/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/vendors/bootstrap/dist/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/vendors/jquery-validation/dist/jquery.validate.min.js" />"></script>
</head>
<body>
<h1>Registration</h1>

<form id="registration-form" class="login-form well" action="/registration" method="post">

    <div class="form-group">
        <span class="must">*</span><label for="email">Email address</label>
        <input type="email" maxlength="39" class="form-control" id="email"
               name="email" placeholder="Enter email">
    </div>
    <div class="form-group ">
        <span class="must">*</span><label for="firstName">First Name</label>
        <input type="text" maxlength="24 " class="form-control" id="firstName" name="firstName"
               placeholder="Enter your first name">
    </div>
    <div class="form-group">
        <span class="must">*</span><label for="lastName">Last Name</label>
        <input type="text" maxlength="24" class="form-control" id="lastName" name="lastName"
               placeholder="Enter your last name" >
    </div>

    <div class="form-group">
        <span class="must">*</span><label for="password">Password</label>
        <input type="password" maxlength="50" class="form-control" id="password" name="password"
               placeholder="Password" >
    </div>
    <div class="form-group ">
        <span class="must">*</span><label for="password">Confirm password</label>
        <input type="password" maxlength="50" class="form-control" id="confirmPassword"
               name="confirmPassword"
               placeholder="Repeat your password" >
    </div>

    <div class="form-group ">
        <label for="phoneNumber">Phone</label>
        <input type="text" maxlength="29" class="form-control" id="phoneNumber" name="phoneNumber"
               placeholder="Enter your phone">
    </div>
    <div class="form-group ">
        <label for="skype">Skype</label>
        <input type="text" maxlength="39" class="form-control" id="skype" name="skype"
               placeholder="Enter your skype">
    </div>
    <div class="form-group ">
        <label for="birthday">Birthday</label>
        <input type="date" name="birthday" id="birthday" name="birthday" class="form-control js-birthday">
    </div>
    <p class="err-msg">${errorMessage}</p>
    <input type="submit" value="Register" class="btn btn-primary">

</form>
<%--<script src="/resources/js/forms.js"></script>--%>
<%--<script src="/resources/js/sign-in.js"></script>--%>

<script src="<c:url value="/resources/js/registrationValidate.js" />"></script>
</body>
</html>
