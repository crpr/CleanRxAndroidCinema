package com.crpr.androidcinema.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * Created by cribeiro on 07/01/2016.
 */
public class PreferencesService {

    private final SharedPreferences _prefs;
    private final Gson _gson;

    public PreferencesService(Context context, Gson gson, String key) {
        _prefs = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        _gson = gson;
    }

    public SharedPreferences getPreferences(){
        return _prefs;
    }

    public void putObject(String key, Object object) {
        if (key == null || key.equals("")) {
            throw new IllegalArgumentException("Key is empty or null");
        }
        if (object == null) {
            _prefs.edit().remove(key).apply();
        } else {
            _prefs.edit().putString(key, _gson.toJson(object)).apply();
        }
    }

    public <T> T getObject(String key, Class<T> a) {
        String gson = _prefs.getString(key, null);
        if (gson == null) {
            return null;
        } else {
            try {
                return _gson.fromJson(gson, a);
            } catch (JsonSyntaxException | NullPointerException ex) {
                throw new IllegalArgumentException("Object stored with key "
                        + key + " is instance of other class");
            }
        }
    }

    public <T> T getObjectByType(String key, Type a) {
        String gson = _prefs.getString(key, null);
        if (gson == null) {
            return null;
        } else {
            try {
                return _gson.fromJson(gson, a);
            } catch (JsonSyntaxException | NullPointerException ex) {
                throw new IllegalArgumentException("Object stored with key "
                        + key + " is instance of other class");
            }
        }
    }
}
