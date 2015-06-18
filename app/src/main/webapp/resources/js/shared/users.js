var init = function () {
    $.ajax({
        url: "ajax/countUsers",
        dataType: "text",
        success: function (count) {
            window.pagination = new Pagination();
            pagination.init({
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


$(document).ready(function () {
    init();
});