var changeValue = function() {
    document.getElementById('testTypeId').value = $('#selectTestType option:selected').attr('id');
};

var changeValueUpdate = function() {
    document.getElementById('testTypeIdUpdate').value = $('#selectTestType2 option:selected').attr('id');
};

$("form").submit(function () {

    var this_master = $(this);

    this_master.find('input[type="checkbox"]').each(function () {
        var checkbox_this = $(this);


        if (checkbox_this.is(":checked") == true) {
            checkbox_this.attr('value', 'true');
        } else {
            checkbox_this.prop('checked', true);
            //DONT' ITS JUST CHECK THE CHECKBOX TO SUBMIT FORM DATA
            checkbox_this.attr('value', 'false');
        }
    })
});