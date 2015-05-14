/**
 * Created by victor on 08/03/15.
 */

$(document).ready(function () {
    var $signIn = $('.js-sign-in');
    // Event handlers
    $('.js-register').on('change', function () {
        $('.js-field-reg').slideToggle();
    });
    $('.js-submit').on('click', function (e) {
        e.preventDefault();
        signIn($('.js-register').is(':checked'));
    });

    function signIn (isReg) {
        var form = new Forms();
        var reqData = {
            name: $('.js-name').val(),
            lastName: $('.js-lastName').val(),
            email: $('.js-email').val(),
            pass: $('.js-pass').val(),
            phone: $('.js-phone').val(),
            skype: $('.js-skype').val()
        };
        if (! reqData.email || ! reqData.pass) {
            form.showErr($signIn, 'Fields shouldn\'t be empty');
            return;
        }
        var errEmailValid = form.validate('email', reqData.email);
        if (errEmailValid.err) {
            form.showErr($signIn, errEmailValid.msg);
            return;
        }
        if (isReg) {
            reqData.confirmPass = $('.js-confirm-pass').val();
            if (! reqData.name || ! reqData.confirmPass) {
                form.showErr($signIn, 'Fields shouldn\'t be empty');
                return;
            }
            var errPassValid = form.validate('pass', {
                pass: reqData.pass,
                confirmPass: reqData.confirmPass
            });
            if (errPassValid.err) {
                form.showErr($signIn, errPassValid.msg);
                return;
            }
        }
        $.ajax({
            url: isReg ? '/register' : '/login',
            type: 'POST',
            data: reqData
        }).done(function (response) {
            response = JSON.parse(response);
            if (response.error) {
                form.showErr($signIn, response.errorMessage);
            } else if (response.redirectType) {
                document.location.href = response.redirectUrl;
            }
        });
    }
});