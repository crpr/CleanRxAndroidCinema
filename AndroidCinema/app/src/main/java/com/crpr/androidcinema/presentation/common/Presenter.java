package com.crpr.androidcinema.presentation.common;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by claudioribeiro on 08/07/16.
 */
public abstract class Presenter implements Base.Presenter {

    protected boolean _isMakingRequest;
    protected CompositeSubscription _subscriptions = new CompositeSubscription();

    //This methods should map to activities lifecycle

    public void onCreate(){}

    public void onStart(){}

    public void onStop(){}

    public void onPause(){}

    public void onDestroy(){
        if(_subscriptions != null && _subscriptions.hasSubscriptions()){
            _subscriptions.unsubscribe();
            _subscriptions = null;
        }
    }

    public abstract void bindView(Base.View view);

}
