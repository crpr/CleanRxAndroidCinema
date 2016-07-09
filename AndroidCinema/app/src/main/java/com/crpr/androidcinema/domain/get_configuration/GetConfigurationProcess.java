package com.crpr.androidcinema.domain.get_configuration;

import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;
import com.crpr.androidcinema.data.api.services.ApiConfigurationService;

import rx.Observable;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class GetConfigurationProcess implements GetConfiguration.Process {

    private final GetConfiguration.Service _service;

    public GetConfigurationProcess(GetConfiguration.Service service){
        this._service = service;
    }

    /**************** GET UPDATED CONFIGURATION ***********************/
    public Observable<ApiConfiguration> getConfiguration(){
        return _service.getConfiguration();
    }
}
