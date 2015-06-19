<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Question edit page</title>

    <jsp:include page="../source.jsp"></jsp:include>
</head>
<body>
<script>
    function changeValue() {
        document.getElementById('testTypeId').value = $('#selectTestType option:selected').attr('id');
    }

    function changeValueUpdate() {
        document.getElementById('testTypeIdUpdate').value = $('#selectTestType2 option:selected').attr('id');
    }

    $("form").submit(function () {


        var this_master = $(this);

        this_master.find('input[type="checkbox"]').each(function () {
            var checkbox_this = $(this);


            if (checkbox_this.is(":checked") == true) {
                checkbox_this.attr('value', 'true');
            } else {
                checkbox_this.prop('checked', true);
                //DONT' ITS JUST CHECK THE CHECKBOX TO SUBMIT FORM DATA
                checkbox_this.attr('value', 'false');
            }
        })
    })
</script>
<jsp:include page="myNavbar.jsp"></jsp:include>
<div id="wrapper">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="page-content-wrapper">

        <div class="container-fluid">
            <div class="row">

                <div class="col-lg-7">
                    <c:choose>
                        <c:when test="${action eq 'create'}">
                            <h1 class="page-header">
                                <b>Add new question for course ${courseName}</b>
                            </h1>

                            <%--<h1 class="page-header">Add new question for course ${courseName}</h1>--%>
                            <form data-toggle="validator" name="create" id="create" role="form"
                                  action="/admin/course/${courseId}/question/edit" method="POST">
                                <fieldset>
                                    <h1 class="alert alert-success text-center">
                                        <b>Select TestType for ${courseName}</b>
                                        <select id="selectTestType" name="selectTestType" onchange="changeValue()"
                                                class="dropdown-toggle">
                                            <option id="0">All TestType</option>
                                            <c:forEach items="${listTestType}" var="testType">
                                                <option value="${testType.id}"
                                                        id=${testType.id}>${testType.name}</option>
                                            </c:forEach>
                                        </select>
                                        <input type="hidden" id="testTypeId" name="testTypeId" value="0">
                                    </h1>
                                    <dl class="dl-horizontal">
                                        <dt>
                                            <label class="pull-left control-label"
                                                   for="questionText">Question text</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                                    <textarea class="form-control" id="questionText"
                                                                              name="questionText"
                                                                              placeholder="Enter the question text"
                                                                              rows="4" required></textarea>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="pull-left">Code text</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                                    <textarea class="form-control" id="questionCode"
                                                                              name="questionCode" rows="4"></textarea>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="control-label pull-left"
                                                   for="questionWeight">Weigth question</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <input id="questionWeight" minlenght="1"
                                                       maxlength="25" name="questionWeight"
                                                       type="text"
                                                       placeholder="enter the weight question"
                                                       class="form-control pull-left" required>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="control-label pull-left">User answer</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <input type="checkbox" id="myAnswer" name="myAnswer"
                                                       value="true">
                                                <input type="hidden" name="myAnswer" value="false">
                                            </div>
                                        </dd>
                                    </dl>
                                    <input type="hidden" class="answersList" name="answersList" value=""/>
                                    <input type="hidden" class="manyAnswers" name="manyAnswers" value=""/>
                                </fieldset>
                                <button  id="createSubmit" type="submit" class="btn btn-primary btn-lg">Create</button>
                            </form>

                        </c:when>
                        <c:otherwise>
                            <h1 class="page-header">Edit question № ${question.id} for course ${courseName}</h1>

                            <form data-toggle="validator" name="edit" id="edit" role="form"
                                  action="/admin/course/${courseId}/question/edit"
                                  method="POST" class="form-horizontal">
                                <fieldset>
                                    <dl class="dl-horizontal">
                                        <div class="form-group">
                                            <input class="form-control" id="id" name="id"
                                                   type="hidden" value="${question.id}">
                                            <%--<input class="form-control" id="course" name="course"
                                                   type="hidden" value="${question.course.id}">--%>
                                        </div>
                                        <dt>
                                            <label class="pull-left control-label"
                                                   for="selectTestType2">TestType</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <select id="selectTestType2" name="selectTestType2"
                                                        onchange="changeValueUpdate()"
                                                        class="dropdown-toggle form-control">
                                                    <option id="0">All TestType</option>
                                                    <c:forEach items="${listTestType}" var="testType">
                                                        <c:choose>
                                                            <c:when test="${curentTestTypeId == testType.id}">
                                                                <option selected value="${testType.id}"
                                                                        id=${testType.id}>${testType.name}</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="${testType.id}"
                                                                        id=${testType.id}>${testType.name}</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <input type="hidden" id="testTypeIdUpdate" name="testTypeId"
                                                   value=${curentTestTypeId}>
                                        </dd>
                                        <dt>
                                            <label class="pull-left control-label"
                                                   for="questionText1">Question text</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                                    <textarea class="form-control" id="questionText1"
                                                                              name="questionText"
                                                                              placeholder="Enter the question text"
                                                                              rows="4"
                                                                              required>${question.questionText}</textarea>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="pull-left control-label">Code text</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                                    <textarea class="form-control" name="questionCode"
                                                                              rows="4"
                                                                              required>${question.questionCode}</textarea>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="control-label pull-left"
                                                   for="questionWeight1">Weight question</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <input id="questionWeight1" minlenght="1"
                                                       maxlength="25" name="questionWeight"
                                                       type="text"
                                                       value="${question.questionWeight}"
                                                       placeholder="enter the weight question"
                                                       class="form-control pull-left" required>
                                            </div>
                                        </dd>
                                        <dt>
                                            <label class="control-label pull-left">User answer</label>
                                        </dt>
                                        <dd>
                                            <div class="form-group">
                                                <c:choose>
                                                    <c:when test="${question.myAnswer eq true}">
                                                        <input type="checkbox" id="myAnswerTrue"
                                                               name="myAnswer" checked>
                                                        <input type="hidden" name="myAnswer"
                                                               value="false">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" id="myAnswerFalse"
                                                               name="myAnswer">
                                                        <input type="hidden" name="myAnswer"
                                                               value="false">
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </dd>
                                    </dl>
                                </fieldset>
                                <input type="hidden" class="answersList" name="answersList" value=""/>
                                <input type="hidden" id="answersToDelete" name="answersToDelete" value=""/>
                                <input type="hidden" class="manyAnswers" name="manyAnswers" value=""/>
                                <%--<input type="hidden" name="questionId" value="${question.id}"/>--%>
                            </form>
                            <div class="clearfix"></div>
                            <button id="updateSubmit" class="btn btn-primary btn-lg">Save</button>
                        </c:otherwise>
                    </c:choose>
                    <!-- /.col-lg-12 -->

                </div>


                <div class="answers-container col-lg-5">
                    <h3 class="page-header">Answers</h3>

                    <div class="multiple-form-group">
                        <c:forEach items="${answers}" var="answer" varStatus="loop">
                            <div class="form-group  input-group" id="answer${answer.id}">
                                <div class="input-group-btn input-group-select">
                                    <button type="button"
                                            class="btn ${answer.answerRight ? 'btn-success': 'btn-danger'} dropdown-toggle"
                                            data-toggle="dropdown">
                                        <span class="concept">${answer.answerRight ? 'Correct': 'Incorrect'}</span>
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#false">Incorrect</a></li>
                                        <li><a href="#true">Correct</a></li>
                                    </ul>
                                    <input type="hidden" class="input-group-select-val" name=""
                                           value="${answer.answerRight}">
                                </div>
                                <input type="text" class="form-control answer-input"
                                       value="${answer.answerText}">
                        <span class="input-group-btn">
                            <button type="button"
                                    class="btn ${loop.last ? 'btn-success btn-add' : 'btn-danger btn-remove'}">
                                    ${loop.last ? '+' : '-'}
                            </button>
                        </span>
                            </div>
                        </c:forEach>

                        <%--Add empty field if answers is empty--%>
                        <c:if test="${answers.isEmpty()}">
                            <div class="form-group  input-group">
                                <div class="input-group-btn input-group-select">
                                    <button type="button" class="btn btn-danger dropdown-toggle"
                                            data-toggle="dropdown">
                                        <span class="concept"> Incorrect</span> <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#false">Incorrect</a></li>
                                        <li><a href="#true">Correct</a></li>
                                    </ul>
                                    <input type="hidden" class="input-group-select-val" name="" value="false">
                                </div>
                                <input type="text" class="form-control answer-input"
                                       value="">
                        <span class="input-group-btn">
                            <button type="button"
                                    class="btn btn-success btn-add">
                                +
                            </button>
                        </span>
                            </div>
                        </c:if>
                    </div>
                </div>
                <%--<div class="clearfix"></div>--%>
                <%--<button id="updateSubmit" class="btn btn-primary btn-lg">Save</button>--%>
            </div>
        </div>
    </div>

    <!-- Page Content -->

</div>

<script src="<c:url value="/resources/js/adminpanel/questions-edit.js"/> "></script>
</body>
</html>
