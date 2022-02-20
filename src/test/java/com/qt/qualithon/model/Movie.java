package com.qt.qualithon.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Movie model represents the metadata of any movie
 *
 **/
public class Movie{

    String title;
    String releaseYear;
    String director;
    String maturityRating;
    String movieRating;
    List<String> genres;
    List<String> writers;

    public Movie(){
        this.genres = new ArrayList<>();
        this.writers = new ArrayList<>();
    }

    /**
     * set movie title
     *
     * @param   title   movie title
     **/
    public void setTitle(String title){
        this.title = title;
    }
    /**
     * get movie title
     *
     * @return   movie title
     **/
    public String title(){
        return this.title;
    }

    /**
     * set movie release year
     *
     * @param   releaseYear   movie release year
     **/
    public void setReleaseYear(String releaseYear){
        this.releaseYear = releaseYear;
    }
    /**
     * get movie release year
     *
     * @return    movie release year
     **/
    public String releaseYear(){
        return this.releaseYear;
    }

    /**
     * set maturityRating
     *
     * @param   maturityRating   movie maturity rating
     **/
    public void setMaturityRating(String maturityRating){
        this.maturityRating = maturityRating;
    }
    /**
     * get movie maturity rating
     *
     * @return    movie maturity rating
     **/
    public String maturityRating(){
        return this.maturityRating;
    }

    /**
     * set movie rating
     *
     * @param   movieRating   movie rating
     **/
    public void setMovieRating(String movieRating){
        this.movieRating = movieRating;
    }
    /**
     * get movie rating
     *
     * @return    movie rating
     **/
    public String movieRating(){
        return this.movieRating;
    }

    /**
     * set movie rating Rotten Tomato
     *
     * @param   movieRating   movie rating Rotten Tomato
     **/
    public void setMovieRatingRT(String movieRating){
        this.movieRating = movieRating;
    }
    /**
     * get movie rating Rotten Tomato
     *
     * @return    movie rating Rotten Tomato
     **/
    public String movieRatingRT(){
        return this.movieRating;
    }


    /**
     * set movie director name
     *
     * @param   director    movie director name
     **/
    public void setDirector(String director){
        this.director = director;
    }
    /**
     * get movie director name
     *
     * @return    movie director name as string
     **/
    public String director(){
        return this.director;
    }

    /**
     * set movie genre list
     *
     * @param   genres    list of movie genres
     **/
    public void setGenres(List<String> genres){
        this.genres = genres;
    }
    /**
     * set movie genre list using comma seperated genre string
     *
     * @param   commaSeperatedGenres    string of comma seperated movie genres
     **/
    public void setGenres(String commaSeperatedGenres){
        for(String genre:commaSeperatedGenres.split(",")){
            this.genres.add(genre.trim());
        }
    }
    /**
     * add movie genre to movie geres list
     *
     * @param   genre   movie genre
     **/
    public void addGenre(String genre){
        this.genres.add(genre);
    }
    /**
     * return a list of movie genres
     *
     * @return    a list of movie genres
     **/
    public List<String> genres(){
        return this.genres;
    }

    /**
     * set a list of movie writers
     *
     * @param   writers   a list of movie writer name strings
     **/
    public void setWriters(List<String> writers){
        this.writers = writers;
    }
    /**
     * set a list of movie writers using comma seperated writer names
     *
     * @param   commaSeperatedWriters   a comma seperated string of movie writer names
     **/
    public void setWriters(String commaSeperatedWriters){
        for(String writer:commaSeperatedWriters.split(",")){
            this.writers.add(writer.trim());
        }
    }
    /**
     * add a movie writer to movie writers list
     *
     * @param   writer    movie writer name string
     **/
    public void addWriter(String writer){
        this.writers.add(writer);
    }
    /**
     * get a list of movie writers
     *
     * @return    list of movie writer names
     **/
    public List<String> writers(){
        return this.writers;
    }

    /**
     * a pretty formated representation of movie metadata
     *
     * @return    pretty formated movie metadata
     **/
    public String toString(){
      return "Title: " + this.title + " (" + this.releaseYear + ")" + "\n"
            +"Director: " + this.director + "\n"
            +"Genres: " + String.join(",", this.genres) + "\n" 
            +"Writers: " + String.join(",", this.writers); 
    }
}
