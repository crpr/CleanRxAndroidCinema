package com.crpr.androidcinema.domain.common.configuration

import com.crpr.androidcinema.data.api.models.ApiConfiguration
import com.crpr.androidcinema.domain.common.Result

import rx.Observable

/**
 * Created by claudioribeiro on 09/07/16.
 */
interface GetConfiguration {

    interface Process {
        val configuration: Observable<Result>
    }

    interface Service {
        val configuration: Observable<ApiConfiguration>
    }
}
