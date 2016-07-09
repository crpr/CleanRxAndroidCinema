package com.crpr.androidcinema.data.api.models.configuration.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class Configuration {

    public enum BackdropSize {

        @SerializedName("w300")
        W300("w300"),
        @SerializedName("w780")
        W780("w780"),
        @SerializedName("w1280")
        W1280("w1280"),
        @SerializedName("original")
        ORIGINAL("original");

        private final String backdrop_size;

        BackdropSize(String backdropSize) {
            this.backdrop_size = backdropSize;
        }

        public String getBackdropSize(){
            return backdrop_size;
        }
    }

    public enum LogoSize {

        @SerializedName("w45")
        W45("w45"),
        @SerializedName("w92")
        W92("w92"),
        @SerializedName("w154")
        W154("w154"),
        @SerializedName("w185")
        W185("w185"),
        @SerializedName("w342")
        W342("w342"),
        @SerializedName("w500")
        W500("w500"),
        @SerializedName("original")
        ORIGINAL("original");

        private final String logo_size;

        LogoSize(String logoSize) {
            this.logo_size = logoSize;
        }

        public String getLogoSize(){
            return logo_size;
        }
    }

    public enum PosterSize {

        @SerializedName("w92")
        W92("w92"),
        @SerializedName("w154")
        W154("w154"),
        @SerializedName("w185")
        W185("w185"),
        @SerializedName("w342")
        W342("w342"),
        @SerializedName("w500")
        W500("w500"),
        @SerializedName("w780")
        W780("w780"),
        @SerializedName("original")
        ORIGINAL("original");

        private final String poster_size;

        PosterSize(String posterSize) {
            this.poster_size = posterSize;
        }

        public String getPosterSize(){
            return poster_size;
        }
    }

    public enum ProfileSize {

        @SerializedName("w45")
        W45("w45"),
        @SerializedName("w185")
        W185("w185"),
        @SerializedName("w632")
        W632("w632"),
        @SerializedName("original")
        ORIGINAL("original");

        private final String profile_size;

        ProfileSize(String profileSize) {
            this.profile_size = profileSize;
        }

        public String getProfileSize(){
            return profile_size;
        }
    }

    public enum StillSize {

        @SerializedName("w92")
        W92("w92"),
        @SerializedName("w185")
        W185("w185"),
        @SerializedName("w300")
        W300("w300"),
        @SerializedName("original")
        ORIGINAL("original");

        private final String sill_size;

        StillSize(String stillSize) {
            this.sill_size = stillSize;
        }

        public String getStillSize(){
            return sill_size;
        }
    }

}
