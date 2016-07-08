package com.crpr.androidcinema.common.properties;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.crpr.androidcinema.BuildConfig;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by cribeiro on 12-09-2015.
 */
public class PropertiesLoader {

    public static final String API_BASE_URL = "api.base_url";
    public static final String API_KEY = "api.key";

    private final String _envToken = "[ENV]";

    private String _configFile = "configuration-"+ _envToken +".properties";

    private Properties _properties;

    public PropertiesLoader(Context context){
        loadProperties(context);
    }

    private String getConfiguration(Context ctx){
        try {
            ApplicationInfo ai = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            String environment = bundle.getString("environment");
            Log.d("LOADED_ENVIRONMENT", " VAL = " + environment);
            return environment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public void loadProperties(Context ctx){
        try {
            _properties = new Properties();
            _configFile = _configFile.replace(_envToken, getConfiguration(ctx));
            InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(_configFile);

            _properties.load(inputStream);
            if (BuildConfig.DEBUG) {
                printLoadedConfiguration();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    private void printLoadedConfiguration(){
        Log.d(API_BASE_URL, " = " + getProperty(API_BASE_URL));
        Log.d(API_KEY, " = " + getProperty(API_KEY));
    }

    public String getProperty(String property){
        return _properties.getProperty(property);
    }
}
