package com.crpr.androidcinema.data.api.factories;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by cribeiro on 08/01/2016.
 */
public class OkHttpClientFactory {

    public static final int CONFIG_CLIENT = 1;

    private final InterceptorsFactory _factory;

    public OkHttpClientFactory(InterceptorsFactory factory){
        _factory = factory;
    }

    public OkHttpClient getClient(int type){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);

        switch (type){
            case CONFIG_CLIENT:
                builder.addNetworkInterceptor(_factory.get(InterceptorsFactory.LOG));
                builder.addNetworkInterceptor(_factory.get(InterceptorsFactory.AUTH));
                builder.addInterceptor(_factory.get(InterceptorsFactory.HTTP));
                break;

            default:
                builder.addNetworkInterceptor(_factory.get(InterceptorsFactory.LOG));
                builder.addInterceptor(_factory.get(InterceptorsFactory.HTTP));
                break;
        }

        return builder.build();
    }
}
