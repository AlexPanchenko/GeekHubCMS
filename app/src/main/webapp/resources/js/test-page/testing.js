function sendAnswers() {
    var questions = $('.question');
    var answersArray = [];
    [].forEach.call(questions, function (question) {
        var questionId = $(question).attr("id").substr(9);
        var questionAnswers = [];
        var checkedAnswers = $(question).find(".answers").find(":checked");
        [].forEach.call(checkedAnswers, function (answer) {
            var id = $(answer).attr("id").substr(7);
            questionAnswers.push(id);
        });
        answersArray.push({
            questionId: questionId,
            answersArray: questionAnswers,
            customAnswer: $(question).find("textarea").val()
        });
    });

    $.ajax({
        url: '/student/testing/course/completetest/' + $('#test-id').val(),
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(answersArray)
    }).done(function () {
        window.location = "/student/testing/endOfTest"
    })
}

$(document).ready(function () {
    $("send-test").on("click", sendAnswers);
    startTimer();
});
