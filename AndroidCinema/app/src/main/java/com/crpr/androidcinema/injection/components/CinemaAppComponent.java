package com.crpr.androidcinema.injection.components;

import com.crpr.androidcinema.data.api.factories.InterceptorsFactory;
import com.crpr.androidcinema.presentation.discover.DiscoverFragment;
import com.crpr.androidcinema.presentation.splash.SplashActivity;
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardActivity;

/**
 * Created by claudioribeiro on 08/07/16.
 */
public interface CinemaAppComponent {

    //activities
    void inject(SplashActivity activity);
    void inject(WelcomeWizardActivity activity);

    //fragments
    void inject(DiscoverFragment fragment);

    //factories
    void inject(InterceptorsFactory factory);
}
