package org.elsys.ip.rest.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVReader;
import org.elsys.ip.rest.model.Movie;
import org.elsys.ip.rest.repository.MovieRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieService {

  private MovieRepository movieRepository = new MovieRepository();

  public List<Movie> getMoviesByParams(List<Movie> list,
                                       String name,
                                       String genre,
                                       String owner,
                                       String director,
                                       String writer,
                                       String actors,
                                       double screenTime,
                                       String releaseDate,
                                       double score,
                                       String awards) {
    List<Movie> movieList = new ArrayList<>();
    for (Movie movie:
         list) {
      movieList.add(movie);
    }
    if(!name.equals(""))
      movieList.removeIf(movie -> !movie.getName().equals(name));
    if(!genre.equals(""))
      movieList.removeIf(movie -> !movie.getGenre().equals(genre));
    if(!owner.equals(""))
      movieList.removeIf(movie -> !movie.getOwner().equals(owner));
    if(!director.equals(""))
      movieList.removeIf(movie -> !movie.getDirector().equals(director));
    if(!writer.equals(""))
      movieList.removeIf(movie -> !movie.getWriter().equals(writer));
    if(!actors.equals(""))
      movieList.removeIf(movie -> !movie.getActors().equals(actors));
    if(screenTime != 0)
      movieList.removeIf(movie -> movie.getScreenTime() != screenTime);
    if(!releaseDate.equals("0000/00/00"))
      movieList.removeIf(movie -> !movie.getReleaseDate().equals(new Date(releaseDate)));
    if(score != 0)
      movieList.removeIf(movie -> movie.getScore() != score);
    if(!awards.equals(""))
      movieList.removeIf(movie -> !movie.getName().equals(awards));
    return movieList;
  }

  public List<Movie> getMovieList() {
    return movieRepository.getMovieList();
  }

  public List<Movie> getMovieById(List<Integer> ids) {
    List<Movie> movieList = new ArrayList<>();
    for (Integer id:
         ids) {
      movieList.add(getMovieById(id));
    }
    return  movieList;
  }
  public Movie getMovieById(Integer id) {
    return movieRepository.getMovieById(id).orElse(null);
  }

  public Movie saveMovie(Movie movie) {
    return movieRepository.saveMovie(movie);
  }

  public Movie updateMovie(Integer id, Movie movie) {
    return movieRepository.updateMovie(id, movie);
  }

  public void deleteMovie(Integer id) {
    movieRepository.deleteMovie(id);
  }

  public void convertToCsv() throws IOException {
    List<Movie> movieList = movieRepository.getMovieList();
    CsvMapper mapper = new CsvMapper();
    CsvSchema schema = mapper.schemaFor(Movie.class).withHeader();
    schema = schema.withColumnSeparator('\t');

    ObjectWriter myObjectWriter = mapper.writer(schema);
    File tempFile = new File("f:\\Normandy\\movie.csv");
    FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
    OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
    myObjectWriter.writeValue(writerOutputStream, movieList);
  }
  public void convertToClass(String Location) throws IOException {
    CsvMapper mapper = new CsvMapper();
    File file = new File(Location);
    CsvSchema schema = mapper.schemaFor(Movie.class).withHeader();
    schema = schema.withColumnSeparator('\t');

    MappingIterator<Movie> it = mapper.readerFor(Movie.class).with(schema)
            .readValues(file);
    List<Movie> movieList = it.readAll();
    for (Movie movie1:
         movieList) {
      saveMovie(movie1);
    }
  }
}
