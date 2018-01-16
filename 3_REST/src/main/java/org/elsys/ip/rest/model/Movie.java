package org.elsys.ip.rest.model;

import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable{
    private int id;
    private String name;
    private String genre;
    private String owner;
    private String director;
    private String writer;
    private String actors;
    private double screenTime;
    private Date releaseDate;
    private double score;
    private String awards;

    public Movie() {}
    public Movie(Movie movie){
        this.id = movie.getId();
        this.name = movie.getName();
        this.genre = movie.getGenre();
        this.owner = movie.getOwner();
        this.director = movie.getDirector();
        this.writer = movie.getWriter();
        this.actors = movie.getActors();
        this.screenTime = movie.getScreenTime();
        this.releaseDate = movie.getReleaseDate();
        this.score = movie.getScore();
        this.awards = movie.getAwards();
    }
    public Movie(int id, String name, String genre, String owner, String director, String writer, String actors, double screenTime, Date releaseDate, double score, String awards) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.owner = owner;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.screenTime = screenTime;
        this.releaseDate = releaseDate;
        this.score = score;
        this.awards = awards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public double getScreenTime() {
        return screenTime;
    }

    public void setScreenTime(double screenTime) {
        this.screenTime = screenTime;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }
}
