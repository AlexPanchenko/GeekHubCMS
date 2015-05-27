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


    <jsp:include page="source.jsp"></jsp:include>
</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="alert alert-success text-center"><b>Users manage</b></h1>
                    <table class="table text-black">
                        <thead class="alert alert-success">
                        <tr>
                            <th> Last name <input class="input-sm" placeholder="Place for filthering"> </th>
                            <th> Name <input class="input-sm" placeholder="Place for filthering"></th>
                            <th> Email <input class="input-sm" placeholder="Place for filthering"></th>
                            <th> Phone <input class="input-sm" placeholder="Place for filthering"></th>
                            <th> Skype <input class="input-sm" placeholder="Place for filthering"></th>
                            <th> Action</th>
                        </tr>
                        </thead>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.lastName}</td>
                                <td>${user.firstName}</td>
                                <td>${user.email}</td>
                                <td>${user.phoneNumber}</td>
                                <td>${user.skype}</td>
                                <td align="center">
                                    <a href="/admin/users/${user.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                                    <i class="fa fa-times"></i>
                                </td>
                            </tr>
                        </c:forEach>
                    </div>
                    </table>
                    <div class="text-center">
                        <nav>
                            <ul class="pagination" >
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>

<!-- /#wrapper -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
</body>
</html>

