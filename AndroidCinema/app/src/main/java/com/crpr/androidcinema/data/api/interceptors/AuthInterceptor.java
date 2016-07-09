package com.crpr.androidcinema.data.api.interceptors;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class AuthInterceptor implements Interceptor {

    private final String api_key;

    public AuthInterceptor(String apiKey){
        this.api_key = apiKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key",this.api_key)
                        .build();

        request = request.newBuilder().url(url).build();

        return chain.proceed(request);
    }
}
