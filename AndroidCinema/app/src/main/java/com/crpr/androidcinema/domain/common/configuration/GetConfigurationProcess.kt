package com.crpr.androidcinema.domain.common.configuration

import com.crpr.androidcinema.data.api.models.ApiConfiguration
import com.crpr.androidcinema.domain.common.Result
import com.crpr.androidcinema.domain.common.providers.ImageUrlProvider
import rx.Observable

/**
 * Created by claudioribeiro on 09/07/16.
 */
class GetConfigurationProcess(private val _service: GetConfiguration.Service) : GetConfiguration.Process {

    /**************** GET UPDATED CONFIGURATION  */
    override val configuration: Observable<Result>
        get() = _service.configuration
                .flatMap<Result>({ this.configureImageUrlProvider(it) })

    private fun configureImageUrlProvider(configuration: ApiConfiguration): Observable<Result> {

        val model = ConfigurationModel
                .url(configuration.images.base_url!!)
                .secureUrl(configuration.images.secure_base_url!!)
                .build()

        ImageUrlProvider.sharedInstance().setCurrentConfig(model)

        return Observable.just(Result(Result.OK))
    }
}
