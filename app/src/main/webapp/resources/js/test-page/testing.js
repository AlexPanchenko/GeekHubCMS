/**
 * Created by admin on 25.05.2015.
 */

//setTimeout(sendAnswers(),3000);
    function sendAnswers() {
        var questions = $('.question');
        var questionsArray = [];
        [].forEach.call(questions, function (question) {
            var questionId = $(question).attr("id").substr(9);
            var questionAnswers = [];
            var checkedAnswers = $(question).find(".answers").find(":checked");
            [].forEach.call(checkedAnswers, function (answer) {
                questionAnswers.push($(answer).attr("id").substr(7));
            });
            var result = {
                questionId: questionId,
                answersArray: questionAnswers,
                customAnswer: $(question).find("textarea").val()
            };
            console.log(result);
        });
        //[].forEach.call(questions, function (item, i, questions) {
        //    questionWrap = new function () {
        //        this.questionId = $(item).attr('id');
        //        this.customAnswer = $('#question' + this.questionId).find('textarea').val();
        //        var answers = $('#question' + this.questionId).find('.answer');
        //        var tmp = [];
        //        [].forEach.call(answers, function (itemAnswer, i, answers) {
        //            if ($(itemAnswer).prop('checked')) {
        //                tmp.push($(itemAnswer).attr('id'));
        //            }
        //        });
        //        this.answerArray = tmp;
        //    };
        //    questionWrapList.push(questionWrap);
        //});
        //console.log(questionWrapList);

        //var wrapperArray = JSON.stringify(questionWrapList);
        //$.ajax({
        //    url: '/student/testing/course/comletetest/' + $('#test-id').val(),
        //    type: 'POST',
        //    contentType: 'application/json',
        //    data: wrapperArray
        //}).done(function(){
        //    window.location = "/student/testing/endOfTest"
        //})
    }

$(document).ready(function () {
    $("send-test").on("click", sendAnswers);
    startTimer();
});
