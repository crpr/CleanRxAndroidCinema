package com.crpr.androidcinema.domain.discover;

import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.responses.ApiResponse;

import rx.Observable;

/**
 * Created by claudioribeiro on 12/07/16.
 */
public interface Discover {

    interface Process {

    }

    interface Service {
        Observable<ApiResponse<ApiMovie>> discoverMovies();
    }
}
