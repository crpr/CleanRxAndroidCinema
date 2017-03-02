package com.crpr.androidcinema.data.api.services

import com.crpr.androidcinema.data.api.models.ApiConfiguration
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration

import retrofit2.http.GET
import rx.Observable

/**
 * Created by claudioribeiro on 08/07/16.
 */
class ApiConfigurationService(private val _client: ApiConfigurationService.ServiceClient) : GetConfiguration.Service {

    interface ServiceClient {
        @get:GET("configuration")
        val configuration: Observable<ApiConfiguration>
    }

    override val configuration: Observable<ApiConfiguration>
        get() = _client.configuration

}
