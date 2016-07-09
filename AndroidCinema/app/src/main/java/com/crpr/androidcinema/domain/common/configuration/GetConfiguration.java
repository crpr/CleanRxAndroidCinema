package com.crpr.androidcinema.domain.common.configuration;

import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;
import com.crpr.androidcinema.domain.common.Result;

import rx.Observable;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface GetConfiguration {

    interface Process {
        Observable<Result> getConfiguration();
    }

    interface Service {
        Observable<ApiConfiguration> getConfiguration();
    }
}
