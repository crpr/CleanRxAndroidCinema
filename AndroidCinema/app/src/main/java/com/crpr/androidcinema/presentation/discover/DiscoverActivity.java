package com.crpr.androidcinema.presentation.discover;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.crpr.androidcinema.CinemaApp;
import com.crpr.androidcinema.R;
import com.crpr.androidcinema.domain.discover.Discover;
import com.crpr.androidcinema.domain.discover.ListMovieModel;
import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiscoverActivity extends AppCompatActivity implements Discover.View{

    @BindView(R.id.toolbar)
    Toolbar _toolbar;

    @BindView(R.id.discover_list)
    RecyclerView _discoverList;

    @Inject
    Discover.Presenter _presenter;

    private DiscoverAdapter _listAdapter;

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
        setContentView(R.layout.activity_discover);
        ButterKnife.bind(this);

        _discoverList.setLayoutManager(new LinearLayoutManager(this));
        _discoverList.setHasFixedSize(true);
    }

    private void setupDependencies(){
        ((CinemaApp)getApplication()).component().inject(this);
    }

    private void setupToolbar() {
        _toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(_toolbar);
    }

    private void setupPresenter() {
        _presenter.bindView(this);
        _presenter.discoverMovies();
    }

    @Override
    public void showMovieList(List<ListMovieModel> models) {
        if(models == null){
            setupEmptyView();
            return;
        }

        if(_listAdapter == null){
            _listAdapter = new DiscoverAdapter(getApplicationContext(), models, itemTouchListener);
            _discoverList.setAdapter(_listAdapter);
        }

        _listAdapter.notifyDataSetChanged();
    }

    private void setupEmptyView() {
        Toast.makeText(this, "Render empty page", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "An error occured: " + message, Toast.LENGTH_LONG).show();
    }

    private RecyclerItemTouchListener itemTouchListener =
            (view, position) -> Toast.makeText(getApplicationContext(),
                    "Touched item: " + position, Toast.LENGTH_LONG).show();
}
