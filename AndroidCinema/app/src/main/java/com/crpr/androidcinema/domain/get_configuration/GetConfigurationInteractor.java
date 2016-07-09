package com.crpr.androidcinema.domain.get_configuration;

import android.util.Log;

import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;
import com.crpr.androidcinema.domain.common.Interactor;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class GetConfigurationInteractor extends Interactor implements GetConfiguration.Interactor {

    private final GetConfiguration.Process _process;

    public GetConfigurationInteractor(Scheduler mainThread, Scheduler executorThread,
                                      GetConfiguration.Process process) {
        super(mainThread, executorThread);
        this._process = process;
    }

    public Observable<ApiConfiguration> getConfiguration(){
        return _process.getConfiguration()
                .observeOn(_mainThread)
                .subscribeOn(_executorThread)
                .doOnError(throwable -> {
                    Log.e("INTERACTOR ERROR", "DO SOMETHING IN THIS LAYER");
                });
    }

}
