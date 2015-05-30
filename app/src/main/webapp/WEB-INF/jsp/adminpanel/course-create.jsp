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
                <div class="col-lg-10">
                    <div class="container">
                        <h1 class="page-header">Add new course</h1>

                        <form data-toggle="validator" role="form" action="/admin/course" method="POST"
                              class="form-horizontal">
                            <fieldset>
                                <dl class="dl-horizontal">
                                    <dt>
                                        <label class="pull-left control-label" for="name">Course name</label>
                                    </dt>
                                    <dd>
                                        <div class="form-group">
                                            <input minlenght="1" maxlength="25" id="name"
                                                   name="name" type="text" placeholder="Enter course name"
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
                                                              rows="5" required></textarea>
                                        </div>
                                    </dd>
                                    <h1 class="page-header">New Test</h1>
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
                                        <label class="pull-left control-label" for="dateFinish">Date start </label>
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
