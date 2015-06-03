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

  <title>TestConfig edit page</title>


    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-10">
                    <div class="container">
                        <h1 class="page-header">Edit test config</h1>

                        <form data-toggle="validator" role="form" action="/admin/testConfig/${courseId}/${testConfigBeen.id}/edit" method="POST"
                              class="form-horizontal">
                            <fieldset>
                                <dl class="dl-horizontal">
                                    <dt>
                                        <label class="pull-left control-label" for="title">Title</label>
                                    </dt>
                                    <dd>
                                        <div class="form-group">
                                            <input type="text" id="title" min="0" name="title" value="${testConfigBeen.tittle}">
                                        </div>
                                    </dd>
                                    <dt>
                                        <label class="pull-left control-label" for="questionCount">Question count</label>
                                    </dt>
                                    <dd>
                                        <div class="form-group">
                                            <input type="number" id="questionCount" min="0" name="questionCount" value="${testConfigBeen.questionCount}">
                                        </div>
                                    </dd>

                                    <dt>
                                        <label class="pull-left control-label" for="dateStart">Date start</label>
                                    </dt>
                                    <dd>
                                        <div class="form-group col-lg-3">
                                            <input type="date" id="dateStart" class="form-control" name="dateStart" value="${testConfigBeen.dateStartStr}">
                                        </div>
                                    </dd>
                                    <dt>
                                        <label class="pull-left control-label" for="dateStart">Date finish</label>
                                    </dt>
                                    <dd>
                                        <div class="form-group col-lg-3">
                                            <input type="date" id="dateFinish" class="form-control" name="dateFinish" value="${testConfigBeen.dateFinishStr}">
                                        </div>
                                    </dd>

                                    <dt>
                                        <label class="pull-left control-label" for="timeToTest">Date time to
                                            test</label>
                                    </dt>
                                    <dd>
                                        <div class="form-group">
                                            <input type="number" min="0" id ="timeToTest"  name="timeToTest" value="${testConfigBeen.timeToTest}">
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
    </div>
</div>

<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
</body>
</html>
