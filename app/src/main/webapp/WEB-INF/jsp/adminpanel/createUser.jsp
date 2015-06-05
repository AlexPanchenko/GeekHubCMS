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

    <title>User create page</title>

    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header text-center">User create</h1>

                    <form action="/admin/createUser" data-toggle="validator" class="form-horizontal"
                          method="post" enctype="multipart/form-data">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6 col-lg-offset-3">
                                    <fieldset>
                                        <div class="control-group">
                                            <dl class="dl-horizontal">
                                                <dt>
                                                    <label class="control-label pull-left" for="first-name">First
                                                        name</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input maxlength="25"
                                                               type="text" id="first-name" name="first-name"
                                                               placeholder="Enter first name"
                                                               class="form-control input-lg" required>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left" for="lastName">Last
                                                        name</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input type="text"
                                                               id="lastName" name="lastName"
                                                               placeholder="Enter last name"
                                                               class="form-control input-lg" required>
                                                    </div>
                                                </dd>
                                                <dt>
                                                    <label class="control-label pull-left"
                                                           for="password">Password</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input type="password" id="password"
                                                               name="password" placeholder="password"
                                                               class="form-control input-lg"
                                                               required>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left" for="email">E-mail</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input type="email" id="email"
                                                               name="email" placeholder="" class="form-control input-lg"
                                                               required>
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-left" for="skype">Skype</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input type="text" id="skype" name="skype"
                                                               placeholder="skype" class="form-control input-lg">
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="control-label pull-right" for="phone"
                                                           style="margin-top: 5px;font-size: larger;">+380</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input type="tel" id="phone"
                                                               name="phone" placeholder="Enter phone number"
                                                               pattern="^([0-9]){9,9}$"
                                                               class="form-control input-lg" required>
                                                    </div>
                                                </dd>
                                                <dt>
                                                    <label class="control-label pull-left"
                                                           for="birthday">Birthday</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input type="date" name="birthday" id="birthday" name="birthday"
                                                               class="form-control js-birthday">

                                                    </div>
                                                </dd>
                                                <dt>
                                                    <label class="control-label pull-left" for="role">Roles</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <select id="role" name="role" class="form-control">
                                                            <option value="ROLE_STUDENT">ROLE_STUDENT</option>
                                                            <option value="ROLE_TEACHER">ROLE_TEACHER</option>
                                                        </select>
                                                    </div>
                                                </dd>

                                            </dl>
                                        </div>
                                        <div class="container">
                                            <div class="row">
                                                <div class="col-lg-6">
                                                    <button type="submit" class="btn btn-success pull-right">Create User
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

</body>
</html>
