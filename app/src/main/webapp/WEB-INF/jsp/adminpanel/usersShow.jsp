<%--
  Created by IntelliJ IDEA.
  User: Aleksander
  Date: 18.05.2015
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<c:forEach items="${users}" var="user">
  <tr>
    <td>${user.lastName}</td>
    <td>${user.firstName}</td>
    <td>${user.email}</td>
    <td>${user.phoneNumber}</td>
    <td>${user.skype}</td>
    <td align="center">
      <a href="/admin/users/${user.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
      <a href="/admin/users/${user.id}/remove"><i class="fa fa-times"></i></a>
    </td>
  </tr>
</c:forEach>
</body>
</html>
