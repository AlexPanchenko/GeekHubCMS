<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${questions}" var="question">
    <tr>
        <td>${question.id}</td>
        <td>${question.questionText}</td>
        <td>${question.questionWeight}</td>
        <td>${question.questionStatus}</td>
        <td>${question.myAnswer}</td>
        <td>${question.manyAnswers}</td>
        <td class="text-center">
            <a href="/admin/course/${question.course.id}/question/${question.id}/edit"><i
                    class="fa fa-pencil-square-o"></i></a>
            <a data-href="/admin/course/${question.course.id}/question/${question.id}/delete"
               data-target="#delete-confirm" data-toggle="modal"><i class="fa fa-times"></i></a>
        </td>
    </tr>
</c:forEach>