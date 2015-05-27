<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>User edit page</title>

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
      <a class="navbar-brand" href="index.html">Admin Panel</a>
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
            <a href="/admin/userTestResult"><i class="fa fa-table fa-fw"></i> User test result</a>
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
          <div class="container">
            <h1 class="page-header">Add new test config</h1>

            <form data-toggle="validator" role="form" action="/admin/testConfig/${courseId}/create" method="POST"    class="form-horizontal">
              <fieldset>
                <dl class="dl-horizontal">
                  <dt>
                    <label class="pull-left control-label" for="title">Test config title</label>
                  </dt>
                  <dd>
                    <div class="form-group">
                      <input type="text" id="title" min="0" name="title">
                    </div>
                  </dd>
                  <dt>
                    <label class="pull-left control-label" for="questionCount">Question
                      count</label>
                  </dt>
                  <dd>
                    <div class="form-group">
                      <input type="number" id="questionCount" min="0" name="questionCount">
                    </div>
                  </dd>

                  <dt>
                    <label class="pull-left control-label" for="dateStart">Date start </label>
                  </dt>
                  <dd>
                    <div class="form-group col-lg-3">
                      <input type="date" id="dateStart" class="form-control" name="dateStart">
                    </div>
                  </dd>
                  <dt>
                    <label class="pull-left control-label" for="dateFinish">Date finish </label>
                  </dt>
                  <dd>
                    <div class="form-group col-lg-3">
                      <input type="date" id="dateFinish" class="form-control" name="dateFinish">
                    </div>
                  </dd>

                  <dt>
                    <label class="pull-left control-label" for="timeToTest">Time to
                      test</label>
                  </dt>
                  <dd>
                    <div class="form-group">
                      <input type="number" min="0" id="timeToTest"
                             name="timeToTest">
                    </div>
                  </dd>

                  <dt>
                    <label class="pull-left control-label" for="status">status</label>
                  </dt>
                  <dd>
                    <div class="form-group">
                      <div class="btn-group">
                        <select name="status" class="btn btn-default dropdown-toggle"
                                data-toggle="dropdown" aria-expanded="false" id="status">
                          <c:forEach items="${enumStatus}" var="status">
                            <option><a href="#">${status}</a></option>
                          </c:forEach>
                        </select>
                      </div>
                    </div>
                  </dd>
                </dl>
              </fieldset>
              <button type="submit" class="btn btn-primary btn-lg">Create</button>
            </form>
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
</div>
</body>
</html>
