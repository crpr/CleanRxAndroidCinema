package com.crpr.androidcinema.presentation.common;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface IPresenter {
    void onError(Throwable throwable);
    void onStart();
    void onPause();
    void onDestroy();
    void bindView(AppView view);
}
