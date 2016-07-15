package com.crpr.androidcinema.presentation.discover;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.crpr.androidcinema.CinemaApp;
import com.crpr.androidcinema.R;
import com.crpr.androidcinema.domain.discover.Discover;
import com.crpr.androidcinema.domain.discover.ListMovieModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class DiscoverActivity extends AppCompatActivity implements Discover.View{

    @Inject
    Discover.Presenter _presenter;

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
        setContentView(R.layout.activity_discover);
        ButterKnife.bind(this);
    }

    private void setupDependencies(){
        ((CinemaApp)getApplication()).component().inject(this);
    }

    private void setupPresenter() {
        _presenter.bindView(this);
        _presenter.discoverMovies();
    }

    @Override
    public void showMovieList(List<ListMovieModel> models) {
        Toast.makeText(this, "MOVIE COUNT: " + models.size(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "An error occured: " + message, Toast.LENGTH_LONG).show();
    }
}
