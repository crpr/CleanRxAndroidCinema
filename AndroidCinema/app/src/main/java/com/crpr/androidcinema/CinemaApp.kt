package com.crpr.androidcinema

import android.app.Application
import com.crpr.androidcinema.injection.components.CinemaAppComponent
import com.crpr.androidcinema.injection.components.DaggerAppComponent
import com.crpr.androidcinema.injection.modules.AppModule

/**
 * Created by claudioribeiro on 08/07/16.
 */
class CinemaApp : Application() {

    private var _component: CinemaAppComponent? = null

    override fun onCreate() {
        super.onCreate()

        if (_component == null) {
           _component = DaggerAppComponent.builder()
                    .appModule(AppModule(this@CinemaApp))
                    .build()
        }
    }

    //it should be used for tests only
    fun setAppComponent(component: CinemaAppComponent) {
        _component = component
    }

    fun component(): CinemaAppComponent? {
        return _component
    }

}
