package com.crpr.androidcinema.domain.welcome_wizard

import android.app.Activity

import com.crpr.androidcinema.presentation.common.Base
import com.crpr.androidcinema.presentation.welcome_wizard.fragments.DefaultSlideFragment

import rx.Observable

/**
 * Created by claudioribeiro on 09/07/16.
 */
interface WelcomeWizard {

    interface View : Base.View {
        fun buildSlides(slides: List<DefaultSlideFragment>)
        fun userIsDone()
    }

    interface Presenter : Base.Presenter {
        fun onCreate()
        val slides: Observable<List<DefaultSlideFragment>>
        fun userIsDoneWithWelcomeWizard()
    }

    interface Interactor {
        fun updateWelcomeWizardDone(isDone: Boolean): Observable<Boolean>
    }

    interface Process {
        fun updateWelcomeWizardDone(isDone: Boolean): Observable<Boolean>
        fun checkWelcomeWizardDone(): Observable<WelcomeWizardResult>
    }

    interface Navigator {
        fun navigate(activity: Activity)
    }
}
