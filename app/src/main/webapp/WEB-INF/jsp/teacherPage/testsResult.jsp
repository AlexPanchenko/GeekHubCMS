<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test result</title>
    <jsp:include page="../source.jsp"></jsp:include>
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
                        <b>Test result</b></h1>
                    <div class="col-lg-6"></div>
                    <table class="table text-black">
                        <tr >
                            <th style="font-size: large;">Question 1</th>
                        </tr>
                        <tr >
                            <th class="alert alert-success" >fdfggdgfgfdgfgfdgdgfdg</th>
                        </tr>
                        <tr><th>
                            <c:forEach begin="0" end="3">
                               <p style="font-size: small;margin-bottom: -2px;"><input type="checkbox" class="inlineCheckbox1" style="margin-left: 30px;"> dsfsdfdsfdfdsfdfs</p>
                            </c:forEach></th>
                        </tr>
                        </thead>
                        </tbody>
                    </table>

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

</body>
</html>
