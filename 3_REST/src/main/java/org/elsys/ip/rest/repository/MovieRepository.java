package org.elsys.ip.rest.repository;

import org.elsys.ip.rest.model.Movie;

import java.util.*;

public class MovieRepository {
    private static List<Movie> movieList = new ArrayList<>(
            Arrays.asList(
                    new Movie(1, "The Room", "Nobody knows", "Tommy Wiseau", "Tommy Wiseau", "Tommy Wiseau", "Tommy Wiseau", 1.39, new Date("2004/03/03"), 10, "Our Hearths<3"),
                    new Movie(2, "Pulp Fiction", "Crime", "Quentin Tarantino", "Quentin Tarantino", "Quentin Tarantino", "John Travolta, Uma Thurman, Samuel L. Jackson", 2.34, new Date("1994/10/14"), 10, "Oscar"),
                    new Movie(3, "The Dark Knight", "Crime", "Warner Bothers", "Christopher Nolan", "Jonathan Nolan", "Christian Bale, Heath Ledger(RIP), Aaron Eckhart", 2.32, new Date("2008/07/18"), 10, "Oscar")
            ));

    public List<Movie> getMovieList() {
        return movieList;
    }
    public Optional<Movie> getMovieById(Integer id) {
        return movieList.stream().filter(movie -> movie.getId() == id).findFirst();
    }
    public Optional<Movie> getMovieByName(String name) {
        return movieList.stream().filter(movie -> movie.getName() == name).findFirst();
    }
    public Optional<Movie> getMovieByGenre(String genre) {
        return movieList.stream().filter(movie -> movie.getGenre() == genre).findFirst();
    }
    public Optional<Movie> getMovieByOwner(String owner) {
        return movieList.stream().filter(movie -> movie.getOwner() == owner).findFirst();
    }
    public Optional<Movie> getMovieByDirector(String director) {
        return movieList.stream().filter(movie -> movie.getDirector() == director).findFirst();
    }
    public Optional<Movie> getMovieByWriter(String writer) {
        return movieList.stream().filter(movie -> movie.getWriter() == writer).findFirst();
    }
    public Optional<Movie> getMovieByActors(String actors) {
        return movieList.stream().filter(movie -> movie.getActors() == actors).findFirst();
    }
    public Optional<Movie> getMovieByScreenTime(double screenTime) {
        return movieList.stream().filter(movie -> movie.getScreenTime() == screenTime).findFirst();
    }
    public Optional<Movie> getMovieByReleaseDate(Date ReleaseDate) {
        return movieList.stream().filter(movie -> movie.getReleaseDate() == ReleaseDate).findFirst();
    }
    public Optional<Movie> getMovieByScore(double score) {
        return movieList.stream().filter(movie -> movie.getScore() == score).findFirst();
    }
    public Optional<Movie> getMovieByAwards(String awards) {
        return movieList.stream().filter(movie -> movie.getAwards() == awards).findFirst();
    }
    public Movie saveMovie(Movie movie) {
        movieList.add(movie);
        return movie;
    }
    public Movie updateMovie(Integer id, Movie test) {
        int realId = id - 1;
        movieList.set(realId, test);
        return test;
    }
    public void deleteMovie(Integer id) {
        movieList.removeIf(it -> it.getId() == id);
    }
}
