package com.crpr.androidcinema.presentation.get_configuration;

import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;
import com.crpr.androidcinema.domain.get_configuration.GetConfigurationInteractor;
import com.crpr.androidcinema.presentation.common.AppView;
import com.crpr.androidcinema.presentation.common.Presenter;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class GetConfigurationPresenter extends Presenter {

    private GetConfigurationInteractor _interactor;
    private ConfigurationView _view;

    public GetConfigurationPresenter(GetConfigurationInteractor interactor){
        this._interactor = interactor;
    }

    @Override
    public void bindView(AppView view) {
        this._view = (ConfigurationView) view;
    }

    public void getConfiguration(){
        if(_isMakingRequest){
            return;
        }

        _isMakingRequest = true;
        _subscription = _interactor.getConfiguration()
                            .subscribe(this::onReceiveConfiguration,
                                    this::onError);
    }

    private void onReceiveConfiguration(ApiConfiguration configuration){
        _isMakingRequest = false;
        _view.displayConfig(configuration);
    }

    private void onError(Throwable throwable) {
        _isMakingRequest = false;
        _view.showError(throwable.getMessage());
    }
}
