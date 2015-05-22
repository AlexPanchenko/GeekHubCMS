<%--
  Created by IntelliJ IDEA.
  User: helldes
  Date: 16.05.2015
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
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

  <title>Question edit page</title>

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

      <a href="#" enabled="false"><i class="fa" style="color:blue"></i>${pageContext.request.userPrincipal.name}</a>
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
        <div class="col-lg-10">
          <c:choose>
            <c:when test="${action eq 'create'}">
              <h1 class="page-header">Add new question for course ${courseName}</h1>
              <form data-toggle="validator"  role="form" action="/admin/question"  method="POST" class="form-horizontal">
                <fieldset>
                  <dl class="dl-horizontal">
                    <dt>
                      <label class="pull-left control-label" for="questionText">Question text</label>
                    </dt>
                    <dt>
                      <input id="course" name="course" type="hidden" value=${courseId} >
                    </dt>
                    <dd>
                      <div class="form-group">
                        <textarea class="form-control" id="questionText" name="questionText" placeholder="Enter the question text" rows="4" required></textarea>
                      </div>
                    </dd>
                    <dt>
                      <label class="control-label pull-left" for="questionWeight">Weigth question</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <input id="questionWeight"  minlenght="1" maxlength="25" name="questionWeight" type="text" placeholder="enter the weight question" class="form-control pull-left" required>
                      </div>
                    </dd>
                    <dt>
                      <label class="control-label pull-left">Status question</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <input type="checkbox" id="questionStatus" name="questionStatus" value="true">
                        <input type="hidden"  name="questionStatus" value="false">
                      </div>
                    </dd>
                    <dt>
                      <label class="control-label pull-left">Your answer</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <input type="checkbox" id="myAnswer" name="myAnswer" value="true">
                        <input type="hidden"  name="myAnswer" value="false">
                      </div>
                    </dd>
                  </dl>
                </fieldset>
                <button type="submit" class="btn btn-primary btn-lg">Create</button>
              </form>
            </c:when>
            <c:otherwise>
              <h1 class="page-header">Edit ${question.id}</h1>
              <form data-toggle="validator"  role="form" action="/admin/question/${question.id}"  method="POST" class="form-horizontal">
                <fieldset>
                  <dl class="dl-horizontal">
                    <dt>
                      <label class="pull-left control-label" for="questionText">Question text</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <textarea class="form-control" id="questionText" name="questionText" placeholder="Enter the question text" rows="4" required>${question.questionText}</textarea>
                      </div>
                    </dd>
                    <dt>
                      <label class="control-label pull-left" for="questionWeight">Weight question</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <input id="questionWeight" minlenght="1" maxlength="25" name="questionWeight" type="text" value="${question.questionWeight}" placeholder="enter the weight question" class="form-control pull-left" required>
                      </div>
                    </dd>
                    <dt>
                      <label class="control-label pull-left">Status question</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <input type="checkbox" id="questionStatus" name="questionStatus" value="true">
                        <input type="hidden"  name="questionStatus" value="false">
                      </div>
                    </dd>
                    <dt>
                      <label class="control-label pull-left">Your answer</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <input type="checkbox" id="myAnswer" name="myAnswer" value="true">
                        <input type="hidden"  name="myAnswer" value="false">
                      </div>
                    </dd>
                  </dl>
                </fieldset>
                <button type="submit" class="btn btn-primary btn-lg">Update question</button>
              </form>
              <table class="table">
                 <c:forEach items="${answers}" var="answer">
                <tr>
                  <td>${answer.id}</td>
                  <td>${answer.answerText}</td>
                  <td>${answer.answerRight}</td>
                  <td class="text-center">
                    <a href="/admin/question/${questionId}/answer/${answer.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                    <a href="/admin/question/${questionId}/answer/${answer.id}/delete"><i class="fa fa-times"></i></a>
                  </td>
                </tr>
              </c:forEach>
              </table>
              <form data-toggle="validator"  role="form" action="/admin/question/${question.id}/answer/create"  method="POST" class="form-horizontal">
                <fieldset>
                  <dl class="dl-horizontal">
                    <dt>
                      <label class="pull-left control-label" for="answerText">Answer text</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <textarea class="form-control" id="answerText" name="answerText" placeholder="Enter the answer text" rows="2" required>${answer.answerText}</textarea>
                      </div>
                    </dd>
                    <dt>
                      <label class="control-label pull-left">Answer right?</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <input type="checkbox" id="answerRight" name="answerRight" value="true">
                        <input type="hidden"  name="answerRight" value="false">
                      </div>
                    </dd>
                  </dl>
                </fieldset>
                <button type="submit" class="btn btn-primary btn-lg">Create answer</button>
              </form>
            </c:otherwise>
          </c:choose>
          <div class="container">

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
