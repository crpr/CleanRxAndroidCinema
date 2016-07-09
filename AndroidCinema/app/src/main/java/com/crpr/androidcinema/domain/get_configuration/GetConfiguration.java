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
        void displayConfig(ApiConfiguration configuration);
        void showError(String message);
    }

    interface Presenter extends IPresenter {
        void getConfiguration();
        void onReceiveConfiguration(ApiConfiguration configuration);
    }

    interface Interactor {
        Observable<ApiConfiguration> getConfiguration();
    }

    interface Process {
        Observable<ApiConfiguration> getConfiguration();
    }

    interface Service {
        Observable<ApiConfiguration> getConfiguration();
    }
}
