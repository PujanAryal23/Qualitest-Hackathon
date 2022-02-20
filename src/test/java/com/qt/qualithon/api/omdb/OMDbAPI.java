package com.qt.qualithon.api.omdb;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;

import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONObject;

import com.qt.qualithon.model.Movie;

/**
 * OMDb API Rest Client to get movie metadata. 
 * The data is represented as com.qt.qualithon.model.Movie model
 **/
public class OMDbAPI {

    /**
     * get movie metadata from OMDb 
     *
     * @param   movieTitle    exact movie name
     * @return    Movie object representing metadata
     **/
    public Movie getMovie(String movieTitle) throws UnsupportedEncodingException {
        //call OMDb movie api
        HttpResponse<JsonNode> response = Unirest
            .get("https://www.omdbapi.com/?apikey=b569cb4e&t="
                + URLEncoder.encode(movieTitle, StandardCharsets.UTF_8.toString()))
            .asJson();
        JSONObject movieMetadata = response.getBody().getObject();

        // init Movie model
        Movie movie = new Movie();
        movie.setTitle(movieMetadata.getString("Title"));
        movie.setReleaseYear(movieMetadata.getString("Year"));
        movie.setMaturityRating(movieMetadata.getString("Rated"));
        movie.setMovieRating(movieMetadata.getString("imdbRating"));
        movie.setMovieRatingRT(movieMetadata.getJSONArray("Ratings").getJSONObject(1).getString("Value"));
        movie.setDirector(movieMetadata.getString("Director"));
        movie.setGenres(movieMetadata.getString("Genre"));
        movie.setWriters(movieMetadata.getString("Writer"));
        return  movie;
    }

}
