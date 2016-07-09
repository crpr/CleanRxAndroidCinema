package com.crpr.androidcinema.injection.components;

import com.crpr.androidcinema.data.api.factories.InterceptorsFactory;
import com.crpr.androidcinema.presentation.get_configuration.ConfigurationActivity;

/**
 * Created by claudioribeiro on 08/07/16.
 */
public interface CinemaAppComponent {

    //activities
    void inject(ConfigurationActivity activity);

    //fragments

    //factories
    void inject(InterceptorsFactory factory);
}
