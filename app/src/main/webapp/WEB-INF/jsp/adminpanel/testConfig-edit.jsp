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
          <div class="container">
            <h1 class="page-header">Edit test config</h1>

            <form data-toggle="validator" role="form" action="/admin/testConfig/${testConfigBeen.id}/edit" method="POST"
                  class="form-horizontal">
              <fieldset>
                <dl class="dl-horizontal">
                  <dt>
                    <label class="pull-left control-label" for="questionCount">Question count</label>
                  </dt>
                  <dd>
                    <div class="form-group">
                      <input type="number" id="questionCount" min="0" name="questionCount" value="${testConfigBeen.questionCount}">
                    </div>
                  </dd>

                  <dt>
                    <label class="pull-left control-label" for="dueDate">Due date</label>
                  </dt>
                  <dd>
                    <div class="form-group">
                      <input type="date" id="dueDate" class="form-control" name="dueDate" value="${testConfigBeen.dueDate}">
                    </div>
                  </dd>

                  <dt>
                    <label class="pull-left control-label" for="dateTimeToTest">Date time to
                      test</label>
                  </dt>
                  <dd>
                    <div class="form-group">
                      <input type="date" id ="dateTimeToTest" class="form-control" name="dateTimeToTest" value="${testConfigBeen.dateTimeToTest}">
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
              <button type="submit" class="btn btn-primary btn-lg">Update</button>
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
