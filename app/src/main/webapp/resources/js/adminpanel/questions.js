(function () {
    var pagination = new Pagination({
            target: ".questions-box",
            limit: 15,
            url: config.url + "/admin/ajaxQuestions",
            maxSize: 5,
            countUrl: config.url + "/admin/countQuestions",
            getParams: function () {
                var course = $("#selectCourse").val();
                var testType = $("#selectTestType").val();

                return {
                    course: course != 0 ? course : undefined,
                    testType: testType != 0 ? testType: undefined
                }
            }
        }
    );


    $("#selectCourse").on("change", function (e) {
        var selectedCourse = $(this).val();
        var wrapper = $(".testTypeWrap");
        if (selectedCourse == 0) {
            wrapper.hide();
        } else {
            var testTypes = $("#selectTestType");
            $.ajax({
                url: config.url + "/admin/ajax/getTestType",
                data: {
                    courseId: selectedCourse
                },
                dataType: "json",
                success: function (data) {
                    testTypes.empty();
                    data.forEach(function (testType) {
                        console.log(testType);
                        $("<option>", {
                            value: testType.id,
                            text: testType.name
                        }).appendTo(testTypes);
                    });
                    wrapper.show();
                }

            });
        }
    });

    $("#questionsFilter").on("click", function () {
        pagination.firstPage();
    });

})();