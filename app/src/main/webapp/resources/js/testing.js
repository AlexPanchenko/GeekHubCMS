/**
 * Created by admin on 25.05.2015.
 */

//setTimeout(sendAnswers(),3000);
    function sendAnswers() {
        var questions = [];
        questions = $('.question');

        var questionWrapList = [];
        var questionWrap;


        [].forEach.call(questions, function (item, i, questions) {
            questionWrap = new function () {
                this.questionId = $(item).attr('id');
                var answers = $('#question' + this.questionId).find('.answer');
                console.log(answers);
                var tmp = [];
                [].forEach.call(answers, function (itemAnswer, i, answers) {
                    if ($(itemAnswer).attr('checked', true)) {
                        tmp.push($(itemAnswer).attr('id'));
                    }
                });
                this.answerArray = tmp;
            };
            questionWrapList.push(questionWrap);
        });
        console.log(questionWrapList);

        var wrapperArray = JSON.stringify(questionWrapList);
        $.ajax({
            url: '/student/testing/course/comletetest/' + $('.testId').attr("id"),
            type: 'POST',
            contentType: 'application/json',
            data: wrapperArray
        })
    }

$(document).ready(function () {
});
