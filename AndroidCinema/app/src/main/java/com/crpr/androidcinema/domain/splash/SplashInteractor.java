package com.crpr.androidcinema.domain.splash;

import android.util.Log;

import com.crpr.androidcinema.domain.common.Interactor;
import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizard;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardResult;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class SplashInteractor extends Interactor implements Splash.Interactor {

    private final GetConfiguration.Process _process;
    private final WelcomeWizard.Process _wwProcess;

    public SplashInteractor(Scheduler mainThread, Scheduler executorThread,
                            GetConfiguration.Process process,
                            WelcomeWizard.Process wwProcess) {
        super(mainThread, executorThread);
        this._process = process;
        this._wwProcess = wwProcess;
    }

    public Observable<WelcomeWizardResult> start(){
        return _process.getConfiguration()
                .flatMap(this::processNextActivity)
                .observeOn(_mainThread)
                .subscribeOn(_executorThread)
                .doOnError(throwable -> Log.e("INTERACTOR ERROR", "DO SOMETHING IN THIS LAYER"));
    }

    private Observable<WelcomeWizardResult> processNextActivity(Result result){
        return _wwProcess.checkWelcomeWizardDone();
    }

}
