/**
 * Created by victor on 15/03/15.
 */

//Validators
function Forms() {
    this.validate = function (type, val) {
        var error;
        switch (type) {
            case 'email':
                var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                error = {
                    err: ! regex.test(val)
                };
                if (error.err) {
                    error.msg = 'Email is not valid';
                }
                break;
            case 'pass':
                error = {
                    err: val.pass.length < 6
                };
                if (error.err) {
                    error.msg = 'Password length should be more than 6 characters';
                } else {
                    error.err = val.pass !== val.confirmPass;
                    if (error.err) {
                        error.msg = 'Password doesn\'t match';
                    }
                }
                break;
        }
        return error;
    };
    this.showErr = function ($form, errorMessage, top) {
        var errMsg = $('<p></p>').addClass('err-msg').text(errorMessage);
        top ? $form.prepend(errMsg) : $form.append(errMsg);
        setTimeout(function () {
            errMsg.fadeOut(function () {
                errMsg.remove();
            })
        }, 2000)
    }
}
