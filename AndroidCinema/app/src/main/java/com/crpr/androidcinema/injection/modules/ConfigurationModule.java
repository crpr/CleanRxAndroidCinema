package com.crpr.androidcinema.injection.modules;

import com.crpr.androidcinema.data.api.factories.ApiServiceFactory;
import com.crpr.androidcinema.data.api.services.ApiConfigurationService;
import com.crpr.androidcinema.domain.get_configuration.GetConfigurationInteractor;
import com.crpr.androidcinema.domain.get_configuration.GetConfigurationProcess;
import com.crpr.androidcinema.presentation.get_configuration.GetConfigurationPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;

/**
 * Created by claudioribeiro on 09/07/16.
 */
@Module
public class ConfigurationModule {

    /************************* PRESENTER *******************************/
    @Provides
    GetConfigurationPresenter provideGetConfigurationPresenter(GetConfigurationInteractor interactor){
        return new GetConfigurationPresenter(interactor);
    }

    /************************* INTERACTOR *******************************/
    @Provides
    GetConfigurationInteractor provideGetConfigurationInteractor(@Named("marvel_main_thread") Scheduler mainThread,
                                                                 @Named("marvel_executor_thread") Scheduler executorThread,
                                                                 GetConfigurationProcess process){
        return new GetConfigurationInteractor(mainThread, executorThread, process);
    }

    /************************* PROCESS *******************************/
    @Provides
    GetConfigurationProcess provideGetConfigurationProcess(ApiConfigurationService service){
        return new GetConfigurationProcess(service);
    }

    /************************* SERVICE *******************************/
    @Provides
    ApiConfigurationService provideApiConfigurationService(ApiServiceFactory factory){
        return new ApiConfigurationService(factory.getServiceClient(ApiConfigurationService.ServiceClient.class));
    }

}
