/**
 * Created by admin on 25.05.2015.
 */
$(document).ready(function () {
    var questions = new Array();
    questions = $('.question');

    var questionWrapList =  [];
    var questionWrap;


    [].forEach.call(questions, function(item, i, questions){
        questionWrap =  new function(){
            this.questionId = $(item).attr('id');
            this.answerArray = [];

            var answers = $('#'+this.questionId).find('.answer');
            console.log(answers);

            [].forEach.call(answers, function(itemAnswer, i, answers) {
                alert("GGGGGGGGGGGGG");
                if ($(itemAnswer).checked(true)){
                    this.answerArray.push($(itemAnswer).attr('id'));
                }
            });
        }
        questionWrapList.push(questionWrap);
    });
    console.log(questionWrapList);
});

