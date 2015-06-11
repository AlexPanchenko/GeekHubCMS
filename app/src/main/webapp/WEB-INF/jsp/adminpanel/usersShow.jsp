<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.lastName}</td>
        <td>${user.firstName}</td>
        <td>${user.email}</td>
        <td>${user.phoneNumber}</td>
        <td>${user.skype}dsagsdagsdg</td>
        <td align="center">
            <a href="/admin/users/${user.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
            <a href="/admin/users/${user.id}/remove"><i class="fa fa-times"></i></a>
            <a href="#" data-toggle="modal" data-target="#feedbackForm"><i class="fa fa-comment"></i></a>
            <a href="/admin/users/${user.id}/vievfeedback"><i class="fa fa-eye"></i></a>
        </td>
    </tr>
</c:forEach>
