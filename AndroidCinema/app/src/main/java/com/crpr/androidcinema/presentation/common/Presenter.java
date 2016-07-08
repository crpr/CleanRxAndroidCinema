package com.crpr.androidcinema.presentation.common;

/**
 * Created by claudioribeiro on 08/07/16.
 */
public abstract class Presenter {
    //This methods should map to activities lifecycle

    public void onCreate(){}

    public void onStart(){}

    public void onStop(){}

    public void onPause(){}

    public void onDestroy(){}

    public abstract void bindView(AppView view);

}
