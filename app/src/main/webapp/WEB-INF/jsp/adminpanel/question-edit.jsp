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

    <jsp:include page="source.jsp"></jsp:include>
</head>
<body>

<div id="wrapper">

    <jsp:include page="navigation.jsp"></jsp:include>

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
                      <label class="pull-left control-label" for="questionText1">Question text</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <textarea class="form-control" id="questionText1" name="questionText" placeholder="Enter the question text" rows="4" required>${question.questionText}</textarea>
                      </div>
                    </dd>
                    <dt>
                      <label class="control-label pull-left" for="questionWeight1">Weight question</label>
                    </dt>
                    <dd>
                      <div class="form-group">
                        <input id="questionWeight1" minlenght="1" maxlength="25" name="questionWeight" type="text" value="${question.questionWeight}" placeholder="enter the weight question" class="form-control pull-left" required>
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
