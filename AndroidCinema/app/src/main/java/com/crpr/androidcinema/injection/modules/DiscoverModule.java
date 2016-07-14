package com.crpr.androidcinema.injection.modules;

import com.crpr.androidcinema.data.api.factories.ApiServiceFactory;
import com.crpr.androidcinema.data.api.services.ApiDiscoverService;
import com.crpr.androidcinema.domain.common.viewmodels.converters.ApiListMovieConverter;
import com.crpr.androidcinema.domain.discover.Discover;
import com.crpr.androidcinema.domain.discover.DiscoverInteractor;
import com.crpr.androidcinema.domain.discover.DiscoverProcess;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;

/**
 * Created by claudioribeiro on 12/07/16.
 */
@Module
public class DiscoverModule {

    /************************* PROCESS *******************************/
    @Provides
    Discover.Interactor provideDiscoverInteractor(@Named("marvel_main_thread") Scheduler mainThread,
                                                  @Named("marvel_executor_thread") Scheduler executorThread,
                                                  Discover.Process process){
        return new DiscoverInteractor(mainThread, executorThread, process);
    }

    /************************* PROCESS *******************************/
    @Provides
    Discover.Process provideDiscoverProcess(Discover.Service service, ApiListMovieConverter converter){
        return new DiscoverProcess(service, converter);
    }

    /************************* SERVICE *******************************/
    @Provides
    @Singleton
    Discover.Service provideApiDiscoverService(ApiServiceFactory factory){
        return new ApiDiscoverService(factory.getServiceClient(ApiDiscoverService.ServiceClient.class));
    }

    /************************* CONVERTER *******************************/
    @Provides
    @Singleton
    ApiListMovieConverter provideApiListMovieConverter(){
        return new ApiListMovieConverter();
    }
}
