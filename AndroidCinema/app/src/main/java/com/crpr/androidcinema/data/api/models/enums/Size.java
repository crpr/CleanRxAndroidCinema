package com.crpr.androidcinema.data.api.models.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public enum Size {

    @SerializedName("w45")
    W45("w45"),
    @SerializedName("w92")
    W92("w92"),
    @SerializedName("w154")
    W154("w154"),
    @SerializedName("w185")
    W185("w185"),
    @SerializedName("w300")
    W300("w300"),
    @SerializedName("w342")
    W342("w342"),
    @SerializedName("w500")
    W500("w500"),
    @SerializedName("h632")
    H632("h632"),
    @SerializedName("w780")
    W780("w780"),
    @SerializedName("w1280")
    W1280("w1280"),
    @SerializedName("original")
    ORIGINAL("original");

    private final String size;

    Size(String size) {
        this.size = size;
    }

    public String raw(){
        return size;
    }
}