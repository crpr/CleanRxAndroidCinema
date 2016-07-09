package com.crpr.androidcinema.domain.splash;

import android.util.Log;

import com.crpr.androidcinema.domain.common.Interactor;
import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class SplashInteractor extends Interactor implements Splash.Interactor {

    private final GetConfiguration.Process _process;

    public SplashInteractor(Scheduler mainThread, Scheduler executorThread,
                            GetConfiguration.Process process) {
        super(mainThread, executorThread);
        this._process = process;
    }

    public Observable<Result> getConfiguration(){
        return _process.getConfiguration()
                .observeOn(_mainThread)
                .subscribeOn(_executorThread)
                .doOnError(throwable -> Log.e("INTERACTOR ERROR", "DO SOMETHING IN THIS LAYER"));
    }

}
