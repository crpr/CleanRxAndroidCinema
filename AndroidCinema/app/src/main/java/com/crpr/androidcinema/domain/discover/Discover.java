package com.crpr.androidcinema.domain.discover;

import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.responses.ApiResponse;
import com.crpr.androidcinema.presentation.common.Base;

import java.util.List;

import rx.Observable;

/**
 * Created by claudioribeiro on 12/07/16.
 */
public interface Discover {

    interface View extends Base.View{
        void showMovieList(List<ListMovieModel> models);
    }

    interface Presenter extends Base.Presenter{
        void discoverMovies();
        void onReceiveResult(DiscoverMovieListResult result);
    }

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
