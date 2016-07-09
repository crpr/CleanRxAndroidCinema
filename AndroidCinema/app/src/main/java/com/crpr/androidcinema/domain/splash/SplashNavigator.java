package com.crpr.androidcinema.domain.splash;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by claudioribeiro on 03/07/16.
 */
public class SplashNavigator implements Splash.Navigator{

    public void navigate(Activity activity){
        Toast.makeText(activity, "All good to go!", Toast.LENGTH_LONG).show();
    }
}
