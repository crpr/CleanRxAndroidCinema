package com.crpr.androidcinema.data.api.factories;

import com.crpr.androidcinema.data.api.services.ApiConfigurationService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import okhttp3.OkHttpClient;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class ApiServiceFactoryTest {

    private OkHttpClient client;
    private String url;

    @Before
    public void setup() {
        client = Mockito.mock(OkHttpClient.class);
        url = "http://www.sample.com";
    }

    @Test
    public void getServiceTest(){
        ApiServiceFactory factory = new ApiServiceFactory(client, url);

        assertThat(factory, notNullValue());

        ApiConfigurationService.ServiceClient service =
                factory.getServiceClient(ApiConfigurationService.ServiceClient.class);

        assertThat(service, notNullValue());
    }

}
