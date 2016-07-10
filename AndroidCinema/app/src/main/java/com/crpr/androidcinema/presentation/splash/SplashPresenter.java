package com.crpr.androidcinema.presentation.splash;

import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.splash.Splash;
import com.crpr.androidcinema.presentation.common.Base;
import com.crpr.androidcinema.presentation.common.Presenter;

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
        if(_isMakingRequest){
            return;
        }

        _isMakingRequest = true;
        _subscriptions.add(_interactor.getConfiguration()
                            .subscribe(this::onReceiveResult,
                                    this::onError));
    }

    @Override
    public final void onReceiveResult(Result result){
        _isMakingRequest = false;

        if(result.hasError()){
            _view.showError(result.getMessage());
            return;
        }

        _view.goToNextActivity();
    }

    public final void onError(Throwable throwable) {
        _isMakingRequest = false;
        _view.showError(throwable.getMessage());
    }
}
