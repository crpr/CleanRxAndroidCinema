package com.crpr.androidcinema.data.api.deserializers

import com.crpr.androidcinema.data.api.responses.ApiResponse
import com.google.gson.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

class ApiResponseDeserializer<T> : JsonDeserializer<ApiResponse<T>> {

    @Throws(JsonParseException::class)
    override fun deserialize(je: JsonElement, typeOfT: Type,
                             context: JsonDeserializationContext): ApiResponse<T> {

        val response = ApiResponse<T>()
        response.page = je.asJsonObject.get("page").asInt
        response.totalPages = je.asJsonObject.get("total_pages").asInt
        response.totalResults = je.asJsonObject.get("total_results").asInt

        val results = je.asJsonObject.get("results").asJsonArray
        val rvalueList = ArrayList<T>(results.asJsonArray.size())

        for (element in results) {
            rvalueList.add(Gson().fromJson<T>(element, (typeOfT as ParameterizedType).actualTypeArguments[0]))
        }

        response.results = rvalueList

        return response
    }
}