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
        },
        messages: {
            confirmPassword: {
                equalTo: "Passwords must be equals"
            }
        }
    }
);
