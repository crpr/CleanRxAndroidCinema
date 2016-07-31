package com.crpr.androidcinema.domain.splash;

import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class SplashInteractorTest {

    private SplashInteractor interactor;
    private GetConfiguration.Process process;

    @Before
    public void setup(){
        process = Mockito.mock(GetConfiguration.Process.class);
        interactor = new SplashInteractor(Schedulers.immediate(), Schedulers.immediate(), process);
    }

    @Test
    public void updateWelcomeWizardTest(){
        Observable<Result> observable = Observable.just(new Result(Result.OK));
        when(process.getConfiguration()).thenReturn(observable);

        TestSubscriber<Result> testSubscriber = new TestSubscriber<>();
        interactor.start().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

        Result result = testSubscriber.getOnNextEvents().get(0);

        assertThat(result, notNullValue());
        assertEquals(result.hasError(), new Result(Result.OK).hasError());
    }
}
