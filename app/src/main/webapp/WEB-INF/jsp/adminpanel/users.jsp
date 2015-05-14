<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>User edit page</title>

  <link href="<c:url value='/resources/css/metisMenu.min.css'/>" rel="stylesheet" />
  <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet" />
  <link href="<c:url value='/resources/css/sb-admin-2.css'/>" rel="stylesheet" />
  <link href="<c:url value='/resources/css/font-awesome.min.css'/>" rel="stylesheet" />
  <link href="<c:url value='/resources/css/css.css'/>" rel="stylesheet">

  <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
  <script src="<c:url value='/resources/js/validator.js'/>"></script>
  <script src="<c:url value='/resources/js/metisMenu.min.js'/>"></script>
  <script src="<c:url value='/resources/js/sb-admin-2.js'/>"></script>
  <script src="<c:url value='/resources/js/validator.js'/>"></script>

</head>
<body>

<div id="wrapper">

  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>

      </button>
      <a class="navbar-brand" href="index.html">Admin Panel</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">

      <a href="#" enabled="false"><i class="fa" style="color:blue"></i>TODO: Principal.name</a>
      </li>
      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
          <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
          <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
          </li>
          <li class="divider"></li>
          <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
          </li>
        </ul>
        <!-- /.dropdown-user -->
      </li>
      <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
      <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
          <li>
            <a href="/dashboard/users"><i class="fa fa-table fa-fw"></i> Users</a>
          </li>

          <li>
            <a href="/dashboard/courses"><i class="fa fa-table fa-fw"></i> Courses</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-table fa-fw"></i> ClassRoom</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-table fa-fw"></i> Tests</a>
          </li>

        </ul>
      </div>
      <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
  </nav>

  <!-- Page Content -->
  <div id="page-wrapper">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-10">
          <h1 class="page-header">User <b>${user.id}</b> profile</h1>
          <div class="container">

            <table class="table-bordered table-striped" style="width: 100%">
              <tr>
                <th><input type="text" style="width: 100%" placeholder="Введите текст"></th>
                <th><input type="text" style="width: 100%" placeholder="Введите текст"></th>
              </tr>
              <thead class="alert-success">
              <tr>
                <th> Email </th>
                <th> Name </th>
                <th> Lastname </th>
                <th> Phone </th>
                <th> Skype </th>
                <th> Action </th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>11111 </td>
                <td> <button class="btn btn-success btn-large btn-primary" type="button">Show user profile</button></td>
              </tr>
              <tr>
                <td>111111 </td>
                <td>11111111 </td>
                <td> <button class="btn btn-success btn-large btn-primary" type="button">Show user profile</button></td>
              </tr>
              <tr>
                <td> 11111111</td>
                <td> 11111111</td>
                <td> <button class="btn btn-success btn-large btn-primary" type="button">Show user profile</button></td>
              </tr>
              </tbody>
            </table>
            <div style="width: 100%">
              <ul class="pagination pagination-sm" style="margin: auto">
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
              </ul>
            </div>
          </div>
        </div>
        <!-- /.col-lg-12 -->
      </div>
      <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
  </div>
  <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

</body>
</html>

