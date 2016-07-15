package com.crpr.androidcinema.presentation.common;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public interface Base {

    interface View {
        void showError(String message);
    }

    interface Presenter {
        void onError(Throwable throwable);
        void onStart();
        void onPause();
        void onDestroy();
        void bindView(View view);
    }
}
