/**
 * Created by user on 05.06.2015.
 */

var isValidPhone = function (phoneNumber) {
    //regexp pattern
};


$("#registration-form").validate({
        errorClass: "error",
        rules: {
            email: "required",
            firstName: "required",
            lastName: "required",
            password: {
                required: true,
                minlength: 6,
                maxlength: 24
            },
            confirmPassword: {
                required: true,
                minlength: 6,
                maxlength: 24,
                equalTo: "#password"
            }
            //phoneNumber: isValidPhone($("#phoneNumber").val())
        },
        messages: {
            confirmPassword: {
                equalTo: "Passwords must be equals"
            }
        }
    }
);
