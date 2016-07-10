package com.crpr.androidcinema.presentation.welcome_wizard;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.crpr.androidcinema.CinemaApp;
import com.crpr.androidcinema.R;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizard;
import com.crpr.androidcinema.presentation.welcome_wizard.base.PagerActivity;
import com.crpr.androidcinema.presentation.welcome_wizard.fragments.DefaultSlideFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class WelcomeWizardActivity extends PagerActivity implements WelcomeWizard.View {

    @Inject
    WelcomeWizard.Presenter _presenter;

    @Inject
    WelcomeWizard.Navigator _navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        configurePresenter();
    }

    private void injectDependencies() {
        ((CinemaApp)getApplication()).component().inject(this);
    }

    private void configurePresenter(){
        _presenter.bindView(this);
        _presenter.onCreate();
    }

    @Override
    protected void onSkipPressed() {
        Toast.makeText(this, "Clicked Skip Button", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDonePressed() {
        _presenter.userIsDoneWithWelcomeWizard();
    }

    @Override
    protected void onNextPressed() {
        //unused
    }

    @Override
    protected void onDestroy() {
        if(_presenter != null){
            _presenter.onDestroy();
        }

        _presenter = null;
        _navigator = null;

        super.onDestroy();
    }

    @Override
    public void buildSlides(List<DefaultSlideFragment> slides) {
        for(DefaultSlideFragment slide : slides){
            addSlide(slide);
        }

        setSkipTextColor(ContextCompat.getColor(this, R.color.grey_light));
        setNextDoneContentColor(ContextCompat.getColor(this, R.color.accent));
        setIndicatorSelectedColor(ContextCompat.getColor(this, R.color.accent));
        setIndicatorUnselectedColor(ContextCompat.getColor(this, R.color.grey_medium));
        setNavBarBackgroundColor(ContextCompat.getColor(this, R.color.primary_dark));
    }

    @Override
    public void userIsDone() {
        _navigator.navigate(this);
    }
}
