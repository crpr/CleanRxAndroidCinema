package com.crpr.androidcinema.presentation.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.crpr.androidcinema.CinemaApp;
import com.crpr.androidcinema.R;
import com.crpr.androidcinema.domain.discover.Discover;
import com.crpr.androidcinema.domain.discover.ListMovieModel;
import com.crpr.androidcinema.presentation.common.ConnectionUtils;
import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by claudioribeiro on 31/07/16.
 */
public class DiscoverFragment extends Fragment implements Discover.View {

    public static DiscoverFragment instance() {
        return new DiscoverFragment();
    }

    @BindView(R.id.discover_list)
    RecyclerView _discoverList;

    @BindView(R.id.no_connection_wrapper)
    RelativeLayout _noConnectionWrapper;

    @BindView(R.id.no_connection_action_button)
    Button _retryActionButton;

    @Inject
    Discover.Presenter _presenter;

    private DiscoverAdapter _listAdapter;

    private Unbinder _unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_discover, container, false);
        _unbinder = ButterKnife.bind(this, layout);
        ((CinemaApp) getActivity().getApplication()).component().inject(this);

        setupUi();
        setupPresenter();

        return layout;
    }

    private void setupUi() {
        _discoverList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        _discoverList.setHasFixedSize(true);
    }

    private void setupPresenter() {
        _presenter.bindView(this);

        if(ConnectionUtils.isConnectionAvailable(getActivity())) {
            _presenter.discoverMovies();
            return;
        }

        showNoConnection();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if(_unbinder != null){
            _unbinder.unbind();
            _unbinder = null;
        }

        if(_presenter != null){
            _presenter.onDestroy();
            _presenter = null;
        }
    }

    @Override
    public void showMovieList(List<ListMovieModel> models) {
        _discoverList.setVisibility(View.VISIBLE);
        _noConnectionWrapper.setVisibility(View.GONE);

        if(models == null){
            return;
        }

        if(_listAdapter == null){
            _listAdapter = new DiscoverAdapter(getActivity(), models, itemTouchListener);
            _discoverList.setAdapter(_listAdapter);
        }

        _listAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), "An error occured: " + message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNoConnection() {
        _discoverList.setVisibility(View.GONE);
        _noConnectionWrapper.setVisibility(View.VISIBLE);
        _retryActionButton.setOnClickListener(view -> retryLoadMovies());
    }

    private void retryLoadMovies() {
        _discoverList.setVisibility(View.VISIBLE);
        _noConnectionWrapper.setVisibility(View.GONE);
        _presenter.discoverMovies();
    }

    private RecyclerItemTouchListener itemTouchListener =
            (view, position) -> Toast.makeText(getContext(),
                    "Touched item: " + position, Toast.LENGTH_LONG).show();
}
