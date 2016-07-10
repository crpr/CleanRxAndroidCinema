package com.crpr.androidcinema.data.api.deserializers;

import com.crpr.androidcinema.data.api.responses.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ApiResponseDeserializer<T> implements JsonDeserializer<ApiResponse<T>> {

    @Override
    public ApiResponse<T> deserialize(JsonElement je, Type typeOfT,
                                         JsonDeserializationContext context) throws JsonParseException {

        ApiResponse<T> response = new ApiResponse<>();
        response.setPage(je.getAsJsonObject().get("page").getAsInt());
        response.setPage(je.getAsJsonObject().get("total_pages").getAsInt());
        response.setPage(je.getAsJsonObject().get("total_results").getAsInt());

        JsonArray results = je.getAsJsonObject().get("results").getAsJsonArray();
        List<T> rvalueList = new ArrayList<>(results.getAsJsonArray().size());

        for(JsonElement element : results){
            rvalueList.add(new Gson().fromJson(element, ((ParameterizedType) typeOfT).getActualTypeArguments()[0]));
        }

        response.setResults(rvalueList);

        return response;
    }
}