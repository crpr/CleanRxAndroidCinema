package com.crpr.androidcinema.domain.common.viewmodels;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public final class ListConverter {

    public static <M, T> List<M> map(List<T> parseObjects, Converter<M, T> converter) {
        List<M> modelObjects = new ArrayList<>();

        Log.d("LIST CONVERT", "Start");

        for (T parseObject : parseObjects) {
            M modelObject = converter.map(parseObject);

            if (modelObject != null)
                modelObjects.add(modelObject);
        }

        Log.d("LIST CONVERT", "End");

        return modelObjects;
    }
}

