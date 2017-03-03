package com.crpr.androidcinema.domain.configuration;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;
import com.crpr.androidcinema.data.api.models.ApiConfiguration;
import com.crpr.androidcinema.data.api.models.enums.Size;
import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration;
import com.crpr.androidcinema.domain.common.configuration.GetConfigurationProcess;
import com.crpr.androidcinema.domain.common.providers.ImageUrlProvider;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Observable;
import rx.observers.TestSubscriber;

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
public class ConfigurationProcessTest extends BaseTest{

    private ApiConfiguration configuration;
    private GetConfiguration.Service service;
    private GetConfiguration.Process process;

    @Before
    public void setup(){
        configuration = loadResource(ResourceFiles.API_CONFIGURATION, ApiConfiguration.class);
        service = Mockito.mock(GetConfiguration.Service.class);
        process = new GetConfigurationProcess(service);
    }

    @Test
    public void getConfigurationTest(){
        Observable<ApiConfiguration> observable = Observable.just(configuration);

        when(service.getConfiguration()).thenReturn(observable);

        TestSubscriber<Result> testSubscriber = new TestSubscriber<>();
        process.getConfiguration().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Result result = testSubscriber.getOnNextEvents().get(0);

        verify(service, times(1)).getConfiguration();
        verifyNoMoreInteractions(service);

        assertThat(result, notNullValue());

        String expectedUrl = configuration.getImages().getBase_url() +
                                configuration.getImages().getLogo_sizes().get(4).raw();

        assertEquals(expectedUrl, ImageUrlProvider.Companion.sharedInstance()
                                        .getUrlFor(Size.W300));
    }

}
