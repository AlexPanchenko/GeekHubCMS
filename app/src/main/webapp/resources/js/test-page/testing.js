var entityMap = {
    "&": "&amp;",
    "<": "&lt;",
    ">": "&gt;",
    '"': '&quot;',
    "'": '&#39;',
    "/": '&#x2F;'
};

function escapeHtml(string) {
    if (string != undefined) {
        return String(string).replace(/[&<>"'\/]/g, function (s) {
            return entityMap[s];
        });
    }
}

function sendAnswers() {
    var questions = $('.question');
    var answersArray = [];
    var answer;
    [].forEach.call(questions, function (question) {
        var questionId = $(question).attr("id").substr(9);
        var questionAnswers = [];
        var customAnswer = $(question).find("textarea").val();
        customAnswer = escapeHtml(customAnswer);
        var checkedAnswers = $(question).find(".answers").find(":checked");
        [].forEach.call(checkedAnswers, function (answer) {
            var id = $(answer).attr("id").substr(7);
            questionAnswers.push(id);
        });
        answer = {
            questionId: questionId,
            answersArray: questionAnswers
        };
        customAnswer ? answer.customAnswer = customAnswer : "";
        answersArray.push(answer);
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
    $("#send-answers").on("click", sendAnswers);
    startTimer();
});
