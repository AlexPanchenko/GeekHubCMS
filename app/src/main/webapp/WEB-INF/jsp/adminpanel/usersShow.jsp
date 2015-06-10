<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../source.jsp"></jsp:include>

<html>
<body>
<table class="table text-black" >
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
                <a href="/admin/users/${user.id}/levefeedback"><i class="fa fa-comment"></i></a>
                <a href="/admin/users/${user.id}/vievfeedback"><i class="fa fa-eye"></i></a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
