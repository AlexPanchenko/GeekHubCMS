//function showNewPage(page, callback) {
//    $.ajax({
//        url: "ajax/usersShow",
//        type: "post",
//        data: {page: page},
//        success: function (data) {
//            $("#rows").html(data);
//            callback();
//        }
//    });
//}

var pagination = {
    pagesCount: $(".pagination").attr("data-pages-count"),
    currentPage: 1,
    showNewPage: function (page, callback) {
        this.currentPage = page;
        $.ajax({
            url: "ajax/usersShow",
            data: {page: page},
            success: function (data) {
                $("#rows").html(data);
                callback();
            }
        });
    },
    showNextPage: function(){
        if(this.currentPage < this.pagesCount){
            this.showNewPage(++this.currentPage, addFeedbackListeners);
        }
    },
    showPreviousPage: function(){
        if(this.currentPage > 1){
            this.showNewPage(--this.currentPage, addFeedbackListeners);
        }
    }
};


var addFeedbackListeners = function () {
    $(".view-feedbacks").on("click", function (event) {
        event.preventDefault();
        var userId = $(this).parent().siblings().first().val();
        showFeedbacks(userId);
    })
};

$(".pagination").on("click", function (e) {
    e.preventDefault();
    var target = e.target;
    if($(target).hasClass("page-number")){
        var page = $(e.target).attr("id").substr(4);
        pagination.showNewPage(page, addFeedbackListeners)
    }
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


//function countUsers() {
//    $.ajax({
//        url: "ajax/countUsers",
//        type: "post",
//        data: '',
//        success: function (data) {
//        }
//    });
//}
$(document).ready(function () {
    //countUsers();
    pagination.showNewPage(1, addFeedbackListeners);
});