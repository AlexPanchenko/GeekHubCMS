<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>AdminPanel</title>

    <jsp:include page="source.jsp"></jsp:include>
</head>
<body>

<div id="wrapper">

    <jsp:include page="navigation.jsp"></jsp:include>

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
                        <a href="/admin/questions"><i class="fa fa-table fa-fw"></i>Base questions</a>
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
                <div class="col-lg-12">
                    <h1 class="alert alert-success text-center">
                        <a href="/admin/course/create" ><i class="glyphicon glyphicon-pencil pull-left" title="Create new course"></i></a>
                        <b>Courses manage</b></h1>
                    <table class="table">
                        <thead class="alert alert-success">
                        <tr>
                            <th> ID </th>
                            <th> Name </th>
                            <th> Description </th>
                            <th class="text-center"> Members</th>
                            <th class="text-center"> Action</th>
                        </tr>
                        </thead>

                    <c:forEach items="${page.list}" var="course">
                        <tr>
                            <td>${course.id}</td>
                            <td>${course.name}</td>
                            <td>${course.description}</td>
                            <td class="text-center">
                        <c:forEach items="${page.list}" var="course">
                            <tr>
                                <td>${course.id}</td>
                                <td>${course.name}</td>
                                <td>${course.description}</td>
                                <td class="text-center">
                                    <c:choose>
                                        <c:when test="${empty coursWrapper.users}">
                                            0
                                        </c:when>
                                        <c:otherwise>
                                            ${coursWrapper.users.size()}
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="text-center">
                                    <a href="/admin/courses/${course.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                    <a href="/admin/courses-remove/${course.id}"> <i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <!-- Pagination -->

                    <c:url var="firstUrl" value="/admin/courses?p=1" />
                    <c:url var="lastUrl" value="/admin/courses?=${page.end}" />
                    <c:url var="prevUrl" value="/admin/courses?=${page.current - 1}" />
                    <c:url var="nextUrl" value="/admin/courses?=${page.current + 1}" />
                    <div align="center">
                        <nav >
                            <ul class="pagination">
                                <c:choose>
                                    <c:when test="${empty coursWrapper.users}">
                                        0
                                    </c:when>
                                    <c:otherwise>
                                        ${coursWrapper.users.size()}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td class="text-center">
                                <a href="/admin/course/${course.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                <a href="/admin/course-remove/${course.id}"> <i class="fa fa-times"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <!-- Pagination -->

                <c:url var="firstUrl" value="/admin/course/list?p=1" />
                <c:url var="lastUrl" value="/admin/course/list?=${page.end}" />
                <c:url var="prevUrl" value="/admin/course/list?=${page.current - 1}" />
                <c:url var="nextUrl" value="/admin/course/list?=${page.current + 1}" />
                <div align="center">
                    <nav >
                        <ul class="pagination">
                            <c:choose>
                                <c:when test="${page.current == 1}">
                                    <li class="disabled"><a href="#">&lt;&lt;</a></li>
                                    <li class="disabled"><a href="#">&lt;</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${firstUrl}">&lt;&lt;</a></li>
                                    <li><a href="${prevUrl}">&lt;</a></li>
                                </c:otherwise>
                            </c:choose>
                            <c:forEach var="i" begin="${page.begin}" end="${page.end}">
                                <c:url var="pageUrl" value="/admin/course/list?p=${i}" />
                                <c:forEach var="i" begin="${page.begin}" end="${page.end}">
                                    <c:url var="pageUrl" value="/admin/courses?p=${i}" />
                                    <c:choose>
                                        <c:when test="${i ==page.current}">
                                            <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <c:choose>
                                    <c:when test="${i ==page.current}">
                                        <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${page.current == page.end}">
                                    <li class="disabled"><a href="#">&gt;</a></li>
                                    <li class="disabled"><a href="#">&gt;&gt;</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${nextUrl}">&gt;</a></li>
                                    <li><a href="${lastUrl}">&gt;&gt;</a></li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
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
</body>
</html>
