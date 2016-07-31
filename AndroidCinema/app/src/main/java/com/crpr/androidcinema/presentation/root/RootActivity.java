package com.crpr.androidcinema.presentation.root;

import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.crpr.androidcinema.R;
import com.crpr.androidcinema.presentation.discover.DiscoverFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RootActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.root_navigation_drawer)
    DrawerLayout _drawerLayout;

    @BindView(R.id.root_navigation_view)
    NavigationView _navigationView;

    @BindView(R.id.toolbar)
    Toolbar _toolbar;

    private ActionBarDrawerToggle _drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupUi();
        setupDependencies();
        setupToolbar();
        setupDrawer();
        loadInitialFragment(DiscoverFragment.instance());
    }

    private void setupUi(){
        setContentView(R.layout.activity_root);
    }

    private void setupDependencies() {
        ButterKnife.bind(this);
    }

    private void setupToolbar() {
        _toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(_toolbar);
    }

    private void setupDrawer() {
        _navigationView.setNavigationItemSelectedListener(this);

        _drawerToggle = new ActionBarDrawerToggle(this, _drawerLayout, _toolbar, R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        _drawerLayout.addDrawerListener(_drawerToggle);
        _drawerToggle.syncState();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(_drawerToggle == null){
            return;
        }
        _drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(_drawerToggle == null){
            return;
        }
        _drawerToggle.onConfigurationChanged(newConfig);
    }

    private void loadInitialFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.root_container_body, fragment)
                .commit();

        _navigationView.setCheckedItem(R.id.nav_item_discover_movies);
    }

    private void navigateToFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_container_body, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        _drawerLayout.closeDrawer(GravityCompat.START);

        Fragment fragment;

        switch (item.getItemId()){
            case R.id.nav_item_discover_movies:
                fragment = DiscoverFragment.instance();
                break;

            case R.id.nav_item_popular_movies:
                fragment = DiscoverFragment.instance();
                break;

            case R.id.nav_item_top_rated_movies:
                fragment = DiscoverFragment.instance();
                break;

            case R.id.nav_item_upcoming_movies:
                fragment = DiscoverFragment.instance();
                break;

            default:
                fragment = null;
        }

        if(fragment == null){
            return false;
        }

        navigateToFragment(fragment);

        return true;
    }
}
