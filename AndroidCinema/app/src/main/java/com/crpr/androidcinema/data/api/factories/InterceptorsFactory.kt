package com.crpr.androidcinema.data.api.factories

import com.crpr.androidcinema.BuildConfig
import com.crpr.androidcinema.data.api.interceptors.AuthInterceptor
import com.crpr.androidcinema.data.api.interceptors.LogInterceptor
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Provider

/**
 * Created by cribeiro on 08/01/2016.
 */
class InterceptorsFactory(internal var _logProvider: Provider<LogInterceptor>,
                          internal var _authProvider: Provider<AuthInterceptor>,
                          internal var _httpInterceptor: Provider<HttpLoggingInterceptor>) {

    operator fun get(type: Int): Interceptor? {
        when (type) {
            LOG -> return _logProvider.get()

            AUTH -> return _authProvider.get()

            HTTP -> {
                val interceptor = _httpInterceptor.get()
                interceptor.level = if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.BASIC
                return interceptor
            }

            else -> return null
        }
    }

    companion object {

        val LOG = 0
        val AUTH = 1
        val HTTP = 2
    }
}
