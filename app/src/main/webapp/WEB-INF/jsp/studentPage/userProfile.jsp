<%--
  Created by IntelliJ IDEA.
  User: Jekainfinity
  Date: 27.05.2015
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <jsp:include page="source.jsp"></jsp:include>
</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="row">
        <div class="col-lg-6 col-lg-offset-2 ">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${user.firstName}&nbsp&nbsp${user.lastName}</h3>
                </div>
                <div class="panel-body ">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 col-lg-offset-1"> <img alt="User Pic" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="img-circle" width="170"  style="margin-top: 15px;"> </div>

                        <div class="col-md-6 col-lg-6 col-lg-offset-1">
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
                    <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="fa fa-pencil-square-o fa-2x"></i></a>
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
