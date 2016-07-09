package com.crpr.androidcinema.data.api.factories;

import android.content.Context;

import com.crpr.androidcinema.CinemaApp;
import com.crpr.androidcinema.data.api.interceptors.AuthInterceptor;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.Interceptor;

/**
 * Created by cribeiro on 08/01/2016.
 */
public class InterceptorsFactory {

    public static final int AUTH = 1;

    @Inject
    Provider<AuthInterceptor> _authProvider;

    public InterceptorsFactory(Context context){
        ((CinemaApp)context.getApplicationContext()).component().inject(this);
    }

    public Interceptor get(int type){
        switch (type){
            case AUTH:
                return _authProvider.get();

            default:
                return null;
        }
    }
}
