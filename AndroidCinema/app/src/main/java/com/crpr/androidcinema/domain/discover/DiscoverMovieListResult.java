package com.crpr.androidcinema.domain.discover;

import com.crpr.androidcinema.domain.common.Result;

import java.util.List;

/**
 * Created by claudioribeiro on 14/07/16.
 */
public class DiscoverMovieListResult extends Result {

    private List<ListMovieModel> _models;

    public DiscoverMovieListResult(int statusCode){
        super(statusCode);
    }

    public DiscoverMovieListResult(int statusCode, String message) {
        super(statusCode, message);
    }

    public DiscoverMovieListResult(int statusCode, List<ListMovieModel> models) {
        super(statusCode);
        this._models = models;
    }

    public List<ListMovieModel> getMovies(){
        return _models;
    }
}
