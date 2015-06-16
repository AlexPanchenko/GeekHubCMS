var queueDeletion = (function () {
    var answersToDelete = [];
    return {
        getQueue: function () {
            return answersToDelete;
        },
        addAnswer: function (answerId) {
            answersToDelete.push(parseInt(answerId))
        }
    }
})();

var getAnswerId = function (answer) {
    if (answer) {
        return answer.substring(6);
    }
};

var isManyAnswers = function (answers) {
    var rightCount = answers.filter(function (answer) {
        return answer.answerRight === true;
    }).length;
    return rightCount > 1;
};

var updateAnswers = function () {
    var answersArray = [];
    var inputs = $(".input-group");
    answersArray = [].map.call(inputs, function (el) {
        var id = $(el).attr("id");
        var text = $(el).find(".answer-input").val();
        var right = $(el).find(".input-group-select-val").val() === "true";
        //If answer text is empty, then answer will not send
        if (text === "") {
            return;
        }
        var answer = {
            answerText: text,
            answerRight: right
        };
        //New answers must be send without id
        if (id) {
            answer.id = getAnswerId(id);
        }
        return answer;
    }).filter(function (answer) {
        return answer != undefined;
    });
    return answersArray;

};

$("#updateSubmit").on("click", function (e) {
    var answers = updateAnswers();
    $(".answersList").val(JSON.stringify(answers));
    $(".manyAnswers").val(isManyAnswers(answers));
    $("#answersToDelete").val(queueDeletion.getQueue());
    $("#edit").submit();
});

$("#createSubmit").on("click", function (e) {
    var answers = updateAnswers();
    $(".manyAnswers").val(isManyAnswers(answers));
    $(".answersList").val(JSON.stringify(answers));
    $("#create").submit();
});

(function ($) {
    $(function () {

        var addFormGroup = function (event) {
            event.preventDefault();

            var $formGroup = $(this).closest('.form-group');
            var $multipleFormGroup = $formGroup.closest('.multiple-form-group');
            var $formGroupClone = $formGroup.clone();

            $(this)
                .toggleClass('btn-danger btn-remove btn-success btn-add')
                .html('-');

            $formGroupClone.removeAttr("id");
            $formGroupClone.find('input').val('');
            $formGroupClone.find('.concept').text('Incorrect');
            $formGroupClone.insertAfter($formGroup);


            $formGroupClone.find(".dropdown-toggle").removeClass("btn-success").addClass("btn-danger");
            var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
            if ($multipleFormGroup.data('max') <= countFormGroup($multipleFormGroup)) {
                $lastFormGroupLast.find('.btn-add').attr('disabled', true);
            }
            var $selectGroup = $(this).closest('.input-group-select').val(false);
        };

        var removeFormGroup = function (event) {
            event.preventDefault();

            var $formGroup = $(this).closest('.form-group');
            var $multipleFormGroup = $formGroup.closest('.multiple-form-group');

            var $lastFormGroupLast = $multipleFormGroup.find('.form-group:last');
            if ($multipleFormGroup.data('max') >= countFormGroup($multipleFormGroup)) {
                $lastFormGroupLast.find('.btn-add').attr('disabled', false);
            }
            var answerId = getAnswerId($formGroup.attr("id"));
            if (answerId) {
                queueDeletion.addAnswer(answerId);
            }
            $formGroup.remove();
        };

        var selectFormGroup = function (event) {
            event.preventDefault();

            var $selectGroup = $(this).closest('.input-group-select');
            var param = $(this).attr("href").replace("#", "");
            var concept = $(this).text();
            $selectGroup.find('.concept').text(concept);
            $selectGroup.find('.input-group-select-val').val(param);
            var btn = $selectGroup.find(".btn");
            if (param === "true") {
                btn.removeClass("btn-danger");
                btn.addClass("btn-success");
            } else {
                btn.removeClass("btn-success");
                btn.addClass("btn-danger");
            }

        };

        var countFormGroup = function ($form) {
            return $form.find('.form-group').length;

        };

        $(document).on('click', '.btn-add', addFormGroup);
        $(document).on('click', '.btn-remove', removeFormGroup);
        $(document).on('click', '.dropdown-menu a', selectFormGroup);

    });
})(jQuery);