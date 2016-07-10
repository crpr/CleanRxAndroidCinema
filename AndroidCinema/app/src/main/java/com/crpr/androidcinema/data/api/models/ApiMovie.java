package com.crpr.androidcinema.data.api.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by claudioribeiro on 11/07/16.
 */
public class ApiMovie implements Serializable {

    private boolean adult;
    private String backdrop_path;
    private List<Integer> genre_ids;
    private int id;
    private String original_language;
    private String original_title;
    private String overview;
    private String release_date;
    private String poster_path;
    private double popularity;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;

    public ApiMovie(){}

    public boolean isAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdrop_path;
    }

    public List<Integer> getGenreIds() {
        return genre_ids;
    }

    public int getId() {
        return id;
    }

    public String getOriginalLanguage() {
        return original_language;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasVideo() {
        return video;
    }
}
