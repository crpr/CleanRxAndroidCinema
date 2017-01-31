package com.crpr.androidcinema.data.api.services;

import com.crpr.androidcinema.data.api.models.ApiMovie;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by claudioribeiro on 31/01/2017.
 */
public class ApiMovieService {

    public interface ServiceClient {
        @GET("movie/{movie_id}")
        Observable<ApiMovie> getMovieDetailsById(@Query("movie_id") int movieId);
    }

    private final ApiMovieService.ServiceClient _client;

    public ApiMovieService(ApiMovieService.ServiceClient client){
        this._client = client;
    }

    public Observable<ApiMovie> getMovieDetailsById(int token) {
        return _client.getMovieDetailsById(token);
    }

}
