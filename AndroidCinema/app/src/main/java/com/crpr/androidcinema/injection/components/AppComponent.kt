package com.crpr.androidcinema.injection.components

import android.content.Context
import com.crpr.androidcinema.injection.modules.*
import dagger.Component
import javax.inject.Singleton

/**
 * Created by claudioribeiro on 08/07/16.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, PropertiesLoaderModule::class, DatabaseModule::class, ApiModule::class, ConfigurationModule::class, IntroModule::class, PreferencesModule::class, DiscoverModule::class))
interface AppComponent : CinemaAppComponent {
    fun context(): Context
}
