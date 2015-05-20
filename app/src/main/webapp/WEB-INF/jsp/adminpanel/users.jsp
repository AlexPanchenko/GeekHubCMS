<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="<c:url value='/resources/js/jquery.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-2.1.4.min.js'/>" type="text/javascript"></script>

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
<script>
    function showNewPage(){
        $.ajax({
            url:"ajax/usersShow",
            type:"post",
            data:'',
            success:function(data) {
                $("#rows").html(data);
            }
        });
    }
    $(document).ready(function() {
        showNewPage();
    });
</script>
</head>
<body>

<div id="wrapper">

    <jsp:include page="navigation.jsp"></jsp:include>
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="alert alert-success text-center"><b>Users manage</b></h1>
                    <table class="table">
                        <thead class="alert alert-success">
                                <tr>
                                    <th> Last name <input class="input-sm" placeholder="Place for filthering"> </th>
                                    <th> Name <input class="input-sm" placeholder="Place for filthering"></th>
                                    <th>Patronymic <input class="input-sm" placeholder="Place for filthering"></th>
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
                            <ul class="pagination" >
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li><a href="#" onclick="showNewPage()">1</a></li>
                                <li><a href="#" onclick="showNewPage()">2</a></li>
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
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
</body>
</html>

