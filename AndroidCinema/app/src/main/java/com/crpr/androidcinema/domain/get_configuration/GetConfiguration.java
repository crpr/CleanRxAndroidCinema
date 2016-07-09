package com.crpr.androidcinema.domain.get_configuration;

import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;
import com.crpr.androidcinema.presentation.common.AppView;
import com.crpr.androidcinema.presentation.common.IPresenter;

import rx.Observable;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface GetConfiguration {

    interface View extends AppView {
        void displayConfig(ConfigurationModel configuration);
        void showError(String message);
    }

    interface Presenter extends IPresenter {
        void getConfiguration();
        void onReceiveConfiguration(ConfigurationModel configuration);
    }

    interface Interactor {
        Observable<ConfigurationModel> getConfiguration();
    }

    interface Process {
        Observable<ConfigurationModel> getConfiguration();
    }

    interface Service {
        Observable<ApiConfiguration> getConfiguration();
    }
}
