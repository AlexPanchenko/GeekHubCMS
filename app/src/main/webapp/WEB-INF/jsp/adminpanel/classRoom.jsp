<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jekainfinity
  Date: 22.05.2015
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <jsp:include page="source.jsp"></jsp:include>
</head>
<body>

<div id="wrapper">

    <jsp:include page="navigation.jsp"></jsp:include>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="alert alert-success text-center">
                        <a href="/admin/classroom/create" ><i class="glyphicon glyphicon-pencil pull-left" title="Create new classrom">Create classrom </i></a>
                        <b>Classroom manage</b></h1>
                    <table class="table">
                        <thead class="alert alert-success">
                        <tr>
                            <th> СlassRoom_ID </th>
                            <th> Teachers </th>
                            <th> Cousrse_Name </th>
                            <th class="text-center"> Students</th>
                            <th class="text-center"> Action</th>
                        </tr>
                        </thead>

                        <c:forEach items="${page.list}" var="classroom">
                            <tr>
                                <td>${classroom.id}</td>
                                <td>${classroom.teachers}</td>
                                <td>${classroom.name}</td>
                                <td class="text-center">
                                    <c:forEach items="${classroom.students}" var="student">
                                        ${student} <br/>
                                    </c:forEach>
                                </td>
                                <td class="text-center">
                                    <a href="/admin/classroom/${classroom.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                    <a href="/admin/classroom-remove/${classroom.id}"> <i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <!-- Pagination -->

                    <c:url var="firstUrl" value="/admin/classroom?p=1" />
                    <c:url var="lastUrl" value="/admin/classroom?=${page.end}" />
                    <c:url var="prevUrl" value="/admin/classroom?=${page.current - 1}" />
                    <c:url var="nextUrl" value="/admin/classroom?=${page.current + 1}" />
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
