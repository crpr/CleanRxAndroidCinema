package com.crpr.androidcinema.domain.common.viewmodels;

import java.util.ArrayList;
import java.util.List;

public final class ListConverter {

    public static <M, T> List<M> map(List<T> parseObjects, Converter<M, T> converter) {
        List<M> modelObjects = new ArrayList<>();

        for (T parseObject : parseObjects) {
            M modelObject = converter.map(parseObject);

            if (modelObject != null)
                modelObjects.add(modelObject);
        }

        return modelObjects;
    }
}

