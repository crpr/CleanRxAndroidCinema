package com.crpr.androidcinema.presentation.discover;

import com.crpr.androidcinema.domain.discover.Discover;
import com.crpr.androidcinema.domain.discover.DiscoverMovieListResult;
import com.crpr.androidcinema.presentation.common.Base;
import com.crpr.androidcinema.presentation.common.Presenter;

/**
 * Created by claudioribeiro on 14/07/16.
 */
public class DiscoverPresenter extends Presenter implements Discover.Presenter {

    private Discover.View _view;
    private Discover.Interactor _interactor;

    public DiscoverPresenter(Discover.Interactor interactor){
        this._interactor = interactor;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        _view = null;
        _interactor = null;
    }

    public final void onError(Throwable throwable) {
        _isMakingRequest = false;
        _view.showError(throwable.getMessage());
    }

    @Override
    public void bindView(Base.View view) {
        this._view = (Discover.View) view;
    }

    @Override
    public void discoverMovies() {
        if(_isMakingRequest){
            return;
        }

        _isMakingRequest = true;
        _subscriptions.add(_interactor.discoverMovies()
                .subscribe(this::onReceiveResult,
                        this::onError));
    }

    @Override
    public void onReceiveResult(DiscoverMovieListResult result) {
        _isMakingRequest = false;

        if(result.hasError()){
            _view.showError(result.getMessage());
            return;
        }

        _view.showMovieList(result.getMovies());
    }
}
