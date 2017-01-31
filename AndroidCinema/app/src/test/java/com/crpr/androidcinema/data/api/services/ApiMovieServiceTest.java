package com.crpr.androidcinema.data.api.services;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;
import com.crpr.androidcinema.data.api.models.ApiMovie;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Observable;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by claudioribeiro on 31/01/2017.
 */

public class ApiMovieServiceTest extends BaseTest {

    private ApiMovieService.ServiceClient client;
    private ApiMovieService service;
    private ApiMovie mockResponse;

    @Before
    public void setup() {
        client = Mockito.mock(ApiMovieService.ServiceClient.class);
        mockResponse = loadResource(ResourceFiles.API_MOVIE_DETAILS_RESPONSE, ApiMovie.class);
        service = new ApiMovieService(client);
    }

    @Test
    public void getMovieDetailsTest() {

        int token = mockResponse.getId();

        Observable<ApiMovie> observable = Observable.just(mockResponse);
        when(client.getMovieDetailsById(token)).thenReturn(observable);

        TestSubscriber<ApiMovie> testSubscriber = new TestSubscriber<>();
        service.getMovieDetailsById(token).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        ApiMovie rvalue = testSubscriber.getOnNextEvents().get(0);

        verify(client, times(1)).getMovieDetailsById(token);
        verifyNoMoreInteractions(client);

        assertThat(rvalue, notNullValue());
        assertEquals(rvalue.getId(), token);
        assertEquals(rvalue.getTitle(), mockResponse.getTitle());
    }

    @Test(expected = NullPointerException.class)
    public void getMovieDetailsExceptionTest() {
        int token = mockResponse.getId();

        doThrow(NullPointerException.class).when(client).getMovieDetailsById(token);

        TestSubscriber<ApiMovie> testSubscriber = new TestSubscriber<>();
        service.getMovieDetailsById(token).subscribe(testSubscriber);

        testSubscriber.assertError(NullPointerException.class);

        verify(client, times(0)).getMovieDetailsById(token);
        verifyNoMoreInteractions(client);
    }

}
