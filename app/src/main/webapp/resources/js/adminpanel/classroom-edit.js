var showUsers = function (course) {
    $.ajax({
        url: "/admin/ajax/usersOnCourse",
        type: "post",
        data: {course: course},
        success: function (data) {
            $("#users").html(data);
        }
    });
};

var saveEdits = function () {
    var users = $('.inlineCheckbox1:checked');
    var idUsers = [];
    for (var i = 0; i < users.length; i++)
        idUsers.push(users[i].value);
    var course = $('#course').val();
    var teacher = $('#teacher').val();
    var className = $('#ClassroomName').val();
    var classDescription = $('#ClassroomDescription').val();
    if (course != "" && className != "" && classDescription != "")
        $.ajax({
            url: "/admin/classroom/edit",
            type: "post",
            data: {
                usersId: idUsers,
                courseId: course,
                teacherId: teacher,
                className: className,
                classDescription: classDescription,
                classId: classId
            },
            success: function (data) {
                window.location = data;
            }
        });
    else
        $("#error-message").html("Fill in all required fields!");
};