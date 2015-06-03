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

    <title>Student by classRoom</title>

    <jsp:include page="../source.jsp"></jsp:include>

    <script>
        function selectClassroom(data){
            $.ajax({
                url:"/teacher/students/classroom",
                type:"get",
                data:{classroomId:data},
                success:function(data) {
                    $("#items").html(data);
                }
            });
        }

    </script>

</head>
<body>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="alert alert-success text-center">

                        <!-- /////////////////////////////////////////////////////////-->

                        <select id="selectClassroom" class="dropdown-toggle" onchange="selectClassroom($('#selectClassroom').val())">
                            <option id="0">-------</option>
                            <c:forEach items="${classRooms}" var="classRoom">
                                <option value=${classRoom.id} >${classRoom.name}</option>
                            </c:forEach>
                        </select>

                        <!-- /////////////////////////////////////////////////////////-->

                        <b>Students</b></h1>
                        <div class="col-lg-12" id="items">

                        </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>
</html>
