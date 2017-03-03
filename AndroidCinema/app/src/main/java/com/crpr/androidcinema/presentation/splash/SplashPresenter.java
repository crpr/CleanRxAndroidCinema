package com.crpr.androidcinema.presentation.splash;

import com.crpr.androidcinema.domain.splash.Splash;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardResult;
import com.crpr.androidcinema.presentation.common.Base;
import com.crpr.androidcinema.presentation.common.Presenter;
import com.crpr.androidcinema.presentation.root.RootActivity;
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardActivity;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class SplashPresenter extends Presenter implements Splash.Presenter {

    private Splash.Interactor _interactor;
    private Splash.View _view;

    public SplashPresenter(Splash.Interactor interactor){
        this._interactor = interactor;
    }

    @Override
    public void bindView(Base.View view) {
        this._view = (Splash.View) view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        _view = null;
        _interactor = null;
    }

    public final void getConfiguration(){
        if(get_isMakingRequest()){
            return;
        }

        set_isMakingRequest(true);
        get_subscriptions().add(_interactor.start()
                            .subscribe(this::onReceiveResult,
                                    this::onError));
    }

    @Override
    public final void onReceiveResult(WelcomeWizardResult result){
        set_isMakingRequest(false);

        if(result.hasError()){
            _view.showError(result.getMessage());
            return;
        }

        _view.goToNextActivity(result.isWelcomeWizardDone() ?
                RootActivity.class : WelcomeWizardActivity.class);
    }

    public final void onError(Throwable throwable) {
        set_isMakingRequest(false);
        _view.showError(throwable.getMessage());
    }
}
