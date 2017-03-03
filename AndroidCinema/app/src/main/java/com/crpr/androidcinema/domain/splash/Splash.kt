package com.crpr.androidcinema.domain.splash

import android.app.Activity

import com.crpr.androidcinema.domain.common.Result
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardResult
import com.crpr.androidcinema.presentation.common.Base

import rx.Observable

/**
 * Created by claudioribeiro on 09/07/16.
 */
interface Splash {

    interface View : Base.View {
        fun goToNextActivity(klass: Class<*>)
    }

    interface Presenter : Base.Presenter {
        fun getConfiguration()
        fun onReceiveResult(result: WelcomeWizardResult)
    }

    interface Interactor {
        fun start(): Observable<WelcomeWizardResult>
    }

    interface Navigator {
        fun navigate(activity: Activity, klass: Class<*>)
    }
}
