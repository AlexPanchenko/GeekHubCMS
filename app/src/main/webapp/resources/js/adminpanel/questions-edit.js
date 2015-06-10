var addNewAnswer = function () {
    var inputGrp = $("<div></div>").addClass("input-group").appendTo($('.answer-box'));
    var checkboxWrap = $("<span></span>").addClass("input-group-addon").attr("id", "basic-addon1").appendTo(inputGrp);
    $('<input />', {
        type: 'checkbox'
    }).addClass("").appendTo(checkboxWrap);
    $('<input />', {
        "type": 'text',
        "value": name,
        "aria-describedby": "basic-addon1",
        "class": "form-control"
    }).appendTo(inputGrp);
    var deleteWrap = $("<span></span>").addClass("input-group-addon").attr("id", "basic-addon2").appendTo(inputGrp);
    var deleteHref = $("<a/>").addClass("fa fa-times deleteAnswer").appendTo(deleteWrap);
};

var updateQuestion = function (){
    //
};

$("#addAnswer").on("click", function(){
   addNewAnswer();
});

$(".answer-box").on("click", function(event){
    target = event.target;

    if($(target).hasClass("deleteAnswer")){
        event.preventDefault();
    }

    if($(target).attr("type") == "checkbox"){
        $(target).parent().toggleClass("right-answer");
    }

});


$(function(){
   addNewAnswer();
});