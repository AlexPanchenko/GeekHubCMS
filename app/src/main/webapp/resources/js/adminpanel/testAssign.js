$("#select-all").on("click", function (e) {
    e.preventDefault();
    $(':checkbox').each(function () {
        if($(this).attr("disabled")){
            return;
        }
        this.checked = !this.checked;
    });
});