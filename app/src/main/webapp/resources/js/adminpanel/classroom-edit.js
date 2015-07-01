(function () {
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


    $("#save-classroom").validate({
            errorClass: "text-danger",
            rules: {
                "classroom-name": "required",
                "classroom-description": "required"
            },
            submitHandler: function () {
                var course = $('#course').val();
                var teacher = $('#teacher').val();
                var className = $('#classroom-name').val();
                var classId = $('#classroom-id').val();
                var classDescription = $('#classroom-description').val();
                var url = classId ? "/admin/classroom/edit" : "/admin/ajax/createClassroom";
                var message = "Classroom successfully ";
                message += classId ? "updated" : "added";
                if (course != "" && className != "" && classDescription != "")
                    $.ajax({
                        url: url,
                        type: "post",
                        data: {
                            courseId: course,
                            teacherId: teacher,
                            className: className,
                            classDescription: classDescription,
                            classId: classId
                        },
                        success: function (data) {
                            $('#alert-box').html('<div class="alert alert-success"><a class="close" data-dismiss="alert">&times;</a><span>' + message + '</span></div>');
                            setTimeout(function () {
                                window.location = data;
                            }, 2000)
                        }
                    });
            }
        }
    );
})();