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
    <div class="myW">
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-10">
                        <div class="container">
                            <h1 class="page-header">Add new test config</h1>
                            <c:choose>
                                <c:when test="${empty testTypeList}">
                                    <p>You must create "TestType"</p>
                                </c:when>
                                <c:otherwise>
                                    <form data-toggle="validator" role="form" action="/admin/testConfig/create"
                                          method="POST"
                                          class="form-horizontal">
                                        <fieldset>
                                            <dl class="dl-horizontal">

                                                <dt>
                                                    <label class="pull-left control-label" for="testType">Test
                                                        type</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <select class="selectpicker" id="testType" name="testType">
                                                            <c:forEach items="${testTypeList}" var="testType">
                                                                <option value="${testType.id}">${testType.name}
                                                                    (${testType.course.name})
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </dd>
                                                <dt>
                                                    <label class="pull-left control-label" for="title">Test config
                                                        title</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input required type="text" id="title" min="0" name="title">
                                                    </div>
                                                </dd>
                                                <dt>
                                                    <label class="pull-left control-label" for="questionCount">Question
                                                        count</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input required type="number" id="questionCount" min="0"
                                                               name="questionCount">
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="pull-left control-label" for="dateStart">Date
                                                        start </label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input required type="date" id="dateStart" class="form-control"
                                                               name="dateStart">
                                                    </div>
                                                </dd>
                                                <dt>
                                                    <label class="pull-left control-label" for="dateFinish">Date
                                                        start </label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input required type="date" id="dateFinish" class="form-control"
                                                               name="dateFinish">
                                                    </div>
                                                </dd>

                                                <dt>
                                                    <label class="pull-left control-label" for="timeToTest">Time to
                                                        test</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <input required type="number" min="0" id="timeToTest"
                                                               name="timeToTest">
                                                    </div>
                                                </dd>


                                                <dt>
                                                    <label class="pull-left control-label" for="status">status</label>
                                                </dt>
                                                <dd>
                                                    <div class="form-group">
                                                        <div class="btn-group">
                                                            <select name="status"
                                                                    class="btn btn-default dropdown-toggle"
                                                                    data-toggle="dropdown" aria-expanded="false"
                                                                    id="status">
                                                                <c:forEach items="${status}" var="status">
                                                                    <option value="${status}">${status}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </dd>
                                            </dl>
                                        </fieldset>
                                        <button type="submit" class="btn btn-primary btn-lg">Create</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
