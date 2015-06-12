$('#delete-confirm').on('show.bs.modal', function(e) {
    $(this).find('.delete-confirm').attr('href', $(e.relatedTarget).data('href'));
});