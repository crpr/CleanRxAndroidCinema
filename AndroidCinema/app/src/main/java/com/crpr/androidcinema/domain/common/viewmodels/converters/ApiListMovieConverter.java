package com.crpr.androidcinema.domain.common.viewmodels.converters;

import com.crpr.androidcinema.data.api.models.ApiMovie;
import com.crpr.androidcinema.data.api.models.enums.Size;
import com.crpr.androidcinema.domain.common.providers.ImageUrlProvider;
import com.crpr.androidcinema.domain.common.viewmodels.Converter;
import com.crpr.androidcinema.domain.discover.ListMovieModel;

/**
 * Created by claudioribeiro on 13/07/16.
 */
public class ApiListMovieConverter implements Converter<ListMovieModel, ApiMovie> {

    @Override
    public ListMovieModel map(ApiMovie parseObject) {
        String url = ImageUrlProvider.sharedInstance().getUrlFor(Size.W300);

        if(url != null){
            url += parseObject.getBackdropPath();
        }

        return ListMovieModel.id(parseObject.getId())
                                .title(parseObject.getTitle())
                                .imagePath(url)
                                .popularity(parseObject.getPopularity())
                                .votesAvg(parseObject.getVoteAverage())
                                .build();
    }
}
