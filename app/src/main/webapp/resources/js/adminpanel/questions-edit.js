var addNewAnswer = function () {
    var inputGrp = $("<div></div>").addClass("input-group").appendTo($('.answer-box'));
    var checkboxWrap = $("<span></span>").addClass("input-group-addon").attr("id", "basic-addon1").appendTo(inputGrp);
    $('<input />', {
        type: 'checkbox',
        "class": "right-answer-cb"
    }).addClass("").appendTo(checkboxWrap);
    $('<input />', {
        "type": 'text',
        "value": name,
        "aria-describedby": "basic-addon1",
        "class": "form-control answer-input",
        "placeholder": "input answer here"
    }).appendTo(inputGrp);
    var deleteWrap = $("<span></span>").addClass("input-group-addon").attr("id", "basic-addon2").appendTo(inputGrp);
    var deleteHref = $("<a/>").addClass("fa fa-times deleteAnswer").appendTo(deleteWrap);
};

function deleteListArray() {
    var waitingToDelete = [];
    return function (id) {
        if(id){
            return waitingToDelete.push(parseInt(id));
        } else {
            return waitingToDelete;
        }
    };
}

var addToDeleteList = deleteListArray();

var getAnswerId = function (answer) {
    if (answer) {
        return answer.substring(6);

    }
};


var updateAnswers = function () {
    var answersArray = [];
    var inputs = $(".input-group");
    answersArray = [].map.call(inputs, function (el) {
        var id = $(el).attr("id");
        var text = $(el).find(".answer-input").val();
        var right = $(el).find(".right-answer-cb").prop('checked');
        //If answer text is empty, then answer will not send
        if (text === "") {
            return;
        }
        var answer = {
            answerText: text,
            answerRight: right
        };
        //New answers must be send without id
        if (id) {
            answer.id = getAnswerId(id);
        }
        return answer;
    }).filter(function (answer) {
        return answer != undefined;
    });
    return JSON.stringify(answersArray);

};

$("#addAnswer").on("click", addNewAnswer);

$(".answer-box").on("click", function (event) {
    target = event.target;

    if ($(target).attr("type") == "checkbox") {
        $(target).parent().toggleClass("right-answer");
    }

    if ($(target).hasClass("deleteAnswer")) {
        event.preventDefault();
        var answer = $(target).closest(".input-group");
        answer.remove();
        addToDeleteList(getAnswerId(answer.attr("id")));
    }
});

$("#updateSubmit").on("click", function () {
    var answers = updateAnswers();
    $("#answersList").val(answers);
    $("#answersToDelete").val(addToDeleteList());
    $("#edit").submit();
});



$(function () {
    addNewAnswer();
});
