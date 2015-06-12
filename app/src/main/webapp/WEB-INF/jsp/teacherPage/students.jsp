<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="table text-black table-hover">
    <thead class="alert alert-success">
    <tr>
        <th> Last name <input class="input-sm" placeholder="Place for filthering"></th>
        <th> Name <input class="input-sm" placeholder="Place for filthering"></th>
        <th> Email <input class="input-sm" placeholder="Place for filthering"></th>
        <th> Phone <input class="input-sm" placeholder="Place for filthering"></th>
        <th> Skype <input class="input-sm" placeholder="Place for filthering"></th>
        <th> Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.lastName}</td>
            <td>${user.firstName}</td>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.skype}</td>
            <td align="center">
                <c:if test="${logedUser.role eq \"ROLE_ADMIN\"}">
                    <input type="hidden" value="${user.id}">
                    <a href="/admin/users/${user.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                    <a data-href="/admin/users/${user.id}/remove" data-toggle="modal" data-target="#delete-confirm"><i class="fa fa-times"></i></a>
                    <a href="#" data-toggle="modal" data-target="#feedbackForm" id="user${user.id}"><i
                            class="fa fa-comment"></i></a>
                    <a href="#"><i class="fa fa-eye view-feedbacks"></i></a>
                </c:if>
                <c:if test="${logedUser.role eq \"ROLE_TEACHER\"}">
                    <a href="/teacher/profile/${user.id}"><i class="fa fa-pencil-square-o"></i></a>
                    <a href="#" data-toggle="modal" data-target="#feedbackForm" id="user${user.id}"><i
                            class="fa fa-comment"></i></a>
                    <a href="#"><i class="fa fa-eye view-feedbacks"></i></a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>




















