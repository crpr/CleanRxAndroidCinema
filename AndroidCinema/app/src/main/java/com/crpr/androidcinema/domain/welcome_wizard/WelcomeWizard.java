package com.crpr.androidcinema.domain.welcome_wizard;

import android.app.Activity;

import com.crpr.androidcinema.presentation.common.AppView;
import com.crpr.androidcinema.presentation.common.IPresenter;
import com.crpr.androidcinema.presentation.welcome_wizard.fragments.DefaultSlideFragment;

import java.util.List;

import rx.Observable;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface WelcomeWizard {

    interface View extends AppView {
        void buildSlides(List<DefaultSlideFragment> slides);
        void userIsDone();
    }

    interface Presenter extends IPresenter {
        void onCreate();
        Observable<List<DefaultSlideFragment>> getSlides();
        void userIsDoneWithWelcomeWizard();
    }

    interface Interactor {
        Observable<Boolean> updateWelcomeWizardDone(boolean isDone);
    }

    interface Process {
        Observable<Boolean> updateWelcomeWizardDone(boolean isDone);
    }

    interface Navigator {
        void navigate(Activity activity);
    }
}
