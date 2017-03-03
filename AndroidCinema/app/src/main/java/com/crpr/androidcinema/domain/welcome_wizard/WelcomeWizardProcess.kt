package com.crpr.androidcinema.domain.welcome_wizard

import com.crpr.androidcinema.data.preferences.PreferencesService
import com.crpr.androidcinema.domain.common.Result

import rx.Observable

class WelcomeWizardProcess(private val _prefsService: PreferencesService) : WelcomeWizard.Process {

    override fun updateWelcomeWizardDone(isDone: Boolean): Observable<Boolean> {
        return Observable.just(applyWelcomeWizardIsDone(isDone))
    }

    private fun applyWelcomeWizardIsDone(isDone: Boolean): Boolean {
        _prefsService.isWelcomeWizardDone = isDone
        return true
    }

    override fun checkWelcomeWizardDone(): Observable<WelcomeWizardResult> {
        return Observable.just(WelcomeWizardResult(Result.OK, _prefsService.isWelcomeWizardDone))
    }
}
