package com.crpr.androidcinema.injection.modules;

import com.crpr.androidcinema.data.api.factories.ApiServiceFactory;
import com.crpr.androidcinema.data.api.services.ApiConfigurationService;
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration;
import com.crpr.androidcinema.domain.splash.Splash;
import com.crpr.androidcinema.domain.splash.SplashInteractor;
import com.crpr.androidcinema.domain.common.configuration.GetConfigurationProcess;
import com.crpr.androidcinema.presentation.splash.SplashPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;

/**
 * Created by claudioribeiro on 09/07/16.
 */
@Module
public class ConfigurationModule {

    /************************* PROCESS *******************************/
    @Provides
    GetConfiguration.Process provideGetConfigurationProcess(GetConfiguration.Service service){
        return new GetConfigurationProcess(service);
    }

    /************************* SERVICE *******************************/
    @Provides
    GetConfiguration.Service provideApiConfigurationService(ApiServiceFactory factory){
        return new ApiConfigurationService(factory.getServiceClient(ApiConfigurationService.ServiceClient.class));
    }

}
