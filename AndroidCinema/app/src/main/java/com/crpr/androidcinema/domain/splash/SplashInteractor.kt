package com.crpr.androidcinema.domain.splash

import com.crpr.androidcinema.domain.common.Interactor
import com.crpr.androidcinema.domain.common.Result
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizard
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardResult
import rx.Observable
import rx.Scheduler

/**
 * Created by claudioribeiro on 09/07/16.
 */
class SplashInteractor(mainThread: Scheduler, executorThread: Scheduler,
                       private val _process: GetConfiguration.Process,
                       private val _wwProcess: WelcomeWizard.Process) : Interactor(mainThread, executorThread), Splash.Interactor {

    override fun start(): Observable<WelcomeWizardResult> {
        return _process.configuration
                .flatMap<WelcomeWizardResult>({ this.processNextActivity(it) })
                .observeOn(_mainThread)
                .subscribeOn(_executorThread)
                .doOnError({ it.printStackTrace() })
    }

    private fun processNextActivity(result: Result): Observable<WelcomeWizardResult> {
        return _wwProcess.checkWelcomeWizardDone()
    }

}
