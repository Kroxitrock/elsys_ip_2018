$('#create').submit(function(e) {
    $.ajax({
        type: 'POST',
        url: '/api/movies',
        data: $("#create").serialize().toJSON(),
        success  : function(){
            alert("Added entry successfully.");
        },
        error : function () {
            alert("Failed to add entry.");
        }
    })
    e.preventDefault();
});