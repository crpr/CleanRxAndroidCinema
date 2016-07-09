package com.crpr.androidcinema.presentation.get_configuration;

import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;
import com.crpr.androidcinema.presentation.common.AppView;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface ConfigurationView extends AppView {
    void displayConfig(ApiConfiguration configuration);
    void showError(String message);
}
