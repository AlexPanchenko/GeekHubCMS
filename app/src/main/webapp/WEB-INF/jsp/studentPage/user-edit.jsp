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
                    <h1 class="page-header">User <b>${user.id}</b> profile</h1>

                    <form action="/student/users" data-toggle="validator" role="form" class="form-horizontal"
                          method="post" enctype="multipart/form-data">
                        <div class="container">
                            <div class="row">

                                <div class="col-md-6 col-lg-6">
                                    <fieldset>
                                        <div class="control-group">
                                            <dl class="dl-horizontal">
                                                <input hidden="hidden" name="id" value="${user.id}"/>

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
                                                               name="phone" placeholder="Enter phone number"
                                                               pattern="^([0-9]){9,9}$"
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
                                                        <select id="role" name="role" class="form-control">
                                                            <c:forEach items="${roleList}" var="role">
                                                                <c:if test="${role == user.role}">
                                                                    <option selected value="${role}">${role}</option>
                                                                </c:if>
                                                                <c:if test="${role != user.role}">
                                                                    <option value="${role}">${role}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left"
                                                           for="last-name">Courses</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <select id="courses[]" name="courses[]" class="form-control"
                                                                multiple>
                                                            <c:forEach items="${courseList}" var="coursWrapper">
                                                                <c:set var="selectCourse" value="false"/>
                                                                <c:forEach items="${user.usersCourses}" var="userCourse">
                                                                    <c:if test="${coursWrapper.id eq userCourse.id}">
                                                                        <c:set var="selectCourse" value="true"/>
                                                                    </c:if>
                                                                </c:forEach>
                                                                <c:choose>
                                                                    <c:when test="${selectCourse eq true}">
                                                                        <option id="${coursWrapper.id}"
                                                                                selected>${coursWrapper.name}</option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option id="${coursWrapper.id}"
                                                                                selected>${coursWrapper.name}</option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </dd>
                                            </dl>
                                        </div>
                                        <div class="container">
                                            <div class="row">
                                                <div class=" col-md-1 col-lg-1 col-lg-offset-3">
                                                    <a href="#" data-toggle="modal" data-target="#change-password" class="btn btn-success pull-right" data-toggle="modal">Change password</a>
                                                </div>
                                                <div class=" col-md-1 col-lg-1 col-lg-offset-1">
                                                    <button type="submit" class="btn btn-success pull-right" >Update Data
                                                    </button>
                                                </div>
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
    </div>
</div>

<jsp:include page="changePasswordForm.jsp"></jsp:include>
</body>
</html>
