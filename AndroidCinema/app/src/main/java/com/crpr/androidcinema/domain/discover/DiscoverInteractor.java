package com.crpr.androidcinema.domain.discover;

import android.util.Log;

import com.crpr.androidcinema.domain.common.Interactor;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by claudioribeiro on 14/07/16.
 */
public class DiscoverInteractor extends Interactor implements Discover.Interactor {

    private final Discover.Process _process;

    public DiscoverInteractor(Scheduler mainThread, Scheduler executorThread,
                              Discover.Process process) {
        super(mainThread, executorThread);
        this._process = process;
    }

    @Override
    public Observable<DiscoverMovieListResult> discoverMovies() {
        return _process.discoverMovies()
                .observeOn(_mainThread)
                .subscribeOn(_executorThread)
                .doOnError(throwable -> Log.e("INTERACTOR ERROR", "DO SOMETHING IN THIS LAYER"));

    }
}
