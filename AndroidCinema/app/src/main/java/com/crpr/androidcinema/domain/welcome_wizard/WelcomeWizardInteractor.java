package com.crpr.androidcinema.domain.welcome_wizard;

import android.util.Log;

import com.crpr.androidcinema.domain.common.Interactor;

import rx.Observable;
import rx.Scheduler;

public class WelcomeWizardInteractor extends Interactor implements WelcomeWizard.Interactor {

    private final WelcomeWizard.Process _process;

    public WelcomeWizardInteractor(Scheduler mainThread, Scheduler executorThread, WelcomeWizard.Process process) {
        super(mainThread, executorThread);
        _process = process;
    }

    public Observable<Boolean> updateWelcomeWizardDone(boolean isDone){
        return _process.updateWelcomeWizardDone(isDone)
                .observeOn(_mainThread)
                .subscribeOn(_executorThread)
                .doOnError(throwable -> Log.e("INTERACTOR ERROR", "DO SOMETHING ON THIS LAYER"));
    }
}
