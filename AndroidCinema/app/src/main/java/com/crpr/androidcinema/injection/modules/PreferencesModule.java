package com.crpr.androidcinema.injection.modules;

import android.content.Context;

import com.crpr.androidcinema.BuildConfig;
import com.crpr.androidcinema.data.preferences.PreferencesService;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cribeiro on 05/01/2016.
 */
@Module
public class PreferencesModule {

    @Provides
    @Singleton
    PreferencesService providePreferencesService(Context context, Gson gson){
        return new PreferencesService(context, gson, BuildConfig.APPLICATION_ID);
    }

}
