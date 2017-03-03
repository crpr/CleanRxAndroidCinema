package com.crpr.androidcinema.data.api.models;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class ApiConfigurationTest extends BaseTest{

    ApiConfiguration configuration;

    @Before
    public void setup(){
        configuration = loadResource(ResourceFiles.API_CONFIGURATION, ApiConfiguration.class);
    }

    @Test
    public void modelDataAccessTest(){
        String expectedBaseUrl = "http://image.tmdb.org/t/p/",
                expectedSecureUrl = "https://image.tmdb.org/t/p/";

        int expectedBackdropSize = 4,
                expectedLogoSize = 7,
                expectedPosterSize =7,
                expectedProfileSize = 4,
                expectedStillSizes = 4,
                expectedChangeKeys = 7;

        assertThat(configuration, notNullValue());
        assertThat(configuration.getChange_keys(), notNullValue());
        assertThat(configuration.getImages(), notNullValue());
        assertEquals(expectedBaseUrl, configuration.getImages().getBase_url());
        assertEquals(expectedSecureUrl, configuration.getImages().getSecure_base_url());
        assertEquals(expectedBackdropSize, configuration.getImages().getBackdrop_sizes().size());
        assertEquals(expectedLogoSize, configuration.getImages().getLogo_sizes().size());
        assertEquals(expectedPosterSize, configuration.getImages().getPoster_sizes().size());
        assertEquals(expectedProfileSize, configuration.getImages().getProfile_sizes().size());
        assertEquals(expectedStillSizes, configuration.getImages().getStill_sizes().size());
        assertEquals(expectedChangeKeys, configuration.getChange_keys().size());
    }

}
