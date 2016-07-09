package com.crpr.androidcinema.domain.get_configuration;

import java.util.Map;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class ConfigurationModel {

    public static final int BACKDROP = 1;
    public static final int LOGO = 2;
    public static final int POSTER = 3;
    public static final int PROFILE = 4;
    public static final int STILL = 5;

    private String base_url;
    private String secure_base_url;
    private Map<String, String> urls;

    private ConfigurationModel(){}

    public String getBaseUrl() {
        return base_url;
    }

    public String getSecureBaseUrl() {
        return secure_base_url;
    }

    public Map<String, String> getUrls() {
        return urls;
    }

    public interface IBaseUrl {
        ISecureUrl url(String url);
    }

    public interface ISecureUrl {
        IUrls secureUrl(String url);
    }

    public interface IUrls {
        IBuild mapUrls(Map<String,String> urls);
    }

    public interface IBuild {
        ConfigurationModel build();
    }

    public static ISecureUrl url(String url){
        return new ConfigurationModel.Builder(url);
    }

    private static class Builder implements IBaseUrl, ISecureUrl, IUrls, IBuild {

        private ConfigurationModel instance = new ConfigurationModel();

        public Builder(String url){
            instance.base_url = url;
        }

        @Override
        public ConfigurationModel build() {
            return instance;
        }

        @Override
        public ISecureUrl url(String url) {
            instance.base_url = url;
            return this;
        }

        @Override
        public IUrls secureUrl(String url) {
            instance.secure_base_url = url;
            return this;
        }

        @Override
        public IBuild mapUrls(Map<String, String> urls) {
            instance.urls = urls;
            return this;
        }
    }

}