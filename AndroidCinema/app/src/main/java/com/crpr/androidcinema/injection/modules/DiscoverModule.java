package com.crpr.androidcinema.injection.modules;

import com.crpr.androidcinema.data.api.factories.ApiServiceFactory;
import com.crpr.androidcinema.data.api.services.ApiDiscoverService;
import com.crpr.androidcinema.domain.discover.Discover;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by claudioribeiro on 12/07/16.
 */
@Module
public class DiscoverModule {

    /************************* SERVICE *******************************/
    @Provides
    @Singleton
    Discover.Service provideApiDiscoverService(ApiServiceFactory factory){
        return new ApiDiscoverService(factory.getServiceClient(ApiDiscoverService.ServiceClient.class));
    }

}
