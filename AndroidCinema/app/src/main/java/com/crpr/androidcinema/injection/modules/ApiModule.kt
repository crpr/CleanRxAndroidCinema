package com.crpr.androidcinema.injection.modules

import com.crpr.androidcinema.common.properties.PropertiesLoader
import com.crpr.androidcinema.data.api.factories.ApiServiceFactory
import com.crpr.androidcinema.data.api.factories.InterceptorsFactory
import com.crpr.androidcinema.data.api.factories.OkHttpClientFactory
import com.crpr.androidcinema.data.api.interceptors.AuthInterceptor
import com.crpr.androidcinema.data.api.interceptors.LogInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by claudioribeiro on 09/07/16.
 */
@Module
class ApiModule {

    /***************** INTERCEPTORS  */

    @Provides
    internal fun provideAuthInterceptor(propertiesLoader: PropertiesLoader): AuthInterceptor {
        return AuthInterceptor(propertiesLoader.getProperty(PropertiesLoader.API_KEY))
    }

    @Provides
    internal fun provideLogInterceptor(): LogInterceptor {
        return LogInterceptor()
    }

    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    /****************** FACTORIES  */

    @Provides
    @Singleton
    internal fun provideOkHttpClientFactory(factory: InterceptorsFactory): OkHttpClientFactory {
        return OkHttpClientFactory(factory)
    }

    @Provides
    @Singleton
    internal fun provideInterceptorsFactory(logProvider: Provider<LogInterceptor>,
                                            authProvider: Provider<AuthInterceptor>,
                                            httpProvider: Provider<HttpLoggingInterceptor>): InterceptorsFactory {
        return InterceptorsFactory(logProvider, authProvider, httpProvider)
    }

    @Provides
    @Singleton
    internal fun provideApiServiceFactory(factory: OkHttpClientFactory, properties: PropertiesLoader): ApiServiceFactory {
        return ApiServiceFactory(factory.getClient(OkHttpClientFactory.STANDARD_CLIENT),
                properties.getProperty(PropertiesLoader.API_BASE_URL))
    }
}
