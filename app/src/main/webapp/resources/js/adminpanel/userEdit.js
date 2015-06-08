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

$("#sendFeedback").on("submit", function (event) {
    event.preventDefault();
    var textValue = $(event.target[0]);
    var data = textValue.val();
    data = escapeHtml(data);
    $.ajax({
            method: "get",
            url: "http://localhost:8080/admin/createFeedback/" + userId,
            data: {
                "feedback": data
            },
            dataType: "html",
            success: function (data, status) {
                if (data = "OK") {
                    var p = $("<p></p>").text("Feedback successfully added");
                    p.addClass("text-success");
                    $("#sendFeedback").append(p);

                    setTimeout(function () {
                        $('#feedbackForm').modal('hide');
                        textValue.val("");
                        p.remove();
                    }, 1500);
                }
            }
        }
    );

});