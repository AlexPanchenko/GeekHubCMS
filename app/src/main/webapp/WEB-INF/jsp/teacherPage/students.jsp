<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table text-black">
    <thead class="alert alert-success">
        <tr>
            <th> ID </th>
            <th> First Name </th>
            <th> Last Name</th>
            <th> e-mail</th>
            <th> Phone number</th>
            <th class="text-center"> Action</th>
        </tr>
    </thead>

    <c:forEach items="${users}" var="user">
        <tr>
            <th>${user.id}</th>
            <th>${user.firstName}</th>
            <th>${user.lastName}</th>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th class="text-center">
                <a href="/teacher/profile/${user.id}"><i class="fa fa-pencil-square-o"></i></a>
                <a href="/admin/users/${user.id}/levefeedback"><i class="fa fa-comment"></i></a>
                <a href="/admin/users/${user.id}/vievfeedback"><i class="fa fa-eye"></i></a>
            </th>
        </tr>
        <%--</c:if>--%>
    </c:forEach>
</table>

<c:if test="${user eq not null}">
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
</c:if>

