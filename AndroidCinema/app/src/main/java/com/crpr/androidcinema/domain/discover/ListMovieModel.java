package com.crpr.androidcinema.domain.discover;

import java.io.Serializable;

/**
 * Created by claudioribeiro on 12/07/16.
 */
public class ListMovieModel implements Serializable {

    private int id;
    private String poster_path;
    private double popularity;
    private String title;
    private double vote_average;
    private int vote_count;

    private ListMovieModel(){}



}
