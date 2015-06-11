<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="comment-box">
    <c:forEach var="each" items="${notesAboutUser}">
        <div class="comment">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>${each.getSender().getFirstName()} ${each.getSender().getLastName()}</strong>
                    <span class="text-muted">${each.getDate()}</span>
                </div>
                <div class="panel-body">
                        ${each.getNoteText()}
                </div>
            </div>
        </div>
    </c:forEach>
</div>