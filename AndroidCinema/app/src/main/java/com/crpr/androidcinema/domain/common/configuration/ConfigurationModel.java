package com.crpr.androidcinema.domain.common.configuration;

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

    private ConfigurationModel(){}

    public String getBaseUrl() {
        return base_url;
    }

    public String getSecureBaseUrl() {
        return secure_base_url;
    }

    public interface ISecureUrl {
        IBuild secureUrl(String url);
    }

    public interface IBuild {
        ConfigurationModel build();
    }

    public static ISecureUrl url(String url){
        return new ConfigurationModel.Builder(url);
    }

    private static class Builder implements ISecureUrl, IBuild {

        private ConfigurationModel instance = new ConfigurationModel();

        public Builder(String url){
            instance.base_url = url;
        }

        @Override
        public ConfigurationModel build() {
            return instance;
        }

        @Override
        public IBuild secureUrl(String url) {
            instance.secure_base_url = url;
            return this;
        }
    }

}