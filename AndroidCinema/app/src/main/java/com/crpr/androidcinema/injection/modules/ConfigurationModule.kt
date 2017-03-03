package com.crpr.androidcinema.injection.modules

import com.crpr.androidcinema.data.api.factories.ApiServiceFactory
import com.crpr.androidcinema.data.api.services.ApiConfigurationService
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration
import com.crpr.androidcinema.domain.common.configuration.GetConfigurationProcess
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by claudioribeiro on 09/07/16.
 */
@Module
class ConfigurationModule {

    /************************* PROCESS  */
    @Provides
    internal fun provideGetConfigurationProcess(service: GetConfiguration.Service): GetConfiguration.Process {
        return GetConfigurationProcess(service)
    }

    /************************* SERVICE  */
    @Provides
    @Singleton
    internal fun provideApiConfigurationService(factory: ApiServiceFactory): GetConfiguration.Service {
        return ApiConfigurationService(factory.getServiceClient(ApiConfigurationService.ServiceClient::class.java))
    }

}
