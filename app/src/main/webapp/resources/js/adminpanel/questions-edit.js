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
};
