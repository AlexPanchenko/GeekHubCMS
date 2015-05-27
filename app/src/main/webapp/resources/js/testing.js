/**
 * Created by admin on 25.05.2015.
 */

//setTimeout(sendAnswers(),3000);
    function sendAnswers() {
        var questions = [];
        questions = $('.question');

        var questionWrapList = [];
        var questionWrap;
        var customAnswer = null;
        [].forEach.call(questions, function (item, i, questions) {
            questionWrap = new function () {
                this.questionId = $(item).attr('id');
                this.customAnswer = $('#question' + this.questionId).find('textarea').val();
                var answers = $('#question' + this.questionId).find('.answer');
                console.log(answers);
                var tmp = [];
                [].forEach.call(answers, function (itemAnswer, i, answers) {
                    if ($(itemAnswer).prop('checked')) {
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
        }).done(function(){
            window.location = "/student/testing/endOfTest"
        })
    }

$(document).ready(function () {
});
