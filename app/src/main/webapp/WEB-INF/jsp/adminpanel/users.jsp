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
    <!-- /#wrapper -->
    <script>
        $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });

        function showNewPage(page){
            $.ajax({
                url:"ajax/usersShow",
                type:"post",
                data:{page:page},
                success:function(data) {
                    $("#rows").html(data);
                }
            });
        }
        function countUsers(){
            $.ajax({
                url:"ajax/countUsers",
                type:"post",
                data:'',
                success:function(data) {
                }
            });
        }
        $(document).ready(function() {
            countUsers();
            showNewPage(1);
        });
    </script>
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
                    <h1 class="alert alert-success text-center">
                    <a href="/admin/createUser" class="pull-left">Create User </a>
                    <b>Users manage</b></h1>
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
                        <tbody id="rows">
                        </tbody>
                    </table>
                    <div class="text-center">
                        <nav>
                            <ul id="course" class="pagination" >
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <c:forEach items="${pageNumbers}" var="number">
                                    <li><a href="#" onclick="showNewPage(${number})">${number}</a></li>
                                </c:forEach>
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
        <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
</div>
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>


</body>
</html>

