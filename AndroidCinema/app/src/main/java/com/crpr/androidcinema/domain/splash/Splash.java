package com.crpr.androidcinema.domain.splash;

import android.app.Activity;

import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardResult;
import com.crpr.androidcinema.presentation.common.Base;

import rx.Observable;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface Splash {

    interface View extends Base.View {
        void goToNextActivity(Class<?> klass);
    }

    interface Presenter extends Base.Presenter {
        void getConfiguration();
        void onReceiveResult(WelcomeWizardResult result);
    }

    interface Interactor {
        Observable<WelcomeWizardResult> start();
    }

    interface Navigator {
        void navigate(Activity activity, Class<?> klass);
    }
}
