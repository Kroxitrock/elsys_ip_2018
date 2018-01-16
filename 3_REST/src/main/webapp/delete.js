$(document).ready(function () {

    $('#delete').submit(function(e) {
        $.ajax({
            type: 'DELETE',
            url: $(this).attr('action'),
            success  : function(){
                alert("Deleted entry successfully.");
            },
            error : function () {
                alert("Failed to delete entry.");
            }
        })
    });
    e.preventDefault();
});