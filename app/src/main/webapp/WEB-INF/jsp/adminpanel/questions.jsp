<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>AdminPanel</title>

  <link href="<c:url value='/resources/css/metisMenu.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/sb-admin-2.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/font-awesome.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/css.css'/>" rel="stylesheet">

  <script src="<c:url value='/resources/js/jquery.min.js'/>" type="text/javascript"></script>
  <script src="<c:url value="/resources/js/bootstrap.min.js"/>" type="text/javascript"></script>
  <script src="<c:url value='/resources/js/metisMenu.min.js'/>" type="text/javascript"></script>
  <script src="<c:url value='/resources/js/sb-admin-2.js'/>" type="text/javascript"></script>
  <script src="<c:url value='/resources/js/validator.js'/>" type="text/javascript"></script>

</head>
<body>

<div id="wrapper">

  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>

      </button>
      <a class="navbar-brand" href="/admin">Admin Panel</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">

      <a href="#" enabled="false"><i class="fa" style="color:blue"></i>TODO: Principal.name</a>
      </li>
      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
          <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
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
            <a href="/admin/users"><i class="fa fa-table fa-fw"></i> Users</a>
          </li>

          <li>
            <a href="/admin/course/list"><i class="fa fa-table fa-fw"></i> Courses</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-table fa-fw"></i> ClassRoom</a>
          </li>
          <li>
            <a href="#"><i class="fa fa-table fa-fw"></i> Tests</a>
          </li>
          <li>
            <a href="/admin/questions"><i class="fa fa-table fa-fw"></i>Base questions</a>
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
        <div class="col-lg-12">
          <h1 class="alert alert-success text-center">
            <a href="/admin/question/create" ><i class="glyphicon glyphicon-pencil pull-left" title="Create new question"></i></a>
            <b>Questions manage</b></h1>
          <table class="table">
            <thead class="alert alert-success">
            <tr>
              <th> ID </th>
              <th> Text question </th>
              <th> Weigth</th>
              <th class="text-center"> Action</th>
            </tr>
            </thead>
            <c:forEach items="${questions}" var="question">
              <tr>
                <td>${question.id}</td>
                <td>${question.questionText}</td>
                <td>${question.questionWeight}</td>
                <td class="text-center">
                  <a href="/admin/question/${question.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                  <a href="/admin/question/${question.id}/delete"><i class="fa fa-times"></i></a>
                </td>
              </tr>
            </c:forEach>
          </table>
          <div class="text-center">
            <nav>
              <ul class="pagination" >
                <li>
                  <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                  <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </div>
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
