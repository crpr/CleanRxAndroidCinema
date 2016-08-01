package com.crpr.androidcinema.domain.splash;

import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizard;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardResult;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
 * Created by claudioribeiro on 10/07/16.
 */
public class SplashInteractorTest {

    private SplashInteractor interactor;
    private GetConfiguration.Process process;
    private WelcomeWizard.Process wwProcess;

    @Before
    public void setup(){
        process = Mockito.mock(GetConfiguration.Process.class);
        wwProcess = Mockito.mock(WelcomeWizard.Process.class);
        interactor = new SplashInteractor(Schedulers.immediate(), Schedulers.immediate(), process, wwProcess);
    }

    @Test
    public void startTest(){
        Observable<Result> observable = Observable.just(new Result(Result.OK));
        when(process.getConfiguration()).thenReturn(observable);

        Observable<WelcomeWizardResult> wwObservable = Observable.just(new WelcomeWizardResult(Result.OK, true));
        when(wwProcess.checkWelcomeWizardDone()).thenReturn(wwObservable);

        TestSubscriber<Result> testSubscriber = new TestSubscriber<>();
        interactor.start().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

        Result result = testSubscriber.getOnNextEvents().get(0);

        verify(process, times(1)).getConfiguration();
        verify(wwProcess, times(1)).checkWelcomeWizardDone();

        verifyNoMoreInteractions(process);
        verifyNoMoreInteractions(wwProcess);

        assertThat(result, notNullValue());
        assertEquals(result.hasError(), new Result(Result.OK).hasError());
    }
}
