var selectClassroom = function (data) {
    $.ajax({
        url: "/teacher/students/classroom",
        type: "get",
        data: {classroomId: data},
        success: function (data) {
            $("#items").html(data);
        }
    });
};
