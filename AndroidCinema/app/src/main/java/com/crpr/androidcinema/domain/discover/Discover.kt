package com.crpr.androidcinema.domain.discover

import com.crpr.androidcinema.data.api.models.ApiMovie
import com.crpr.androidcinema.data.api.responses.ApiResponse
import com.crpr.androidcinema.presentation.common.Base

import rx.Observable

/**
 * Created by claudioribeiro on 12/07/16.
 */
interface Discover {

    interface View : Base.View {
        fun showMovieList(models: List<ListMovieModel>)
        fun showEmptyView()
    }

    interface Presenter : Base.Presenter {
        fun discoverMovies()
        fun onReceiveResult(result: DiscoverMovieListResult)
    }

    interface Interactor {
        fun discoverMovies(): Observable<DiscoverMovieListResult>
    }

    interface Process {
        fun discoverMovies(): Observable<DiscoverMovieListResult>
    }

    interface Service {
        fun discoverMovies(): Observable<ApiResponse<ApiMovie>>
    }
}
