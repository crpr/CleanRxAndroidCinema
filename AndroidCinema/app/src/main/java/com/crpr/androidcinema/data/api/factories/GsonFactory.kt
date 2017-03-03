package com.crpr.androidcinema.data.api.factories

import com.crpr.androidcinema.data.api.deserializers.ApiResponseDeserializer
import com.crpr.androidcinema.data.api.models.ApiMovie
import com.crpr.androidcinema.data.api.responses.ApiResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

/**
 * Created by cribeiro on 12/07/2016.
 */
class GsonFactory {

    operator fun get(type: Int): Gson {
        when (type) {
            SERIALIZER -> return GsonBuilder()
                    .registerTypeAdapter(object : TypeToken<ApiResponse<ApiMovie>>() {
                    }.type,
                            ApiResponseDeserializer<ApiMovie>()).create()

            else -> return Gson()
        }
    }

    companion object {
        val SERIALIZER = 1
    }

}
