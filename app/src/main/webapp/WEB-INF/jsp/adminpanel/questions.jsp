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

  <script>
    function selectCource(){
      if ($('#selectCourse option:selected').attr('id') == 0) {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'hidden';
      } else {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'visible';
        $('#linkCreateQuestionByCourse').attr("href", "/admin/course/" + $('#selectCourse option:selected').attr('id') + "/question/create");
      }

    }

    $(document).ready(function () {
      if ($('#selectCourse option:selected').attr('id') == 0) {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'hidden';
      } else {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'visible';
        $('#linkCreateQuestionByCourse').attr("href", "/admin/course/" + $('#selectCourse option:selected').attr('id') + "/question/create");
      }
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
          <h1 class="alert alert-success text-center">

            <a id="linkCreateQuestionByCourse" href="/admin/question/create" ><i class="glyphicon glyphicon-pencil pull-left" title="Create new question"></i></a>
            <!-- /////////////////////////////////////////////////////////-->

            <select id="selectCourse" class="dropdown-toggle" onchange="selectCource()">
              <option id="0">All Courses</option>
              <c:forEach items="${courses}" var="course">
                <option id=${course.id} >${course.name}</option>
              </c:forEach>
            </select>

            <!-- /////////////////////////////////////////////////////////-->

            <b>Questions manage</b></h1>
          <table class="table">
            <thead class="alert alert-success">
            <tr>
              <th> ID </th>
              <th> Text question </th>
              <th> Weigth</th>
              <th class="text-center"> Action</th>
            </tr>
            </thead>
            <%--<c:set var="courseIdNow" value="2"/>--%>
            <c:forEach items="${questions}" var="question">
              <%--<c:if test="${question.course.id == courseIdNow}">--%>
              <tr>
                <td>${question.id}</td>
                <td>${question.questionText}</td>
                <td>${question.questionWeight}</td>
                <td class="text-center">
                  <a href="/admin/question/${question.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                  <a href="/admin/question/${question.id}/delete"><i class="fa fa-times"></i></a>
                </td>
              </tr>
              <%--</c:if>--%>
            </c:forEach>
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
