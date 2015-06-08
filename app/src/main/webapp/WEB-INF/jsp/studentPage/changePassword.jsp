<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="row">
        <div class="col-lg-6 col-md-6 col-lg-offset-2 col-md-offset-2 " style="width: 600px;">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${user.firstName}&nbsp&nbsp${user.lastName}</h3>
                </div>
                <div class="panel-body ">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 col-lg-offset-1 col-md-offset-1"> <img alt="User Pic" src="<c:url value='/resources/img/slowpoke.png'/>" class="img-rounded" width="170"  style="margin-top: 15px;"> </div>

                        <div class="col-md-6 col-lg-6 col-lg-offset-1 col-md-offset-1">
                            <table class="table table-user-information text-black">
                                <tbody>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="${user.email}">${user.email}</a></td>
                                </tr>
                                <tr>
                                    <td>Registrtion date:</td>
                                    <td>${user.registrationDate}</td>
                                </tr>
                                <tr>
                                    <td>Date of Birth</td>
                                    <td>${user.birthDay}</td>
                                </tr>
                                <tr>
                                    <td>Skype</td>
                                    <td>${user.skype}</td>
                                </tr>
                                <td>Phone Number</td>
                                <td>${user.phoneNumber}</td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <form method="get" action="/student/users/${user.id}/changepassword2">
                        <input type="password" placeholder="Old password" name="oldpassword">
                        <br> <br>
                        <input type="password" placeholder="New password" name="newpassword">
                        <br> <br>
                        <input type="password" placeholder="Confirm new password" name="confirmpassword">
                        <br> <br>
                        <button type="submit">Change password</button>
                    </form>
                </div>
            </div>
        </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->
</div>
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
</body>
</html>
