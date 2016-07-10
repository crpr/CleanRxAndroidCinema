package com.crpr.androidcinema.domain.welcome_wizard;

import com.crpr.androidcinema.data.preferences.PreferencesService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class WelcomeWizardProcessTest{

    private WelcomeWizardProcess process;

    @Before
    public void setup(){
        process = new WelcomeWizardProcess(Mockito.mock(PreferencesService.class));
    }

    @Test
    public void updateWelcomeWizardDone(){
        TestSubscriber<Boolean> testSubscriber = new TestSubscriber<>();
        process.updateWelcomeWizardDone(true).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Boolean result = testSubscriber.getOnNextEvents().get(0);

        assertThat(result, notNullValue());
        assertEquals(result, Boolean.TRUE);
    }

}
