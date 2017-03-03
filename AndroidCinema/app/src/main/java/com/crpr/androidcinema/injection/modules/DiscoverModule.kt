package com.crpr.androidcinema.injection.modules

import com.crpr.androidcinema.data.api.factories.ApiServiceFactory
import com.crpr.androidcinema.data.api.services.ApiDiscoverService
import com.crpr.androidcinema.domain.common.viewmodels.converters.ApiListMovieConverter
import com.crpr.androidcinema.domain.discover.Discover
import com.crpr.androidcinema.domain.discover.DiscoverInteractor
import com.crpr.androidcinema.domain.discover.DiscoverProcess
import com.crpr.androidcinema.presentation.discover.DiscoverPresenter
import dagger.Module
import dagger.Provides
import rx.Scheduler
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by claudioribeiro on 12/07/16.
 */
@Module
class DiscoverModule {

    /************************* PRESENTER  */
    @Provides
    internal fun provideDiscoverPresenter(interactor: Discover.Interactor): Discover.Presenter {
        return DiscoverPresenter(interactor)
    }

    /************************* PROCESS  */
    @Provides
    internal fun provideDiscoverInteractor(@Named("cinema_main_thread") mainThread: Scheduler,
                                           @Named("cinema_executor_thread") executorThread: Scheduler,
                                           process: Discover.Process): Discover.Interactor {
        return DiscoverInteractor(mainThread, executorThread, process)
    }

    /************************* PROCESS  */
    @Provides
    internal fun provideDiscoverProcess(service: Discover.Service, converter: ApiListMovieConverter): Discover.Process {
        return DiscoverProcess(service, converter)
    }

    /************************* SERVICE  */
    @Provides
    @Singleton
    internal fun provideApiDiscoverService(factory: ApiServiceFactory): Discover.Service {
        return ApiDiscoverService(factory.getServiceClient(ApiDiscoverService.ServiceClient::class.java))
    }

    /************************* CONVERTER  */
    @Provides
    @Singleton
    internal fun provideApiListMovieConverter(): ApiListMovieConverter {
        return ApiListMovieConverter()
    }
}
