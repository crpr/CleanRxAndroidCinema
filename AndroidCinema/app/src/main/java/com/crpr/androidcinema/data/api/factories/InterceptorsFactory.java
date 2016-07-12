package com.crpr.androidcinema.data.api.factories;

import com.crpr.androidcinema.BuildConfig;
import com.crpr.androidcinema.data.api.interceptors.AuthInterceptor;
import com.crpr.androidcinema.data.api.interceptors.LogInterceptor;

import javax.inject.Provider;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by cribeiro on 08/01/2016.
 */
public class InterceptorsFactory {

    public static final int LOG = 0;
    public static final int AUTH = 1;
    public static final int HTTP = 2;

    Provider<LogInterceptor> _logProvider;
    Provider<AuthInterceptor> _authProvider;
    Provider<HttpLoggingInterceptor> _httpInterceptor;

    public InterceptorsFactory(Provider<LogInterceptor> logProvider, Provider<AuthInterceptor> authProvider,
                               Provider<HttpLoggingInterceptor> httpProvider){
        this._logProvider = logProvider;
        this._authProvider = authProvider;
        this._httpInterceptor = httpProvider;
    }

    public Interceptor get(int type){
        switch (type){
            case LOG:
                return _logProvider.get();

            case AUTH:
                return _authProvider.get();

            case HTTP:
                HttpLoggingInterceptor interceptor = _httpInterceptor.get();
                interceptor.setLevel(BuildConfig.DEBUG ?
                        HttpLoggingInterceptor.Level.BODY :
                        HttpLoggingInterceptor.Level.BASIC);
                return interceptor;

            default:
                return null;
        }
    }
}
