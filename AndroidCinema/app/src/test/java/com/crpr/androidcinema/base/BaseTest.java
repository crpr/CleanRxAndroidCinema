package com.crpr.androidcinema.base;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class BaseTest<T> {

    public T loadResource(String name, Class<T> klass){
        final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return new Gson().fromJson(reader, klass);
    }

}
