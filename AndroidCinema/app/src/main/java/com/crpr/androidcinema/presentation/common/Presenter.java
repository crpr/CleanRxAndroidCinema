package com.crpr.androidcinema.presentation.common;

import rx.Subscription;

/**
 * Created by claudioribeiro on 08/07/16.
 */
public abstract class Presenter implements IPresenter {

    protected boolean _isMakingRequest;
    protected Subscription _subscription;

    //This methods should map to activities lifecycle

    public void onCreate(){}

    public void onStart(){}

    public void onStop(){}

    public void onPause(){}

    public void onDestroy(){
        if(_subscription != null && !_subscription.isUnsubscribed()) {
            _subscription.unsubscribe();
            _subscription = null;
        }
    }

    public abstract void bindView(AppView view);

}
