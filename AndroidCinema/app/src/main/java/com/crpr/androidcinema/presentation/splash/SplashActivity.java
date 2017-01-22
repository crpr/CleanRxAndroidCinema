package com.crpr.androidcinema.presentation.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.crpr.androidcinema.CinemaApp;
import com.crpr.androidcinema.R;
import com.crpr.androidcinema.domain.splash.Splash;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements Splash.View {

    @Inject
    Splash.Presenter _presenter;

    @Inject
    Splash.Navigator _navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupUi();
        setupDependencies();
        setupPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        _presenter.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        _presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(_presenter != null){
            _presenter.onDestroy();
            _presenter = null;
        }
    }

    private void setupUi() {
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    private void setupDependencies(){
        ((CinemaApp)getApplication()).component().inject(this);
    }

    private void setupPresenter() {
        _presenter.bindView(this);
        _presenter.getConfiguration();
    }

    @Override
    public void goToNextActivity(Class<?> klass) {
        _navigator.navigate(this, klass);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "An error occured: " + message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNoConnection() {

    }
}
