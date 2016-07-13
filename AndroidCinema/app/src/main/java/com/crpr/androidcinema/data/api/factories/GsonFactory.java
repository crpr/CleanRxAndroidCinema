package com.crpr.androidcinema.data.api.factories;

import com.crpr.androidcinema.data.api.deserializers.ApiResponseDeserializer;
import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.responses.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Created by cribeiro on 12/07/2016.
 */
public class GsonFactory {

    public static final int SIMPLE = 1;
    public static final int SERIALIZER = 2;

    public Gson get(int type){
        switch (type){
            case SIMPLE:
                return new Gson();

            case SERIALIZER:
                return new GsonBuilder()
                        .registerTypeAdapter(new TypeToken<ApiResponse<ApiMovie>>() {}.getType(),
                                new ApiResponseDeserializer<ApiMovie>()).create();

            default:
                return null;
        }
    }

}
