<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/js/validator.js'/>"></script>
    <script src="<c:url value='/resources/js/metisMenu.min.js'/>"></script>
    <script src="<c:url value='/resources/js/sb-admin-2.js'/>"></script>
    <script src="<c:url value='/resources/js/validator.js'/>"></script>

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
                    <h1 class="page-header">User <b>${user.id}</b> profile</h1>
                    <form action="/admin/users" data-toggle="validator" role="form" class="form-horizontal" method="post" enctype="multipart/form-data">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="control-group">
                                    <div class="form-horizontal">
                                        <img class="profile-avatar img-thumbnail"
                                             src="http://www.w3schools.com/bootstrap/cinqueterre.jpg"/>
                                        <input type="file" name="avatar" id="avatar" class="btn btn-sm btn-default avatar-upload"
                                               data-input="false">
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-6">
                                    <fieldset>
                                        <div class="control-group">
                                            <dl class="dl-horizontal">
                                                <input hidden="hidden" name="id" value="${user.id}"/>
                                                <dt>
                                                    <label class="control-label pull-left" for="login">Login</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input value="${user.login}" data-minlength="4"
                                                               pattern="^([_a-zA-ZА-Яа-яїЇёЁ]){4,}$" maxlength="25"
                                                               type="text" id="login" name="login"
                                                               placeholder="Enter login" class="form-control input-lg"
                                                               required>
                                                        <small class="help-block with-errors">Login should be between
                                                            4-25 symbols
                                                        </small>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left" for="first-name">First
                                                        name</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input value="${user.firstName}" data-minlength="2"
                                                               pattern="^([_a-zA-ZА-Яа-яїЇёЁ]){2,}$" maxlength="25"
                                                               type="text" id="first-name" name="first-name"
                                                               placeholder="Enter first name"
                                                               class="form-control input-lg" required>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left"
                                                           for="patronymic">Patronymic</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input value="${user.patronymic}" data-minlength="2"
                                                               pattern="^([_a-zA-ZА-Яа-яїЇёЁ]){2,}$" type="text"
                                                               id="patronymic" name="patronymic"
                                                               placeholder="Enter patronymic"
                                                               class="form-control input-lg" required>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left" for="last-name">Last
                                                        name</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input value="${user.lastName}" data-minlength="2"
                                                               pattern="^([_a-zA-ZА-Яа-яїЇёЁ]){2,}$" type="text"
                                                               id="last-name" name="last-name"
                                                               placeholder="Enter last name"
                                                               class="form-control input-lg" required>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left" for="email">E-mail</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input value="${user.email}" type="email" id="email"
                                                               name="email" placeholder="" class="form-control input-lg"
                                                               required>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left" for="skype">Skype</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input value="${user.skype}" type="text" id="skype" name="skype"
                                                               placeholder="" class="form-control input-lg">
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-right" for="phone">+380</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input value="${user.phoneNumber}" type="tel" id="phone"
                                                               name="phone" placeholder="Enter phone number" pattern="^([0-9]){9,9}$"
                                                               class="form-control input-lg" required>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left"
                                                           for="last-name">Birthday</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input value='<fmt:formatDate type="date" value="${user.birthDay}" pattern="yyyy-MM-dd" />'
                                                               type="date" id="birthday" name="birthday"
                                                               class="form-control input-lg">
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left" for="last-name">Roles</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <select id="role" name="role"class="form-control">
                                                            <c:forEach items="${roleList}" var="role">
                                                                <c:set var="selectRole" value="false"/>
                                                                <c:forEach items="${user.roles}" var="userRole">
                                                                    <c:if test="${role.id eq userRole.id}">
                                                                        <c:set var="selectRole" value="true"/>
                                                                    </c:if>
                                                                </c:forEach>
                                                                <c:choose>
                                                                    <c:when test="${selectRole eq true}">
                                                                        <option id="${role.id}" selected>${role.name}</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option id="${role.id}" selected>${role.name}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left" for="last-name">Courses</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <select id="courses[]" name="courses[]"class="form-control" multiple>
                                                            <c:forEach items="${courseList}" var="coursWrapper">
                                                                <c:set var="selectCourse" value="false"/>
                                                                <c:forEach items="${user.courses}" var="userCourse">
                                                                    <c:if test="${coursWrapper.id eq userCourse.id}">
                                                                        <c:set var="selectCourse" value="true"/>
                                                                    </c:if>
                                                                </c:forEach>
                                                                <c:choose>
                                                                    <c:when test="${selectCourse eq true}">
                                                                        <option id="${coursWrapper.id}" selected>${coursWrapper.name}</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option id="${coursWrapper.id}" selected>${coursWrapper.name}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </dd>
                                            </dl>
                                        </div>
                                        <div class="control-group">
                                            <!-- Button -->
                                            <div class="controls">
                                                <button type="submit" class="btn btn-success pull-right">Update Data
                                                </button>
                                            </div>
                                        </div>
                                    </fieldset>
                            </div>
                        </div>
                    </div>
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

</body>
</html>
