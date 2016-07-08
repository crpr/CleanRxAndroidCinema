package com.crpr.androidcinema.injection.modules;

import android.content.Context;

import com.crpr.androidcinema.common.properties.PropertiesLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cribeiro on 05/01/2016.
 */
@Module
public class PropertiesLoaderModule {

    @Provides
    @Singleton
    PropertiesLoader providePropertiesLoader(Context context){
        return new PropertiesLoader(context);
    }
}
