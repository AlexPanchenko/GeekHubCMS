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
                        <c:choose>
                            <c:when test="${action eq 'create'}">
                                <h1 class="page-header">Add new course</h1>
                                <form data-toggle="validator"  role="form" action="/admin/courses"  method="POST" class="form-horizontal">
                                    <fieldset>
                                        <dl class="dl-horizontal">
                                            <dt>
                                                <label class="pull-left control-label" for="name">Course name</label>
                                            </dt>
                                            <dd>
                                                <div class="form-group">
                                                    <input id="albumName"  minlenght="1" maxlength="25" id="name" name="name" type="text" placeholder="Enter course name" class="form-control pull-left" required>
                                                </div>
                                            </dd>
                                            <dt>
                                                <label class="control-label pull-left" for="description">Course description</label>
                                            </dt>
                                            <dd>
                                                <div class="form-group">
                                                    <textarea class="form-control" id="description" name="description" placeholder="There should be description of course" rows="5" required></textarea>
                                                </div>
                                            </dd>
                                        </dl>
                                    </fieldset>
                                    <button type="submit" class="btn btn-primary btn-lg">Create</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <h1 class="page-header">Edit ${course.id}</h1>
                                <form data-toggle="validator"  role="form" action="/admin/courses/${course.id}"  method="POST" class="form-horizontal">
                                    <fieldset>
                                        <dl class="dl-horizontal">
                                            <dt>
                                                <label class="pull-left control-label" for="name">Course name</label>
                                            </dt>
                                            <dd>
                                                <div class="form-group">
                                                    <input value="${course.name}" id="albumName"  minlenght="1" maxlength="25" id="name" name="name" type="text" placeholder="Enter course name" class="form-control pull-left" required>
                                                </div>
                                            </dd>
                                            <dt>
                                                <label class="control-label pull-left" for="description">Course description</label>
                                            </dt>
                                            <dd>
                                                <div class="form-group">
                                                    <textarea class="form-control" id="description" name="description" placeholder="There should be description of course" rows="5" required>${course.description}</textarea>
                                                </div>
                                            </dd>
                                        </dl>
                                    </fieldset>
                                    <button type="submit" class="btn btn-primary btn-lg">Update</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
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
