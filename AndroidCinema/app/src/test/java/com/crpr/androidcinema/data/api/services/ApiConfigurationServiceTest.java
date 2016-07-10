package com.crpr.androidcinema.data.api.services;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;
import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Observable;
import rx.observers.TestSubscriber;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class ApiConfigurationServiceTest extends BaseTest<ApiConfiguration>{

    private ApiConfigurationService.ServiceClient client;
    private ApiConfigurationService service;
    private ApiConfiguration mockResponse;

    @Before
    public void setup(){
        client = Mockito.mock(ApiConfigurationService.ServiceClient.class);
        mockResponse = loadResource(ResourceFiles.API_CONFIGURATION, ApiConfiguration.class);
        service = new ApiConfigurationService(client);
    }

    @Test
    public void getConfigurationTest(){
        Observable<ApiConfiguration> observable = Observable.just(mockResponse);
        when(client.getConfiguration()).thenReturn(observable);

        TestSubscriber<ApiConfiguration> testSubscriber = new TestSubscriber<>();
        service.getConfiguration().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        ApiConfiguration rvalue = testSubscriber.getOnNextEvents().get(0);
        assertThat(rvalue, notNullValue());
    }
}