package com.crpr.androidcinema.injection.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cribeiro on 23/05/2016.
 */
@Module
public class AppModule {

    private final Application appInstance;

    public AppModule(Application application){
        appInstance = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return appInstance;
    }

    @Provides
    @Named("marvel_executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.newThread();
    }

    @Provides
    @Named("marvel_main_thread")
    @Singleton
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }

}