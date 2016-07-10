package com.crpr.androidcinema.domain.common.configuration;

import com.crpr.androidcinema.data.api.models.configuration.ApiConfiguration;
import com.crpr.androidcinema.data.api.models.configuration.enums.Size;
import com.crpr.androidcinema.domain.common.Result;
import com.crpr.androidcinema.domain.common.providers.ImageUrlProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Observable<Result> getConfiguration(){
        return _service.getConfiguration()
                    .flatMap(this::configureImageUrlProvider);
    }

    private Observable<Result> configureImageUrlProvider(ApiConfiguration configuration) {

        ConfigurationModel model = ConfigurationModel
                                    .url(configuration.getImagesConfiguration().getBaseUrl())
                                    .secureUrl(configuration.getImagesConfiguration().getSecureBaseUrl())
                                    .mapUrls(ImageUrlProvider.buildUrlsMap(configuration.getImagesConfiguration()))
                                    .build();

        if(model == null){
            return Observable.just(new Result(Result.PROCESS_ERROR));
        }

        ImageUrlProvider.sharedInstance().setCurrentConfig(model);

        return Observable.just(new Result(Result.PROCESS_OK));
    }
}
