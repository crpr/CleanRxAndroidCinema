package com.crpr.androidcinema.injection.modules;

import com.crpr.androidcinema.common.properties.PropertiesLoader;
import com.crpr.androidcinema.data.api.factories.ApiServiceFactory;
import com.crpr.androidcinema.data.api.factories.InterceptorsFactory;
import com.crpr.androidcinema.data.api.factories.OkHttpClientFactory;
import com.crpr.androidcinema.data.api.interceptors.AuthInterceptor;
import com.crpr.androidcinema.data.api.interceptors.LogInterceptor;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by claudioribeiro on 09/07/16.
 */
@Module
public class ApiModule {

    /***************** INTERCEPTORS *******************************/

    @Provides
    AuthInterceptor provideAuthInterceptor(PropertiesLoader propertiesLoader){
        return new AuthInterceptor(propertiesLoader.getProperty(PropertiesLoader.API_KEY));
    }

    @Provides
    LogInterceptor provideLogInterceptor(){
        return new LogInterceptor();
    }

    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor();
    }

    /****************** FACTORIES ******************************/

    @Provides
    @Singleton
    OkHttpClientFactory provideOkHttpClientFactory(InterceptorsFactory factory){
        return new OkHttpClientFactory(factory);
    }

    @Provides
    @Singleton
    InterceptorsFactory provideInterceptorsFactory(Provider<LogInterceptor> logProvider,
                                                   Provider<AuthInterceptor> authProvider,
                                                   Provider<HttpLoggingInterceptor> httpProvider){
        return new InterceptorsFactory(logProvider, authProvider, httpProvider);
    }

    @Provides
    @Singleton
    ApiServiceFactory provideApiServiceFactory(OkHttpClientFactory factory, PropertiesLoader properties){
        return new ApiServiceFactory(factory.getClient(OkHttpClientFactory.STANDARD_CLIENT),
                properties.getProperty(PropertiesLoader.API_BASE_URL));
    }
}
