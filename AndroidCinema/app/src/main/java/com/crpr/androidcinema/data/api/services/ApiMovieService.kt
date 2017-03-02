package com.crpr.androidcinema.data.api.services

import com.crpr.androidcinema.data.api.models.ApiMovie

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by claudioribeiro on 31/01/2017.
 */
class ApiMovieService(private val _client: ApiMovieService.ServiceClient) {

    interface ServiceClient {
        @GET("movie/{movie_id}")
        fun getMovieDetailsById(@Query("movie_id") movieId: Int): Observable<ApiMovie>
    }

    fun getMovieDetailsById(token: Int): Observable<ApiMovie> {
        return _client.getMovieDetailsById(token)
    }

}
