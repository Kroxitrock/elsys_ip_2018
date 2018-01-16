$('#Search').submit(function(e){
    var $movies = $('#movies');
    $('#movies tr').remove();
    $('#deletescript').remove();
    var $data = "";
    if($('#id').val())
        $data+='id='+ $('#id').val()+'&';
    if($('#name').val())
        $data+='name='+ $('#name').val()+'&';
    if($('#genre').val())
        $data+='genre='+ $('#genre').val()+'&';
    if($('#owner').val())
        $data+='owner='+ $('#owner').val()+'&';
    if($('#director').val())
        $data+='director='+ $('#director').val()+'&';
    if($('#writer').val())
        $data+='writer='+ $('#writer').val()+'&';
    if($('#actors').val())
        $data+='actors='+ $('#actors').val()+'&';
    if($('#screenTime').val())
        $data+='screenTime='+ $('#screenTime').val()+'&';
    if($('#releaseDate').val())
        $data+='releaseDate='+ $('#releaseDate').val()+'&';
    if($('#score').val())
        $data+='score='+ $('#score').val()+'&';
    if($('#awards').val())
        $data+='awards='+ $('#awards').val();

    $.ajax({
        type: 'GET',
        url: '/api/movies',
        data:$data,
        dataType: 'json',
        success: function (movies) {
            $movies.append('<tr>' +
                            '<th>ID</th>' +
                            '<th>Name</th>' +
                            '<th>Genre</th>' +
                            '<th>Owner</th>' +
                            '<th>Director</th>' +
                            '<th>Writer</th>' +
                            '<th>Actors</th>' +
                            '<th>Screen Time</th>' +
                            '<th>Release Date</th>' +
                            '<th>Score</th>' +
                            '<th>Awards</th>' +
                            '</tr>')
            $.each(movies, function (i, movie) {
                $movies.append('<tr>'
                              +'<td>' + movie.id + '</td>'
                              +'<td>' +movie.name + '</td>'
                              +'<td>' +movie.genre + '</td>'
                              +'<td>' +movie.owner + '</td>'
                              +'<td>' +movie.director + '</td>'
                              +'<td>' +movie.writer + '</td>'
                              +'<td>' +movie.actors + '</td>'
                              +'<td>' +movie.screenTime + '</td>'
                              +'<td>' +movie.releaseDate + '</td>'
                              +'<td>' +movie.score + '</td>'
                              +'<td>' +movie.awards + '</td>'
                              +'<td><form action="api/movies/' + movie.id +'" id = "delete"><input type="submit" value="Delete" /></form></td>'
                              +'</tr>');
            });
           $('#body').append('<script src = "delete.js" id="deletescript"></script>');
        }
    });
    e.preventDefault();
});