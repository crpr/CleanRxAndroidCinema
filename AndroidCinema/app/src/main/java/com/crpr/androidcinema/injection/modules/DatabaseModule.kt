package com.crpr.androidcinema.injection.modules

import android.content.Context

import dagger.Module
import dagger.Provides
import io.realm.RealmConfiguration

/**
 * Created by DEATH_STAR on 25/05/2016.
 */
@Module
class DatabaseModule {

    @Provides
    internal fun provideRealmConfiguration(context: Context): RealmConfiguration {
        return RealmConfiguration.Builder(context).build()
    }

}
