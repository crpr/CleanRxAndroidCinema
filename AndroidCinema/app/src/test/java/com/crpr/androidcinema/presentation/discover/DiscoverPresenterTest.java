package com.crpr.androidcinema.presentation.discover;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;
import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.discover.Discover;
import com.crpr.androidcinema.domain.discover.DiscoverMovieListResult;
import com.crpr.androidcinema.domain.discover.ListMovieModel;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by DEATH_STAR on 21/01/2017.
 */

public class DiscoverPresenterTest extends BaseTest {

    private List<ListMovieModel> listMovieModels;
    private Discover.Interactor interactor;
    private Discover.View view;
    private Discover.Presenter presenter;

    @Before
    public void setup() {
        listMovieModels = loadResourceFromType(ResourceFiles.LIST_MOVIE_MODEL,
                new TypeToken<List<ApiMovie>>() {});
        interactor = Mockito.mock(Discover.Interactor.class);
        view = Mockito.mock(Discover.View.class);
        presenter = new DiscoverPresenter(interactor);
        presenter.bindView(view);
    }

    @Test
    public void discoverMoviesTest() {
        DiscoverMovieListResult rvalue = new DiscoverMovieListResult(Result.Companion.getOK(), listMovieModels);
        Observable<DiscoverMovieListResult> observable = Observable.just(rvalue);
        when(interactor.discoverMovies()).thenReturn(observable);

        presenter.discoverMovies();
        presenter.onDestroy();

        verify(interactor, times(1)).discoverMovies();
        verify(view, times(1)).showMovieList(listMovieModels);
    }

    @Test
    public void discoverMoviesErrorTest(){
        String errorMessage = "error message";
        DiscoverMovieListResult rvalue = new DiscoverMovieListResult(Result.Companion.getERROR(), errorMessage);
        Observable<DiscoverMovieListResult> observable = Observable.just(rvalue);
        when(interactor.discoverMovies()).thenReturn(observable);

        presenter.discoverMovies();

        verify(interactor, times(1)).discoverMovies();
        verify(view, times(0)).showMovieList(listMovieModels);
        verify(view, times(1)).showError(errorMessage);
    }

    @Test
    public void getConfigurationExceptionTest(){
        String errorMessage = "sample error message";
        presenter.onError(new Throwable(errorMessage));

        verify(view, times(0)).showMovieList(listMovieModels);
        verify(view, times(1)).showError(errorMessage);
    }
}
