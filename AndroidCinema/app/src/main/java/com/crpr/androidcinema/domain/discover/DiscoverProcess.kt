package com.crpr.androidcinema.domain.discover

import com.crpr.androidcinema.data.api.models.ApiMovie
import com.crpr.androidcinema.data.api.responses.ApiResponse
import com.crpr.androidcinema.domain.common.Result
import com.crpr.androidcinema.domain.common.viewmodels.converters.ApiListMovieConverter

import rx.Observable

/**
 * Created by claudioribeiro on 12/07/16.
 */
class DiscoverProcess(private val _service: Discover.Service, private val _converter: ApiListMovieConverter) : Discover.Process {

    override fun discoverMovies(): Observable<DiscoverMovieListResult> {
        return _service.discoverMovies()
                .flatMap<DiscoverMovieListResult>({ this.processResponse(it) })
    }

    private fun processResponse(response: ApiResponse<ApiMovie>): Observable<DiscoverMovieListResult> {
        return Observable.just(convert(response))
    }

    private fun convert(response: ApiResponse<ApiMovie>): DiscoverMovieListResult {
        return DiscoverMovieListResult(Result.OK,
                response.results?.mapNotNull { _converter.mapTo(it) })
    }

}
