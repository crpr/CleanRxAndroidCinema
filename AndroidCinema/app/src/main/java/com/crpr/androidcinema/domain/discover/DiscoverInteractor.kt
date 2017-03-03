package com.crpr.androidcinema.domain.discover

import android.util.Log

import com.crpr.androidcinema.domain.common.Interactor

import rx.Observable
import rx.Scheduler

/**
 * Created by claudioribeiro on 14/07/16.
 */
class DiscoverInteractor(mainThread: Scheduler, executorThread: Scheduler,
                         private val _process: Discover.Process) : Interactor(mainThread, executorThread), Discover.Interactor {

    override fun discoverMovies(): Observable<DiscoverMovieListResult> {
        return _process.discoverMovies()
                .observeOn(_mainThread)
                .subscribeOn(_executorThread)
                .doOnError { throwable -> Log.e("INTERACTOR ERROR", "DO SOMETHING IN THIS LAYER") }

    }
}
