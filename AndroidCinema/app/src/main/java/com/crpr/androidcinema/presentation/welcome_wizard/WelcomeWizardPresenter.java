package com.crpr.androidcinema.presentation.welcome_wizard;

import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizard;
import com.crpr.androidcinema.presentation.common.Base;
import com.crpr.androidcinema.presentation.common.Presenter;
import com.crpr.androidcinema.presentation.welcome_wizard.fragments.DefaultSlideFragment;

import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class WelcomeWizardPresenter extends Presenter implements WelcomeWizard.Presenter {

    private WelcomeWizard.View _view;
    private WelcomeWizardStepsGenerator _stepsGenerator;
    private WelcomeWizard.Interactor _interactor;

    public WelcomeWizardPresenter(WelcomeWizardStepsGenerator generator, WelcomeWizard.Interactor interactor){
        _stepsGenerator = generator;
        _interactor = interactor;
    }

    @Override
    public void onCreate() {
        _subscriptions.add(getSlides()
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(defaultSlideFragments -> {
                                _view.buildSlides(defaultSlideFragments);
                            }));
    }

    public final Observable<List<DefaultSlideFragment>> getSlides(){
        return Observable.just(_stepsGenerator.getSlides());
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        _view = null;
        _stepsGenerator = null;
    }

    @Override
    public void bindView(Base.View v) {
        _view = (WelcomeWizard.View) v;
    }

    public final void userIsDoneWithWelcomeWizard() {
        _subscriptions.add(_interactor.updateWelcomeWizardDone(true)
                                    .subscribe(aBoolean -> { _view.userIsDone(); }));
    }
}
