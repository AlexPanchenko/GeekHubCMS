<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="comment-box">
    <c:forEach var="each" items="${noteBeansList}">
        <div class="comment">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>${each.getSender().getFirstName()} ${each.getSender().getLastName()}</strong>
                    <span class="text-muted">${each.foromatedDate}</span>
                </div>
                <div class="panel-body">
                        ${each.getNoteText()}
                </div>
            </div>
        </div>
    </c:forEach>
</div>