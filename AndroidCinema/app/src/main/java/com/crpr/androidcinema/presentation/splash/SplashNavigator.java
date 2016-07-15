package com.crpr.androidcinema.presentation.splash;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import com.crpr.androidcinema.domain.splash.Splash;
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardActivity;

/**
 * Created by claudioribeiro on 03/07/16.
 */
public class SplashNavigator implements Splash.Navigator {

    public void navigate(Activity activity){
        Intent intent = new Intent(activity, WelcomeWizardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ActivityCompat.startActivity(activity, intent, null);
        activity.finish();
    }
}
