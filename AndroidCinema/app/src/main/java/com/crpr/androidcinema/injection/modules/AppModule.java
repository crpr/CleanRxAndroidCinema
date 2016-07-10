package com.crpr.androidcinema.injection.modules;

import android.app.Application;
import android.content.Context;

import com.crpr.androidcinema.data.api.deserializers.ApiResponseDeserializer;
import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.responses.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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
    @Singleton
    public Gson provideGson(){
        return new GsonBuilder()
                .registerTypeAdapter(new TypeToken<ApiResponse<ApiMovie>>(){}.getType(),
                        new ApiResponseDeserializer<ApiMovie>()).create();
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