package com.crpr.androidcinema.data.api.factories;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class ApiServiceFactory {

    private Retrofit.Builder builder;

    public ApiServiceFactory(OkHttpClient client, String baseUrl){
        this.builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }

    public <S> S getServiceClient(Class<S> serviceClass) {
        return builder.build().create(serviceClass);
    }

}
