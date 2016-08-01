package com.crpr.androidcinema.domain.discover;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;
import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.responses.ApiResponse;
import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.presentation.common.Base;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by claudioribeiro on 31/07/16.
 */
public class DiscoverInteractorTest extends BaseTest{

    private List<ListMovieModel> listMovieModels;
    private Discover.Process process;
    private Discover.Interactor interactor;

    @Before
    public void setup(){
        listMovieModels = loadResourceFromType(ResourceFiles.LIST_MOVIE_MODEL, new TypeToken<List<ApiMovie>>() {});
        process = Mockito.mock(Discover.Process.class);
        interactor = new DiscoverInteractor(Schedulers.immediate(), Schedulers.immediate(), process);
    }

    @Test
    public void discoverMoviesTest(){
        DiscoverMovieListResult movieListResult = new DiscoverMovieListResult(Result.OK, listMovieModels);

        Observable<DiscoverMovieListResult> observable = Observable.just(movieListResult);
        when(process.discoverMovies()).thenReturn(observable);

        TestSubscriber<DiscoverMovieListResult> testSubscriber = new TestSubscriber<>();
        interactor.discoverMovies().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

        DiscoverMovieListResult result = testSubscriber.getOnNextEvents().get(0);

        verify(process, times(1)).discoverMovies();
        verifyNoMoreInteractions(process);

        assertThat(result, notNullValue());

        assertEquals(movieListResult.getMovies().size(), result.getMovies().size());
    }

}
