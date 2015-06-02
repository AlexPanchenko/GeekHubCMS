<%--
  Created by IntelliJ IDEA.
  User: Aleksander
  Date: 21.05.2015
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <link href="<c:url value='/resources/css/metisMenu.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/sb-admin-2.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/font-awesome.min.css'/>" rel="stylesheet"/>
  <link href="<c:url value='/resources/css/css.css'/>" rel="stylesheet">
</head>
<body>
  <p>Users on course</p>
  <label id="checkbox" class="checkbox-inline">
    <c:forEach items="${users}" var="u">
      <p><input type="checkbox" class="inlineCheckbox1" value="${u.id}"> ${u.lastName}&nbsp${u.firstName}</p>
    </c:forEach>
  </label>
</body>
</html>
