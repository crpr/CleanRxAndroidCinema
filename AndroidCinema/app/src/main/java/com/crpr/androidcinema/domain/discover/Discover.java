package com.crpr.androidcinema.domain.discover;

import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.responses.ApiResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by claudioribeiro on 12/07/16.
 */
public interface Discover {

    interface Interactor {
        Observable<DiscoverMovieListResult> discoverMovies();
    }

    interface Process {
        Observable<DiscoverMovieListResult> discoverMovies();
    }

    interface Service {
        Observable<ApiResponse<ApiMovie>> discoverMovies();
    }
}
