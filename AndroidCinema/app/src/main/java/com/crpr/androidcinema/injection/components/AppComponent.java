package com.crpr.androidcinema.injection.components;

import android.content.Context;

import com.crpr.androidcinema.injection.modules.AppModule;
import com.crpr.androidcinema.injection.modules.DatabaseModule;
import com.crpr.androidcinema.injection.modules.PropertiesLoaderModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by claudioribeiro on 08/07/16.
 */
@Singleton
@Component( modules = {
        AppModule.class,
        PropertiesLoaderModule.class,
        DatabaseModule.class
})
public interface AppComponent extends CinemaAppComponent {
    Context context();
}
