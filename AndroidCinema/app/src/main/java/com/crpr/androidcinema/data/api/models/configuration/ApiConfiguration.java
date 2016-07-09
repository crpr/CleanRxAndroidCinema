package com.crpr.androidcinema.data.api.models.configuration;

import com.crpr.androidcinema.data.api.models.configuration.enums.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class ApiConfiguration implements Serializable {

    public class ApiImagesConfiguration implements Serializable{

        private String base_url;
        private String secure_base_url;
        private List<Size> backdrop_sizes;
        private List<Size> logo_sizes;
        private List<Size> poster_sizes;
        private List<Size> profile_sizes;
        private List<Size> still_sizes;

        public String getBaseUrl() {
            return base_url;
        }

        public String getSecureBaseUrl() {
            return secure_base_url;
        }

        public List<Size> getBackdropSizes() {
            return backdrop_sizes;
        }

        public List<Size> getLogoSizes() {
            return logo_sizes;
        }

        public List<Size> getPosterSizes() {
            return poster_sizes;
        }

        public List<Size> getProfileSizes() {
            return profile_sizes;
        }

        public List<Size> getStillSizes() {
            return still_sizes;
        }
    }

    private List<String> change_keys;
    private ApiImagesConfiguration images;

    public ApiConfiguration(){}

    public List<String> getChangeKeys(){
        if(change_keys == null){
            return new ArrayList<>();
        }

        return change_keys;
    }

    public ApiImagesConfiguration getImagesConfiguration(){
        return images;
    }

}
