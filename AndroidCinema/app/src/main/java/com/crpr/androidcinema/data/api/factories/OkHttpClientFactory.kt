package com.crpr.androidcinema.data.api.factories

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by cribeiro on 08/01/2016.
 */
class OkHttpClientFactory(private val _factory: InterceptorsFactory) {

    fun getClient(type: Int): OkHttpClient {
        val builder = OkHttpClient().newBuilder()

        builder.connectTimeout(30, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)

        when (type) {
            STANDARD_CLIENT -> {
                builder.addNetworkInterceptor(_factory[InterceptorsFactory.LOG])
                builder.addNetworkInterceptor(_factory[InterceptorsFactory.AUTH])
                builder.addInterceptor(_factory[InterceptorsFactory.HTTP])
            }

            else -> {
                builder.addNetworkInterceptor(_factory[InterceptorsFactory.LOG])
                builder.addInterceptor(_factory[InterceptorsFactory.HTTP])
            }
        }

        return builder.build()
    }

    companion object {

        val STANDARD_CLIENT = 1
    }
}
