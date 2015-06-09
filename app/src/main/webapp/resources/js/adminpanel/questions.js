var selectCourse = function() {
    if ($('#selectCourse option:selected').attr('id') == 0) {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'hidden';
        document.getElementById('selectTestType').style.visibility = 'hidden';
        window.location.replace("/admin/questions");
    } else {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'visible';
        document.getElementById('selectTestType').style.visibility = 'visible';

        $('#linkCreateQuestionByCourse').attr("href", "/admin/course/" + $('#selectCourse option:selected').attr('id') + "/question/create");
        var redirectTo = "/admin/course/" + $('#selectCourse option:selected').attr('id') + "/questions/";
        window.location.replace(redirectTo);

//          $.get("/admin/questions/" + $('#selectCourse option:selected').attr('id'), function(data){
//              $('#page-content-wrapper').load('questions.jsp');
//            alert(data);
        //document.getElementById("selectTestType").setAttribute("${testTypeList}");
//          })
    }

};

var selectTestType = function() {
    if ($('#selectTestType option:selected').attr('id') == "testType0") {
    } else {
        var redirectTo = "/admin/course/" + currentCourse +"/testType/" + $('#selectTestType option:selected').attr('id') + "/questions/";
        window.location.replace(redirectTo);
    }
};

$(document).ready(function () {
    //<%--document.getElementById('selectCourse').selectedIndex = ${currentCourse};--%>

    if ($('#selectCourse option:selected').attr('id') == 0) {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'hidden';
        document.getElementById('selectTestType').style.visibility = 'hidden';

    } else {
        document.getElementById('linkCreateQuestionByCourse').style.visibility = 'visible';
        document.getElementById('selectTestType').style.visibility = 'visible';
        $('#linkCreateQuestionByCourse').attr("href", "/admin/course/" + $('#selectCourse option:selected').attr('id') + "/question/create");
    }
});

//Event handlers
$("#selectTestType").on("change", function () {
    selectTestType();
});

$("#selectCourse").on("change", function(){
    selectCourse();
});