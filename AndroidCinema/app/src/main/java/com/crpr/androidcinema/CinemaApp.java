package com.crpr.androidcinema;

import android.app.Application;

import com.crpr.androidcinema.injection.components.CinemaAppComponent;
import com.crpr.androidcinema.injection.components.DaggerAppComponent;
import com.crpr.androidcinema.injection.modules.AppModule;

/**
 * Created by claudioribeiro on 08/07/16.
 */
public class CinemaApp extends Application {

    private CinemaAppComponent _component = null;

    @Override
    public void onCreate() {
        super.onCreate();

        if(_component == null){
            _component = DaggerAppComponent.builder()
                    .appModule(new AppModule(CinemaApp.this))
                    .build();
        }
    }

    //it should be used for tests only
    public void setAppComponent(CinemaAppComponent component){
        _component = component;
    }

    public CinemaAppComponent component(){
        return _component;
    }

}
