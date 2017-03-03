package com.crpr.androidcinema.injection.modules

import android.app.Application
import android.content.Context
import com.crpr.androidcinema.data.api.factories.GsonFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by cribeiro on 23/05/2016.
 */
@Module
class AppModule(private val appInstance: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return appInstance
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonFactory()[GsonFactory.SERIALIZER]
    }

    @Provides
    @Named("cinema_executor_thread")
    internal fun provideExecutorThread(): Scheduler {
        return Schedulers.newThread()
    }

    @Provides
    @Named("cinema_main_thread")
    @Singleton
    internal fun provideUiThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}