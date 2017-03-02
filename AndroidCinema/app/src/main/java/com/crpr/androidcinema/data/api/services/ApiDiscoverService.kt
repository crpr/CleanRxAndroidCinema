package com.crpr.androidcinema.data.api.services

import com.crpr.androidcinema.data.api.models.ApiMovie
import com.crpr.androidcinema.data.api.responses.ApiResponse
import com.crpr.androidcinema.domain.discover.Discover

import retrofit2.http.GET
import rx.Observable

/**
 * Created by claudioribeiro on 11/07/16.
 */
class ApiDiscoverService(private val _client: ApiDiscoverService.ServiceClient) : Discover.Service {

    interface ServiceClient {
        @GET("discover/movie")
        fun discoverMovies(): Observable<ApiResponse<ApiMovie>>
    }

    override fun discoverMovies(): Observable<ApiResponse<ApiMovie>> {
        return _client.discoverMovies()
    }
}
