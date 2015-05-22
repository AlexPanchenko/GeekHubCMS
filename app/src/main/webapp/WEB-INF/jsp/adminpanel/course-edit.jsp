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
                <div class="container">

                    <h1 class="page-header">Edit ${course.name}</h1>


                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="alert alert-success text-center">
                                <a href="/admin/course/create"><i class="glyphicon glyphicon-pencil pull-left"
                                                                  title="Create new course"></i></a>
                                <b>Test config manage</b></h1>
                            <table class="table">
                                <thead class="alert alert-success">
                                <tr>
                                    <th> ID</th>
                                    <th> QuestionCount</th>
                                    <th> Due date</th>
                                    <th>Date time to test</th>
                                    <th> Status</th>
                                    <th>Action</th>
                                </tr>
                                </thead>


                                <c:forEach items="${course.testConfigListBeens}" var="testConfig">


                                    <tr>
                                        <td>${testConfig.id}</td>
                                        <td>${testConfig.questionCount}</td>
                                        <td>${testConfig.dueDate}</td>
                                        <td>${testConfig.dateTimeToTest}</td>
                                        <td>${testConfig.status}</td>

                                        <td class="text-center">
                                            <a href="/admin//testConfig/${testConfig.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                            <a href="/admin/course-remove"> <i class="fa fa-times"></i></a>
                                        </td>

                                    </tr>
                                </c:forEach>
                            </table>
                            <!-- Pagination -->


                        </div>
                    </div>
                    <div class="updateCourse">
                        <form data-toggle="validator" role="form" action="/admin/course/${course.id}"
                              method="POST" class="form-horizontal">
                            <fieldset>
                                <dl class="dl-horizontal">
                                    <dt>
                                        <label class="pull-left control-label" for="name">Course name</label>
                                    </dt>
                                    <dd>
                                        <div class="form-group">
                                            <input value="${course.name}" id="albumName" minlenght="1"
                                                   maxlength="25" id="name" name="name" type="text"
                                                   placeholder="Enter course name"
                                                   class="form-control pull-left" required>
                                        </div>
                                    </dd>
                                    <dt>
                                        <label class="control-label pull-left" for="description">Course
                                            description</label>
                                    </dt>
                                    <dd>
                                        <div class="form-group">
                                                    <textarea class="form-control" id="description" name="description"
                                                              placeholder="There should be description of course"
                                                              rows="5" required>${course.description}</textarea>
                                        </div>
                                    </dd>
                                </dl>
                            </fieldset>
                            <button type="submit" class="btn btn-primary btn-lg">Update</button>
                        </form>
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
</div>
</body>
</html>
