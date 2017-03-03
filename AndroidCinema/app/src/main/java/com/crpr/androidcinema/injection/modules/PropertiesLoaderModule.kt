package com.crpr.androidcinema.injection.modules

import android.content.Context
import com.crpr.androidcinema.common.properties.PropertiesLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cribeiro on 05/01/2016.
 */
@Module
class PropertiesLoaderModule {

    @Provides
    @Singleton
    internal fun providePropertiesLoader(context: Context): PropertiesLoader {
        return PropertiesLoader(context)
    }
}
