<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../source.jsp"></jsp:include>

<html>
<body>
<table class="table text-black">
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
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.lastName}</td>
            <td>${user.firstName}</td>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.skype}</td>
            <td align="center">
                <a href="/admin/users/${user.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                <a href="#" data-href="/admin/users/${user.id}/remove" data-target="#confirm-delete" data-toggle="modal"><i class="fa fa-times"></i></a>
            </td>
        </tr>
    </c:forEach>
</table>


<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                Delete user
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a class="btn btn-danger btn-ok">Delete</a>
            </div>
        </div>
    </div>
</div>


<script src="<c:url value="/resources/js/adminpanel/deleteConfirm.js"/> "></script>
</body>
</html>
