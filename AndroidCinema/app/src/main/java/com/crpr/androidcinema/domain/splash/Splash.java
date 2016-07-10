package com.crpr.androidcinema.domain.splash;

import android.app.Activity;

import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.presentation.common.Base;

import rx.Observable;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface Splash {

    interface View extends Base.View {
        void goToNextActivity();
        void showError(String message);
    }

    interface Presenter extends Base.Presenter {
        void getConfiguration();
        void onReceiveResult(Result result);
    }

    interface Interactor {
        Observable<Result> getConfiguration();
    }

    interface Navigator {
        void navigate(Activity activity);
    }
}
