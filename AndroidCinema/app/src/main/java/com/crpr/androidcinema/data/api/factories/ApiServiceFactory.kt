package com.crpr.androidcinema.data.api.factories

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by claudioribeiro on 09/07/16.
 */
class ApiServiceFactory(client: OkHttpClient, baseUrl: String) {

    private val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())

    fun <S> getServiceClient(serviceClass: Class<S>): S {
        return builder.build().create(serviceClass)
    }

}
