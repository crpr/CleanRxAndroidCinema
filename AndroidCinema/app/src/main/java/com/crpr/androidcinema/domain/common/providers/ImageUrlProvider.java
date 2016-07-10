package com.crpr.androidcinema.domain.common.providers;

import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;
import com.crpr.androidcinema.data.api.models.configuration.enums.Size;
import com.crpr.androidcinema.domain.common.configuration.ConfigurationModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class ImageUrlProvider {

    private static ImageUrlProvider _instance;

    public static ImageUrlProvider sharedInstance(){
        if(_instance == null){
            _instance = new ImageUrlProvider();
        }

        return _instance;
    }

    private ConfigurationModel _config;

    public void setCurrentConfig(ConfigurationModel configuration) {
        _config = configuration;
    }

    public String getUrlFor(int type, Size size){
        return _config.getUrls().get(type+size.raw());
    }

    public static Map<String, String> buildUrlsMap(ApiConfiguration.ApiImagesConfiguration imagesConfiguration){
        Map<String, String> values = new HashMap<>();

        //process backdrop urls
        process(imagesConfiguration.getStillSizes(), ConfigurationModel.BACKDROP,
                imagesConfiguration.getBaseUrl(), values);

        //process backdrop urls
        process(imagesConfiguration.getLogoSizes(), ConfigurationModel.LOGO,
                imagesConfiguration.getBaseUrl(), values);

        //process backdrop urls
        process(imagesConfiguration.getPosterSizes(), ConfigurationModel.POSTER,
                imagesConfiguration.getBaseUrl(), values);

        //process backdrop urls
        process(imagesConfiguration.getProfileSizes(), ConfigurationModel.PROFILE,
                imagesConfiguration.getBaseUrl(), values);

        //process stills urls
        process(imagesConfiguration.getStillSizes(), ConfigurationModel.STILL,
                imagesConfiguration.getBaseUrl(), values);

        return values;
    }

    private static void process(List<Size> list, int type, String baseUrl, Map<String, String> container){
        for(Size size : list){
            String url = baseUrl + size.raw();
            container.put(type + size.raw(), url);
        }
    }
}
