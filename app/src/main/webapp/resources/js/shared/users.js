(function() {
    var pagination;
    var init = function () {
        $.ajax({
            url: "ajax/countUsers",
            dataType: "text",
            success: function (count) {
                pagination = new Pagination({
                    itemsCount: count,
                    url: "ajax/usersShow",
                    maxSize: 5
                });
            }
        })
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

                setTimeout(function () {
                    alertDiv.remove()
                }, 3000);
            }
        });

        var sibl = $(this).siblings().click();
        pagination.reloadPage();
    });


    $(document).ready(function () {
        init();
    });
})();