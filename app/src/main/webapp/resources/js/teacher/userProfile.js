$("#sendFeedback").on("submit", function (event) {
    event.preventDefault();
    var textValue = $(event.target[0]);
    var data = textValue.val();
    data = escapeHtml(data);
    sendFeedback("http://localhost:8080/teacher/leavenote/" + userId, data);
});