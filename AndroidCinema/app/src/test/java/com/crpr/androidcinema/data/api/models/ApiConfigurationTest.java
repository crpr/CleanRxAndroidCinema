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
        assertThat(configuration.getChangeKeys(), notNullValue());
        assertThat(configuration.getImagesConfiguration(), notNullValue());
        assertEquals(expectedBaseUrl, configuration.getImagesConfiguration().getBaseUrl());
        assertEquals(expectedSecureUrl, configuration.getImagesConfiguration().getSecureBaseUrl());
        assertEquals(expectedBackdropSize, configuration.getImagesConfiguration().getBackdropSizes().size());
        assertEquals(expectedLogoSize, configuration.getImagesConfiguration().getLogoSizes().size());
        assertEquals(expectedPosterSize, configuration.getImagesConfiguration().getPosterSizes().size());
        assertEquals(expectedProfileSize, configuration.getImagesConfiguration().getProfileSizes().size());
        assertEquals(expectedStillSizes, configuration.getImagesConfiguration().getStillSizes().size());
        assertEquals(expectedChangeKeys, configuration.getChangeKeys().size());
    }

}
