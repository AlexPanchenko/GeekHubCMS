var addNewAnswer = function () {
    var inputGrp = $("<div></div>").addClass("input-group").attr("id", "answer" + id).appendTo($('.answer-box'));
    var checkboxWrap = $("<span></span>").addClass("input-group-addon").attr("id", "basic-addon1").appendTo(inputGrp);
    $('<input />', {
        type: 'checkbox',
        "class": "right-answer-cb"
    }).addClass("").appendTo(checkboxWrap);
    $('<input />', {
        "type": 'text',
        "value": name,
        "aria-describedby": "basic-addon1",
        "class": "form-control answer-input"
    }).appendTo(inputGrp);
    var deleteWrap = $("<span></span>").addClass("input-group-addon").attr("id", "basic-addon2").appendTo(inputGrp);
    var deleteHref = $("<a/>").addClass("fa fa-times deleteAnswer").appendTo(deleteWrap);
};

var updateQuestion = function () {
    var answersArray = [];
    var tmpArray = [];
    var inputs = $(".input-group");
    answersArray = [].map.call(inputs, function (el) {
        var answer = {};
        answer.id = "answer" + ($(el).attr("id") || 0);
        answer.text = $(el).find(".answer-input").val();
        answer.right = $(el).find(".right-answer-cb").prop('checked');
        return answer;

    });


    console.log(answers);

};

$("#addAnswer").on("click", function () {
    addNewAnswer();
});

$(".answer-box").on("click", function (event) {
    target = event.target;

    if ($(target).hasClass("deleteAnswer")) {
        event.preventDefault();
        $(target).parent().parent().remove();
    }

    if ($(target).attr("type") == "checkbox") {
        $(target).parent().toggleClass("right-answer");
    }

});


$(function () {
    addNewAnswer();
});