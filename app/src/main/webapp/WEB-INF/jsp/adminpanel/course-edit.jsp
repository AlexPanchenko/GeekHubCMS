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
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="container">

                    <h1 class="page-header">Edit ${course.name}</h1>


                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="alert alert-success text-center">
                                <a href="/admin/testConfig/${courseId}/create"><i class="glyphicon glyphicon-pencil pull-left"
                                                                                  title="Create new test config"></i></a>

                                <b>Test config manage</b></h1>
                            <table class="table text-black">
                                <thead class="alert alert-success">
                                <tr>
                                    <th> ID</th>
                                    <th>Title</th>
                                    <th>Question count</th>
                                    <th>Date start</th>
                                    <th>Date finish</th>
                                    <th>Time to test</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                                </thead>

                                <tr>
                                <td>${course.testConfigBeen.id}</td>
                                <td>${course.testConfigBeen.tittle}</td>
                                <td>${course.testConfigBeen.questionCount}</td>
                                <td>${course.testConfigBeen.dateStartStr}</td>
                                <td>${course.testConfigBeen.dateFinishStr}</td>
                                <td>${course.testConfigBeen.timeToTest}</td>
                                <td>${course.testConfigBeen.status}</td>

                                <td class="text-center">
                                <a href="/admin/testConfig/${course.id}/${course.testConfigBeen.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                <%--<a href="/admin/testConfig/${course.id}/${course.testConfigBeen.id}/delete"> <i class="fa fa-times"></i></a>--%>
                                </td>

                                </tr>


                                <%--<c:forEach items="${course.testConfigListBeens}" var="testConfig">--%>


                                    <%--<tr>--%>
                                        <%--<td>${testConfig.id}</td>--%>
                                        <%--<td>${testConfig.tittle}</td>--%>
                                        <%--<td>${testConfig.questionCount}</td>--%>
                                        <%--<td>${testConfig.dateStart}</td>--%>
                                        <%--<td>${testConfig.dateFinish}</td>--%>
                                        <%--<td>${testConfig.timeToTest}</td>--%>
                                        <%--<td>${testConfig.status}</td>--%>

                                        <%--<td class="text-center">--%>
                                            <%--<a href="/admin//testConfig/${course.id}/${testConfig.id}/edit"><i class="fa fa-pencil-square-o"></i></a>--%>
                                            <%--<a href="/admin/testConfig/${course.id}/${testConfig.id}/delete"> <i class="fa fa-times"></i></a>--%>
                                        <%--</td>--%>

                                    <%--</tr>--%>
                                <%--</c:forEach>--%>
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
</div>

<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>
</html>
