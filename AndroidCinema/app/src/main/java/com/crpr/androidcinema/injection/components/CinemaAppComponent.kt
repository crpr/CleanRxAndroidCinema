package com.crpr.androidcinema.injection.components

import com.crpr.androidcinema.data.api.factories.InterceptorsFactory
import com.crpr.androidcinema.presentation.discover.DiscoverFragment
import com.crpr.androidcinema.presentation.splash.SplashActivity
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardActivity

/**
 * Created by claudioribeiro on 08/07/16.
 */
interface CinemaAppComponent {

    //activities
    fun inject(activity: SplashActivity)

    fun inject(activity: WelcomeWizardActivity)

    //fragments
    fun inject(fragment: DiscoverFragment)

    //factories
    fun inject(factory: InterceptorsFactory)
}
