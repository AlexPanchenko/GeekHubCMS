<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21.05.2015
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Teacher Panel</title>
    <jsp:include page="../adminpanel/source.jsp"></jsp:include>
</head>
<body>
<h1>Check User Answer</h1>

<div>
    ${user.firstName} ${user.lastName}

    <c:forEach items="${testAssignment.userResults}" var="userResult">
        <div>
            <div>
                    ${userResult.question.questionText}
            </div>
            <%--<c:choose>
                <c:when test="${!userResult.question.manyAnswers}">
                    <div>
                        <c:forEach items="${userResult.question.answers}" var="answer">
                            <div class="form-group">
                                <label><input type="checkbox"
                                              <c:if test="${}">checked </c:if> disabled>${answer.answerText}
                                </label>
                            </div>
                        </c:forEach>
                    </div>
                </c:when>
                <c:otherwise>
                    <div>
                        <c:forEach items="${userResult.question.answers}" var="answer">
                            <div class="form-group">
                                <label><input type="radio"
                                              <c:if test="${answer eq userResult.userAnswer.answer}">checked </c:if>
                                              disabled>${answer.answerText}
                                </label>
                            </div>
                        </c:forEach>
                    </div>
                </c:otherwise>
            </c:choose>--%>
        </div>
    </c:forEach>
</div>

</body>
</html>
