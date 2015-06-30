(function ($) {
    $("#select-all").on("click", function (e) {
        e.preventDefault();
        $(':checkbox').each(function () {
            if ($(this).attr("disabled")) {
                return;
            }
            this.checked = !this.checked;
        });
    });


    $("#selectTestConfig").on("change", function () {
        var configId = $(this).find(":selected").val();
        window.location = config.url + "/admin/assignTest/" + configId;
    });
})(jQuery);