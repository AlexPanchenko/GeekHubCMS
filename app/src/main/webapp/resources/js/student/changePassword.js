var changePassword = function (userData, callback) {
    $.ajax({
            method: "post",
            url: config.url + "/student/" + userData.userId + "/changepasswordfromprofile",
            data: {
                "oldpassword": userData.oldPwd,
                "newpassword": userData.newPwd,
                "confirmpassword": userData.confirmPwd
            },
            dataType: "text",
            success: function (response) {
                callback(response)
            },
            error: function (error) {
                console.log(error);
            }
        }
    );
};

$("#changePwd").on("submit", function (e) {
    e.preventDefault();
    var userData = {
        userId: $("#user-id").val(),
        oldPwd: $("#oldPassword").val(),
        newPwd: $("#newPassword").val(),
        confirmPwd: $("#confirmPassword").val()
    };
    changePassword(userData, function(response){
            $("#change-status").html(response);
    });
});


$('#change-password').on('hidden.bs.modal', function (e) {
    $("#user-id").val("");
    $("#oldPassword").val("");
    $("#newPassword").val("");
    $("#confirmPassword").val("");
    $("#change-status").html("");
});
