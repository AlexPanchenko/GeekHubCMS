<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <jsp:include page="../source.jsp"></jsp:include>
    <script>
        var score;

        $(document).ready(function(){
            score = $('#score').attr('value');
        });

        function rightAnswer(userResultsId){
            $('#right'+userResultsId).prop('disabled',true);
            $('#wrong'+userResultsId).prop('disabled',true);
            score = parseInt(score) + parseInt("1");
            $('#score').attr('value',score);
            $.ajax({
                url:"/admin/calculateTrueAnswer",
                type:"post",
                data:{userResultsId:userResultsId},
                success:function(data) {
                }
            });
        }
        function calculateResult(testAsId,userId){
            $.ajax({
                url:"/admin/calculateNewCount",
                type:"post",
                data:{testAsId:testAsId,score:score},
                success:function(data) {
                    window.location.href = "/admin/answerResult/"+userId;
                }
            });
        }
        function wrongAnswer(userResultsId){
            $('#right'+userResultsId).prop('disabled',true);
            $('#wrong'+userResultsId).prop('disabled',true);
        }
    </script>
</head>
<body>
    <jsp:include page="myNavbar.jsp"></jsp:include>
    <div id="wrapper">
        <jsp:include page="sidebar.jsp"></jsp:include>
      <div class="page-wrapper-content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="alert alert-success text-center">
                        <b>Test result</b></h1>
                    <div class="col-lg-6"></div>
                    <c:forEach items="${testWra}" var="testWrap">
                        <div class="mark-question">
                            <th>${testWrap.question.questionText}</th>
                        </div>
                        <table class="table text-black">
                            <tr>
                                <th>
                                    <c:forEach var="item" items="${testWrap.question.answers}">
                                       <c:forEach var="usAnswer" items="${testWrap.userAnswers}">

                                             <c:set var="userResultsId" value="${usAnswer.userResults.id}"/>
                                             <c:set var="score" value="${testWrap.score}"/>
                                             <c:set var="globalTestWrap" value="${testWrap}"/>

                                             <c:if test="${(item.id == usAnswer.answer.id) and (usAnswer.customAnswer == null)}">
                                                <p style="margin-left: 30px;margin-bottom: -3px;"><input type="checkbox" class="inlineCheckbox1"  checked="checked" disabled> ${item.answerText}
                                                    <c:if  test="${(item.answerRight) and (!testWrap.question.myAnswer)}">
                                                        <img src="<c:url value='/resources/img/right.png'/>" height="15" width="15" style="margin-bottom: 5px"/>
                                                    </c:if>
                                                    <c:if  test="${(!item.answerRight) and (!testWrap.question.myAnswer)}">
                                                        <img src="<c:url value='/resources/img/wrong.png'/>" height="15" width="15" style="margin-bottom: 5px"/>
                                                    </c:if>
                                                </p>
                                             </c:if>

                                             <c:if test="${(item.id != usAnswer.answer.id) and (usAnswer.customAnswer == null)}">
                                                <p style="margin-left: 30px;margin-bottom: -3px;"><input type="checkbox" class="inlineCheckbox1" disabled> ${item.answerText}</p>
                                             </c:if>

                                             <c:if test="${usAnswer.customAnswer != null}">
                                                <c:set var="custAnswer" value="${usAnswer}"/>
                                                <c:set var="userCustRes" value="${testWrap}"/>
                                             </c:if>

                                       </c:forEach>
                                    </c:forEach>

                                    <c:if test="${custAnswer != null}">

                                        <span class="label label-info" style="margin-left: 30px;">My Answer</span>
                                        <span class="label label-answer">${custAnswer.customAnswer}</span>
                                        <c:if  test="${userCustRes.right and userCustRes.review}">
                                            <img src="<c:url value='/resources/img/right.png'/>" height="15" width="15" style="margin-bottom: 5px"/>
                                        </c:if>
                                        <c:if  test="${!userCustRes.right and userCustRes.review}">
                                            <img src="<c:url value='/resources/img/wrong.png'/>" height="15" width="15" style="margin-bottom: 5px"/>
                                        </c:if>

                                        <div class="pull-right">
                                            <c:if test="${custAnswer != null}">
                                                <button class="btn btn-success" id="right${userResultsId}" onclick="rightAnswer(${userResultsId})">Right</button>
                                                <button class="btn btn-danger" id="wrong${userResultsId}" onclick="wrongAnswer(${userResultsId})">Wrong</button>
                                            </c:if>
                                        </div>

                                        <c:set var="custAnswer" value="${null}"/>
                                    </c:if>
                                </th>
                            </tr>
                        </table>
                    </c:forEach>

                    <label for="score">Score: </label> <input type="text" id="score" value="${score}" disabled>
                    <button  class="btn btn-success" onclick="calculateResult(${globalTestWrap.testAssignmentId},${userId})">Confirm</button>

                </div>
            </div>
        </div>
      </div>
    </div>

    <script>
        $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>
</body>
</html>
