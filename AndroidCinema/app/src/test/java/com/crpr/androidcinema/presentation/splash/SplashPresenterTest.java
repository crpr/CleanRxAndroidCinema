package com.crpr.androidcinema.presentation.splash;

import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.splash.Splash;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Observable;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class SplashPresenterTest {

    private Splash.Interactor interactor;
    private Splash.View view;
    private SplashPresenter presenter;

    @Before
    public void setup(){
        interactor = Mockito.mock(Splash.Interactor.class);
        view = Mockito.mock(Splash.View.class);
        presenter = new SplashPresenter(interactor);
        presenter.bindView(view);
    }

    @Test
    public void getConfigurationTest(){
        Result rvalue = new Result(Result.OK);
        Observable<Result> observable = Observable.just(rvalue);
        when(interactor.start()).thenReturn(observable);

        presenter.getConfiguration();
        presenter.onDestroy();

        verify(interactor, times(1)).start();
        verify(view, times(1)).goToNextActivity();
    }

    @Test
    public void getConfigurationErrorTest(){
        String errorMessage = "error message";
        Result rvalue = new Result(Result.ERROR, errorMessage);
        Observable<Result> observable = Observable.just(rvalue);
        when(interactor.start()).thenReturn(observable);

        presenter.getConfiguration();

        verify(interactor, times(1)).start();
        verify(view, times(0)).goToNextActivity();
        verify(view, times(1)).showError(errorMessage);
    }

    @Test
    public void getConfigurationExceptionTest(){
        String errorMessage = "sample error message";
        presenter.onError(new Throwable(errorMessage));

        verify(view, times(0)).goToNextActivity();
        verify(view, times(1)).showError(errorMessage);
    }
}
