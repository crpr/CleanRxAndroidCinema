package com.crpr.androidcinema.presentation.welcome_wizard;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizard;
import com.crpr.androidcinema.presentation.root.RootActivity;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class WelcomeWizardNavigator implements WelcomeWizard.Navigator {

    public void navigate(Activity activity){
        Intent intent = new Intent(activity, RootActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ActivityCompat.startActivity(activity, intent, null);
        activity.finish();
    }
}
