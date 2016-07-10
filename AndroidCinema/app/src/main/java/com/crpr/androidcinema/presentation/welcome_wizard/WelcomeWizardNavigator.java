package com.crpr.androidcinema.presentation.welcome_wizard;

import android.app.Activity;
import android.widget.Toast;

import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizard;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class WelcomeWizardNavigator implements WelcomeWizard.Navigator {

    public void navigate(Activity activity){
        Toast.makeText(activity, "All good to go!", Toast.LENGTH_LONG).show();
    }
}
