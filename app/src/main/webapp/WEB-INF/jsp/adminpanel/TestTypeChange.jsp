<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Test type</title>

  <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>

<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
  <jsp:include page="sidebar.jsp"></jsp:include>



  <div id="page-content-wrapper">
    <h1>Test type change</h1>
    <form data-toggle="validator" name="create" id="create" role="form"
          action="/admin/testType/change/${id}" method="POST"
          class="form-horizontal">
      <fieldset>
        <dl class="dl-horizontal">
          <dt>
            <label class="pull-left control-label" for="name">Test type name</label>
          </dt>
          <dd>
            <div class="form-group">
              <input type="text" id="name" name="name" required value="${name}">
            </div>
          </dd>
          <dt>
            <label class="pull-left control-label" for="select">Select course</label>
          </dt>
          <dd>
            <div class="form-group">
              <select class="selectpicker" id="select" name="courseId">
                <c:forEach items="${courseList}" var="course">
                  <option value="${course.id}" <c:if test="${course.id == courseId}">selected</c:if>>${course.name}</option>
                </c:forEach>
              </select>
            </div>
          </dd>
          <input type="submit" value="Save" class="btn btn-primary">
        </dl>
      </fieldset>
    </form>
  </div>

</div>
</body>
</html>

