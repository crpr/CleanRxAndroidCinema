package com.crpr.androidcinema.domain.configuration;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;
import com.crpr.androidcinema.data.api.models.ApiConfiguration;
import com.crpr.androidcinema.domain.common.configuration.ConfigurationModel;
import com.crpr.androidcinema.domain.common.providers.ImageUrlProvider;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class ConfigurationModelTest extends BaseTest<ApiConfiguration>{

    private ApiConfiguration configuration;

    @Before
    public void setup(){
        configuration = loadResource(ResourceFiles.API_CONFIGURATION, ApiConfiguration.class);
    }

    @Test
    public void builderTest() {
        ConfigurationModel model = ConfigurationModel
                .url(configuration.getImagesConfiguration().getBaseUrl())
                .secureUrl(configuration.getImagesConfiguration().getSecureBaseUrl())
                .mapUrls(ImageUrlProvider.buildUrlsMap(configuration.getImagesConfiguration()))
                .build();

        assertThat(model, notNullValue());
        assertEquals(model.getBaseUrl(), configuration.getImagesConfiguration().getBaseUrl());
        assertEquals(model.getSecureBaseUrl(), configuration.getImagesConfiguration().getSecureBaseUrl());

        int total = configuration.getImagesConfiguration().getBackdropSizes().size() +
                configuration.getImagesConfiguration().getLogoSizes().size() +
                configuration.getImagesConfiguration().getPosterSizes().size() +
                configuration.getImagesConfiguration().getProfileSizes().size() +
                configuration.getImagesConfiguration().getStillSizes().size();

        assertEquals(model.getUrls().size(), total);
    }
}
