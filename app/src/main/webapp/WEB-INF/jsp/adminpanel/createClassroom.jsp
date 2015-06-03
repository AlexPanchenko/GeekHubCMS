<%--
  Created by IntelliJ IDEA.
  User: Aleksander
  Date: 21.05.2015
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
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

  <jsp:include page="../source.jsp"></jsp:include>
  <script>
    function showUsers(course){
      $.ajax({
        url:"/admin/ajax/usersOnCourse",
        type:"post",
        data:{course:course},
        success:function(data) {
          $("#users").html(data);
        }
      });
    };
    function saveClassroom(){
      var users = $('.inlineCheckbox1:checked');
      var idUsers = [];
      for (var i=0; i<users.length;i++)
        idUsers.push(users[i].value);
      var course = $('#course').val();
      var teacher = $('#teacher').val();
      var className = $('#ClassroomName').val();
      var classDescription = $('#ClassroomDescription').val();
      if(course!=""&&className!=""&&classDescription!="")
        $.ajax({
          url:"ajax/createClassroom",
          type:"post",
          data:{usersId:idUsers,courseId:course,teacherId:teacher,className:className,classDescription:classDescription},
          success:function(data) {
            window.location = data;
          }
        });
      else
        $("#error-message").html("Fill in all required fields!")
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
        <div id="error-message" style="color:red;"></div>
        <p>Classroom name <span style="color: red;">*</span></p>
        <input id ='ClassroomName' type='text'/>
        <p>Classroom description <span style="color: red;">*</span></p>
        <input id ='ClassroomDescription' type='text'/>
        <p>Course name <span style="color: red;">*</span></p>
        <select size='1' id="course" onchange='showUsers($("#course").val())'>
          <c:forEach items="${courses}" var="s">
            <option value="${s.id}">${s.name}</option>
          </c:forEach>
        </select>
        <p>Teacher name</p>
        <select size='1' id="teacher">
          <option value="0"></option>
          <c:forEach items="${teachers}" var="t">
            <option value="${t.id}">${t.lastName}</option>
          </c:forEach>
        </select>
        <div id="users"></div>
        <p><input type='button' value='Save classroom' onclick='saveClassroom();'/></p>
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
