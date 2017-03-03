package com.crpr.androidcinema.domain.welcome_wizard

import android.util.Log

import com.crpr.androidcinema.domain.common.Interactor

import rx.Observable
import rx.Scheduler

class WelcomeWizardInteractor(mainThread: Scheduler, executorThread: Scheduler, private val _process: WelcomeWizard.Process) : Interactor(mainThread, executorThread), WelcomeWizard.Interactor {

    override fun updateWelcomeWizardDone(isDone: Boolean): Observable<Boolean> {
        return _process.updateWelcomeWizardDone(isDone)
                .observeOn(_mainThread)
                .subscribeOn(_executorThread)
                .doOnError { throwable -> Log.e("INTERACTOR ERROR", "DO SOMETHING ON THIS LAYER") }
    }
}
