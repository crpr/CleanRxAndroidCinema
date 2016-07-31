package com.crpr.androidcinema.domain.welcome_wizard;

import com.crpr.androidcinema.data.preferences.PreferencesService;
import com.crpr.androidcinema.domain.common.Result;

import rx.Observable;

public class WelcomeWizardProcess implements WelcomeWizard.Process{

    private final PreferencesService _prefsService;

    public WelcomeWizardProcess(PreferencesService service){
        _prefsService = service;
    }

    public Observable<Boolean> updateWelcomeWizardDone(boolean isDone){
        return Observable.just(applyWelcomeWizardIsDone(isDone));
    }

    private Boolean applyWelcomeWizardIsDone(boolean isDone){
        _prefsService.setWelcomeWizardDone(isDone);
        return true;
    }

    public Observable<WelcomeWizardResult> checkWelcomeWizardDone(){
        return Observable.just(new WelcomeWizardResult(Result.OK, _prefsService.isWelcomeWizardDone()));
    }
}
