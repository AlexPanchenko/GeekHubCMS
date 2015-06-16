var selectCourse = function () {
    var selectedCourse = $('#selectCourse option:selected');
    if (selectedCourse.attr('id') == 0) {
        $("#addQuestion").hide();
        $(".testTypeWrap").hide();
        window.location.replace("/admin/questions");
    } else {
        $("#addQuestion").show();
        $(".testTypeWrap").show();

        $('addQuestion').attr("href", "/admin/course/" + selectedCourse.attr('id') + "/question/create");
        var redirectTo = "/admin/course/" + selectedCourse.attr('id') + "/questions/";
        window.location.replace(redirectTo);
    }

};

var selectTestType = function () {
    var redirectTo;
    if ($('#selectTestType option:selected').attr('id') == "testType0") {
        console.log("hello");
        redirectTo = "/admin/course/" + currentCourse + "/questions/";
    } else {
        redirectTo = "/admin/course/" + currentCourse + "/testType/" + $('#selectTestType option:selected').attr('id') + "/questions/";
    }
    window.location.replace(redirectTo);
};

$(document).ready(function () {
    var selectedCourse = $('#selectCourse option:selected'),
        addQuestionBtn = $('#addQuestion');
    if (selectedCourse.attr('id') == 0) {
        addQuestionBtn.hide();
        $('.testTypeWrap').hide();

    } else {
        addQuestionBtn.show();
        $('.testTypeWrap').show();
        addQuestionBtn.attr("href", "/admin/course/" + selectedCourse.attr('id') + "/question/create");
    }
});

//Event handlers
$("#selectTestType").on("change", selectTestType);

$("#selectCourse").on("change", selectCourse);