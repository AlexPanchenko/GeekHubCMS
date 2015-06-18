var init = function () {
    $.ajax({
        url: "ajax/countUsers",
        dataType: "text",
        success: function (count) {
            window.pagination = new Pagination({
                itemsCount: count,
                currentPage: 1,
                url: "ajax/usersShow",
                maxSize: 5
            });
            pagination.showNewPage(1);
        }
    })
};
var paginationContainer = $(".pagination");

$("#rows").on("click", ".view-feedbacks", function (event) {
    event.preventDefault();
    var userId = $(this).parent().siblings().first().val();
    showFeedbacks(userId);
});

paginationContainer.on("click", ".page-number", function () {
    var page = $(this).attr("id").substr(4);
    pagination.showNewPage(page)
});

paginationContainer.on("click", "#next-page", function(){
    pagination.nextPage();
});

paginationContainer.on("click", "#prev-page", function(){
    pagination.previousPage();
});

paginationContainer.on("click", "#first-page", function(){
    pagination.firstPage();
});

paginationContainer.on("click", "#last-page", function(){
    pagination.lastPage();
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