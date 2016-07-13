package com.crpr.androidcinema.data.api.services;

import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.responses.ApiResponse;
import com.crpr.androidcinema.domain.discover.Discover;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by claudioribeiro on 11/07/16.
 */
public class ApiDiscoverService implements Discover.Service {

    public interface ServiceClient {
        @GET("discover/movie")
        Observable<ApiResponse<ApiMovie>> discoverMovies();
    }

    private final ServiceClient _client;

    public ApiDiscoverService(ServiceClient client){
        this._client = client;
    }

    @Override
    public Observable<ApiResponse<ApiMovie>> discoverMovies() {
        return _client.discoverMovies();
    }
}
