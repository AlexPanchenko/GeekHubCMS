(function() {
    var pagination;
    var init = function () {
                pagination = new Pagination({
                    target: "#rows",
                    url: "ajax/usersShow",
                    maxSize: 5,
                    countUrl: "ajax/countUsers"
                });
    };

    $("#rows").on("click", ".view-feedbacks", function (event) {
        event.preventDefault();
        var userId = $(this).closest("td").find("input").val();
        showFeedbacks(userId);
    });

    var showFeedbacks = function (userId) {
        $.ajax({
            url: config.url + "/teacher/showfeedbacks/" + userId,
            type: "get",
            success: function (data) {
                $(".row").toggleClass("hidden");
                $(".comment-box").html(data);

                $("#go-back").on("click", function () {
                    $(".row").toggleClass("hidden");
                    $(".comment-box").html("");
                })
            }
        });
    };

    $("#delete-confirm").on("click", ".delete-confirm", function (e) {
        e.preventDefault();
        var url = $(this).attr("href");
        $.ajax({
            url: url,
            success: function (response) {
                var alertDiv = $("<div/>",{
                    "class": "alert alert-danger alert-absolute",
                    "text": response
                }).appendTo($("#wrapper"));
                var a = $("<a/>", {
                    "class": "close glyphicon glyphicon-remove",
                    "data-dismiss": "alert",
                    "text": ""
                }).appendTo(alertDiv);
                pagination.reloadPage();
                setTimeout(function () {
                    alertDiv.remove();
                }, 3000);
            }
        });

        $(this).siblings().click();
    });


    $(document).ready(function () {
        init();
    });
})();