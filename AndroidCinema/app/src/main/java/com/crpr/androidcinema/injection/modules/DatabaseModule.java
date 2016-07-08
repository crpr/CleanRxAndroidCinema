package com.crpr.androidcinema.injection.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmConfiguration;

/**
 * Created by DEATH_STAR on 25/05/2016.
 */
@Module
public class DatabaseModule {

    @Provides
    RealmConfiguration provideRealmConfiguration(Context context){
        return new RealmConfiguration.Builder(context).build();
    }

}
