package com.crpr.androidcinema.domain.welcome_wizard;

import android.app.Activity;

import com.crpr.androidcinema.presentation.common.Base;
import com.crpr.androidcinema.presentation.welcome_wizard.fragments.DefaultSlideFragment;

import java.util.List;

import rx.Observable;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface WelcomeWizard {

    interface View extends Base.View {
        void buildSlides(List<DefaultSlideFragment> slides);
        void userIsDone();
    }

    interface Presenter extends Base.Presenter {
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
