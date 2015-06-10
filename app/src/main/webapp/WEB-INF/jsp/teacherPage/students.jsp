<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <c:if test="${logedUser.role eq \"ROLE_ADMIN\"}">
                    ${logedUser.role}
                    <a href="/admin/users/${user.id}/edit"><i class="fa fa-pencil-square-o"></i></a>
                    <a href="/admin/users/${user.id}/remove"><i class="fa fa-times"></i></a>
                    <a href="/teacher/users/${user.id}/levefeedback"><i class="fa fa-comment"></i></a>
                    <a href="/teacher/users/${user.id}/vievfeedback"><i class="fa fa-eye"></i></a>
                </c:if>
                <c:if test="${logedUser.role eq \"ROLE_TEACHER\"}">
                    <a href="/teacher/profile/${user.id}"><i class="fa fa-pencil-square-o"></i></a>
                    <a href="/teacher/users/${user.id}/levefeedback"><i class="fa fa-comment"></i></a>
                    <a href="/teacher/users/${user.id}/vievfeedback"><i class="fa fa-eye"></i></a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

<%--<c:if test="${users eq not null}">
    <div class="text-center">
        <nav>
            <ul class="pagination">
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
</c:if>--%>

</body>
</html>


















