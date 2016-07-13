package com.crpr.androidcinema.data.api.services;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;
import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.responses.ApiResponse;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Observable;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by claudioribeiro on 12/07/16.
 */
public class ApiDiscoverServiceTest extends BaseTest<ApiMovie> {

    private ApiDiscoverService.ServiceClient client;
    private ApiDiscoverService service;
    private ApiResponse<ApiMovie> mockResponse;

    @Before
    public void setup(){
        client = Mockito.mock(ApiDiscoverService.ServiceClient.class);
        mockResponse = loadResponseResource(ResourceFiles.API_MOVIE_RESPONSE, new TypeToken<ApiResponse<ApiMovie>>() {});
        service = new ApiDiscoverService(client);
    }

    @Test
    public void discoverMovieTest(){
        Observable<ApiResponse<ApiMovie>> observable = Observable.just(mockResponse);
        when(client.discoverMovies()).thenReturn(observable);

        TestSubscriber<ApiResponse<ApiMovie>> testSubscriber = new TestSubscriber<>();
        service.discoverMovies().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        ApiResponse<ApiMovie> rvalue = testSubscriber.getOnNextEvents().get(0);
        assertThat(rvalue, notNullValue());
        assertEquals(rvalue.getPage(), mockResponse.getPage());
        assertEquals(rvalue.getResults().size(), mockResponse.getResults().size());
        assertEquals(rvalue.getTotalPages(), mockResponse.getTotalPages());
        assertEquals(rvalue.getTotalResults(), mockResponse.getTotalResults());
    }

}
