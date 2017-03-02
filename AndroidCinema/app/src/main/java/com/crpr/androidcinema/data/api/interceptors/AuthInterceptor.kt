package com.crpr.androidcinema.data.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by claudioribeiro on 09/07/16.
 */
class AuthInterceptor(private val api_key: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val url = request.url()
                .newBuilder()
                .addQueryParameter("api_key", this.api_key)
                .build()

        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}
