package com.crpr.androidcinema.injection.modules

import android.content.Context
import com.crpr.androidcinema.BuildConfig
import com.crpr.androidcinema.data.preferences.AppPreferences
import com.crpr.androidcinema.data.preferences.PreferencesService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cribeiro on 05/01/2016.
 */
@Module
class PreferencesModule {

    @Provides
    @Singleton
    internal fun providePreferencesService(context: Context, gson: Gson): PreferencesService {
        return AppPreferences(context, gson, BuildConfig.APPLICATION_ID)
    }

}
