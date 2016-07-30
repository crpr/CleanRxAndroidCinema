package com.crpr.androidcinema.base;

import com.crpr.androidcinema.data.api.factories.GsonFactory;
import com.crpr.androidcinema.data.api.responses.ApiResponse;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class BaseTest {

    public <T> T loadResource(String name, Class<T> klass){
        final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new GsonFactory().get(GsonFactory.SERIALIZER).fromJson(reader, klass);
    }

    public <T> T loadResourceFromType(String name, TypeToken typeToken){
        final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new GsonFactory().get(GsonFactory.SERIALIZER).fromJson(reader, typeToken.getType());
    }
}
