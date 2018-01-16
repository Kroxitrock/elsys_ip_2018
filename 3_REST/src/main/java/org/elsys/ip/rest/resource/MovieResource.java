package org.elsys.ip.rest.resource;

import org.elsys.ip.rest.model.Movie;
import org.elsys.ip.rest.service.MovieService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.OutputStream;
import java.util.List;
import java.io.*;



@Path("movies")
public  class MovieResource {
    private MovieService movieService = new MovieService();

    /**
     * Returns all the available objects.
     *
     * @return List<Movie>
     */
    @GET
    @Produces("application/json")
    public List<Movie> getMovieList(@QueryParam(value = "id") List<Integer> id,
                                    @DefaultValue("")@QueryParam("name") String name,
                                    @DefaultValue("")@QueryParam("genre") String genre,
                                    @DefaultValue("")@QueryParam("owner") String owner,
                                    @DefaultValue("")@QueryParam("director") String director,
                                    @DefaultValue("")@QueryParam("writer") String writer,
                                    @DefaultValue("")@QueryParam("actors") String actors,
                                    @DefaultValue("0")@QueryParam("screenTime") double screenTime,
                                    @DefaultValue("0000/00/00")@QueryParam("releaseDate") String releaseDate,
                                    @DefaultValue("0")@QueryParam("score") double score,
                                    @DefaultValue("")@QueryParam("awards") String awards
    ) {
        List<Movie> movieList;
        if(!id.isEmpty()){
            movieList = movieService.getMovieById(id);
        }else movieList = movieService.getMovieList();
        return movieService.getMoviesByParams(movieList, name, genre, owner, director, writer, actors, screenTime, releaseDate, score, awards);
    }
    /**
     * Returns an object with the given ID.
     *
     * @param id unique identifier of an object
     * @return Movie
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Movie getMovie(@PathParam("id") Integer id) {
        return movieService.getMovieById(id);
    }


    /**
     * Endpoint, which when accessed by a browser enables file download.
     *
     * @return Response
     */
    @GET
    @Path("/download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadMovie() throws IOException {
        movieService.convertToCsv();
        File file = new File("f:\\Normandy\\movie.csv");
        return Response
                .ok((Object)file)
                .header("Content-Disposition", "attachment; filename=\"movie.csv\"")
                .build();
    }
    @POST
    @Path("/upload")  //Your Path or URL to call this service
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @DefaultValue("true") @FormDataParam("enabled") boolean enabled,
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {
        //Your local disk path where you want to store the file
        String uploadedFileLocation = "F:\\Normandy\\" + fileDetail.getFileName();
        System.out.println(uploadedFileLocation);
        // save it
        File  objFile=new File(uploadedFileLocation);

        saveToFile(uploadedInputStream, uploadedFileLocation);

        String output = "File uploaded via Jersey based RESTFul Webservice to: " + uploadedFileLocation;
        movieService.convertToClass(uploadedFileLocation);
        return Response.status(200).entity(output).build();

    }
    private void saveToFile(InputStream uploadedInputStream,
                            String uploadedFileLocation) {

        try {
            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    /**
     * Save endpoint
     *
     * @param movie - JSON object with id and name - the fields of Movie
     * @return the saved object
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Movie saveMovie(Movie movie) {
        return movieService.saveMovie(movie);
    }

    /**
     * Updates (in this case replaces) Test object with the given ID with the one in the parameters list.
     *
     * @param id
     * @param movie
     * @return
     */
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Movie updateMovie(@PathParam("id") Integer id, Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    /**
     * Deletes Movie with the given ID
     *
     * @param id
     */
    @DELETE
    @Path("/{id}")
    public void deleteMovie(@PathParam("id") Integer id) {
        movieService.deleteMovie(id);
    }

}
