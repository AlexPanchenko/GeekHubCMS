<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>AdminPanel</title>

  <jsp:include page="../source.jsp"></jsp:include>

  <script>
    function selectCource(){
      if ($('#selectCourse option:selected').attr('id') == 0) {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'hidden';
        document.getElementById('selectTestType').style.visibility = 'hidden';
        window.location.replace("/admin/questions");
      } else {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'visible';
        document.getElementById('selectTestType').style.visibility = 'visible';

        $('#linkCreateQuestionByCourse').attr("href", "/admin/course/" + $('#selectCourse option:selected').attr('id') + "/question/create");
        var redirectTo = "/admin/course/" + $('#selectCourse option:selected').attr('id') + "/questions/";
        window.location.replace(redirectTo);

//          $.get("/admin/questions/" + $('#selectCourse option:selected').attr('id'), function(data){
//              $('#page-content-wrapper').load('questions.jsp');
//            alert(data);
        //document.getElementById("selectTestType").setAttribute("${testTypeList}");
//          })
      }

    }
    <%--alert(${currentCourse});--%>
    $(document).ready(function () {
      <%--document.getElementById('selectCourse').selectedIndex = ${currentCourse};--%>

      if ($('#selectCourse option:selected').attr('id') == 0) {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'hidden';
        document.getElementById('selectTestType').style.visibility = 'hidden';

      } else {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'visible';
        document.getElementById('selectTestType').style.visibility = 'visible';
        $('#linkCreateQuestionByCourse').attr("href", "/admin/course/" + $('#selectCourse option:selected').attr('id') + "/question/create");
      }
    });

    function selectTestType(){
      if ($('#selectTestType option:selected').attr('id') == "testType0") {
        var redirectTo = "/admin/course/" + ${currentCourse} + "/questions/";
        window.location.replace(redirectTo);
      } else {
        var redirectTo = "/admin/course/" + ${currentCourse} + "/testType/"+$('#selectTestType option:selected').attr('id') + "/questions/";
        window.location.replace(redirectTo);
      }
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

            <a id="linkCreateQuestionByCourse" href="#" ><i class="glyphicon glyphicon-pencil pull-left" title="Create new question"></i></a>
            <!-- /////////////////////////////////////////////////////////-->
            <select id="selectCourse" class="dropdown-toggle" onchange="selectCource()">
              <option id="0">All Courses</option>
              <c:forEach items="${courses}" var="course">
                <c:if test="${course.id != currentCourse}">
                  <option id=${course.id} >${course.name}</option>
                </c:if>
                <c:if test="${course.id == currentCourse}">
                  <option selected id=${course.id} >${course.name}</option>
                </c:if>
              </c:forEach>
              <%--<option selected id=${currentCourse}>${currentCourse}</option>--%>
            </select>

            <select id="selectTestType" class="dropdown-toggle" onchange="selectTestType()">
              <option id="testType0">All TestType</option>
              <c:if test="${0 == testTypeId}">
                <option selected id="0">withoutTestType</option>
              </c:if>
              <c:if test="${0 != testTypeId}">
                <option id="0">withoutTestType</option>
              </c:if>
              <c:forEach items="${testTypeList}" var="testType">
                <c:if test="${testType.id != testTypeId}">
                  <option id=${testType.id}>${testType.name}</option>
                </c:if>
                <c:if test="${testType.id == testTypeId}">
                  <option selected id=${testType.id} >${testType.name}</option>
                </c:if>
              </c:forEach>
              <%--<option id="0">withoutTestType</option>--%>
            </select>


            <b>Questions manage</b></h1>

          <table class="table">
            <thead class="alert alert-success">
            <tr>
              <th> ID </th>
              <th> Text question </th>
              <th> Weigth</th>
              <th> Status</th>
              <th> Your answer</th>
              <th> Many answer</th>
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
                <td>${question.questionStatus}</td>
                <td>${question.myAnswer}</td>
                <td>${question.manyAnswers}</td>
                <td class="text-center">
                  <a href="/admin/course/${question.course.id}/testType/${testTypeId}/question/${question.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                  <%--<a href="/admin/course/${question.course.id}/question/${question.id}/delete"><i class="fa fa-times"></i></a>--%>
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


<script>
  $("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
  });
</script>

</body>
</html>
