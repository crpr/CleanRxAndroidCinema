package com.crpr.androidcinema.domain.discover;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;
import com.crpr.androidcinema.data.api.models.ApiConfiguration;
import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.responses.ApiResponse;
import com.crpr.androidcinema.domain.common.configuration.ConfigurationModel;
import com.crpr.androidcinema.domain.common.providers.ImageUrlProvider;
import com.crpr.androidcinema.domain.common.viewmodels.converters.ApiListMovieConverter;
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
 * Created by claudioribeiro on 31/07/16.
 */
public class DiscoverProcessTest extends BaseTest{

    private ApiConfiguration configuration;
    private ApiResponse<ApiMovie> mockResponse;
    private Discover.Service service;
    private Discover.Process process;

    @Before
    public void setup(){
        configuration = loadResource(ResourceFiles.API_CONFIGURATION, ApiConfiguration.class);
        mockResponse = loadResourceFromType(ResourceFiles.API_MOVIE_RESPONSE, new TypeToken<ApiResponse<ApiMovie>>() {});
        service = Mockito.mock(Discover.Service.class);
        process = new DiscoverProcess(service, new ApiListMovieConverter());
    }

    @Test
    public void discoverMoviesTest(){
        ConfigurationModel model = ConfigurationModel
                .url(configuration.getImagesConfiguration().getBaseUrl())
                .secureUrl(configuration.getImagesConfiguration().getSecureBaseUrl())
                .build();

        ImageUrlProvider.sharedInstance().setCurrentConfig(model);

        Observable<ApiResponse<ApiMovie>> observable = Observable.just(mockResponse);

        when(service.discoverMovies()).thenReturn(observable);

        TestSubscriber<DiscoverMovieListResult> testSubscriber = new TestSubscriber<>();
        process.discoverMovies().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

        DiscoverMovieListResult result = testSubscriber.getOnNextEvents().get(0);

        assertThat(result, notNullValue());
        assertEquals(mockResponse.getResults().size(), result.getMovies().size());
    }

}
