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

var sendFeedback = function(url, feedback){
    $.ajax({
            method: "get",
            url: url,
            data: {
                "feedback": feedback
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
                    return true;
                }
            }
        }
    );
};