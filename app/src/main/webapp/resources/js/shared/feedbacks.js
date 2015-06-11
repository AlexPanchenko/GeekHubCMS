var entityMap = {
    "&": "&amp;",
    "<": "&lt;",
    ">": "&gt;",
    '"': '&quot;',
    "'": '&#39;',
    "/": '&#x2F;'
};

function escapeHtml(string) {
    return String(string).replace(/[&<>"'\/]/g, function (s) {
        return entityMap[s];
    });
}
var sendFeedback = function (url, feedback) {
    $.ajax({
            method: "get",
            url: url,
            data: {
                "feedback": feedback
            },
            dataType: "text",
            success: function (data) {
                if (data == "OK") {
                    var p = $("<p></p>").text("Feedback successfully added");
                    p.addClass("text-success");
                    $("#sendFeedback").append(p);
                    setTimeout(function () {
                        $('#feedbackForm').modal('hide');
                        $("#feedbackText").val("");
                        p.remove();
                    }, 1500);
                    return true;
                }
            }
        }
    );
};


$("#sendFeedback").on("submit", function (event) {
    event.preventDefault();
    var textValue = $(event.target[0]);
    var data = textValue.val();
    data = escapeHtml(data);
    sendFeedback(config.url +"/teacher/leavenote/" + userId, data);
});

$('#feedbackForm').on('shown.bs.modal', function (e) {
    var id = $(e.relatedTarget).prop("id");
    id = id.substr(4) * 1;
    window.userId = id;
});
