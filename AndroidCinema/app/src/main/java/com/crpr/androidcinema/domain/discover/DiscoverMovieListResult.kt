package com.crpr.androidcinema.domain.discover

import com.crpr.androidcinema.domain.common.Result

/**
 * Created by claudioribeiro on 14/07/16.
 */
class DiscoverMovieListResult : Result {

    var movies: List<ListMovieModel>? = null

    constructor(statusCode: Int, models: List<ListMovieModel>?) : super(statusCode) {
        this.movies = models
    }

    constructor(statusCode: Int, errorMessage: String) : super(statusCode, errorMessage) {}
}
