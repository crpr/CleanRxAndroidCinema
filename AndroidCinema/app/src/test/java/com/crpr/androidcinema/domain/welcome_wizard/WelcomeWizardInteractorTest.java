package com.crpr.androidcinema.domain.welcome_wizard;

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
public class WelcomeWizardInteractorTest {

    private WelcomeWizard.Interactor interactor;
    private WelcomeWizard.Process process;

    @Before
    public void setup(){
        process = Mockito.mock(WelcomeWizard.Process.class);
        interactor = new WelcomeWizardInteractor(Schedulers.immediate(), Schedulers.immediate(), process);
    }

    @Test
    public void updateWelcomeWizardTest(){
        Observable<Boolean> observable = Observable.just(Boolean.TRUE);
        when(process.updateWelcomeWizardDone(true)).thenReturn(observable);

        TestSubscriber<Boolean> testSubscriber = new TestSubscriber<>();
        interactor.updateWelcomeWizardDone(true).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

        Boolean result = testSubscriber.getOnNextEvents().get(0);

        assertThat(result, notNullValue());
        assertEquals(result, Boolean.TRUE);
    }
}
