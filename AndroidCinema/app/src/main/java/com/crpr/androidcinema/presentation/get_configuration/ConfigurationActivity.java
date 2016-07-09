package com.crpr.androidcinema.presentation.get_configuration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.crpr.androidcinema.CinemaApp;
import com.crpr.androidcinema.R;
import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfigurationActivity extends AppCompatActivity implements ConfigurationView {

    @BindView(R.id.toolbar)
    Toolbar _toolbar;

    @BindView(R.id.config_result)
    TextView _resultLabel;

    @Inject
    GetConfigurationPresenter _presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupUi();
        setupToolbar();
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
        setContentView(R.layout.activity_configuration);
        ButterKnife.bind(this);
    }

    private void setupToolbar() {
        _toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(_toolbar);
    }

    private void setupDependencies(){
        ((CinemaApp)getApplication()).component().inject(this);
    }

    private void setupPresenter() {
        _presenter.bindView(this);
        _presenter.getConfiguration();
    }

    @Override
    public void displayConfig(ApiConfiguration configuration) {
        _resultLabel.setText("BaseUrl: " + configuration.getImagesConfiguration().getBaseUrl());
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "An error occured: " + message, Toast.LENGTH_LONG).show();
    }
}
