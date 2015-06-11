function showNewPage(page) {
    $.ajax({
        url: "ajax/usersShow",
        type: "post",
        data: {page: page},
        success: function (data) {
            $("#rows").html(data);
            //Register handler on ajax load
            $(".view-feedbacks").on("click", function (event) {
                event.preventDefault();
                var userId = $(this).parent().siblings().first().val();
                showFeedbacks(userId);
            });
        }
    });
}
var showFeedbacks = function (userId) {
    $.ajax({
        url: config.url + "/teacher/showfeedbacks/" + userId,
        type: "get",
        success: function (data) {
            $(".row").toggleClass("hidden");
            $(".comment-box").html(data);

            $("#go-back").on("click", function(){
                $(".row").toggleClass("hidden");
                $(".comment-box").html("");
            })
        }
    });
};



function countUsers() {
    $.ajax({
        url: "ajax/countUsers",
        type: "post",
        data: '',
        success: function (data) {
        }
    });
}
$(document).ready(function () {
    countUsers();
    showNewPage(1);
});