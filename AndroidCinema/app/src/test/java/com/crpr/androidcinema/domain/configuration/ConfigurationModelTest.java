package com.crpr.androidcinema.domain.configuration;

import com.crpr.androidcinema.base.BaseTest;
import com.crpr.androidcinema.base.ResourceFiles;
import com.crpr.androidcinema.data.api.models.ApiConfiguration;
import com.crpr.androidcinema.domain.common.configuration.ConfigurationModel;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public class ConfigurationModelTest extends BaseTest{

    private ApiConfiguration configuration;

    @Before
    public void setup(){
        configuration = loadResource(ResourceFiles.API_CONFIGURATION, ApiConfiguration.class);
    }

    @Test
    public void builderTest() {
        ConfigurationModel model = ConfigurationModel
                .Companion.url(configuration.getImages().getBase_url())
                .secureUrl(configuration.getImages().getSecure_base_url())
                .build();

        assertThat(model, notNullValue());
        assertEquals(model.getBaseUrl(), configuration.getImages().getBase_url());
        assertEquals(model.getSecureBaseUrl(), configuration.getImages().getSecure_base_url());
    }
}
