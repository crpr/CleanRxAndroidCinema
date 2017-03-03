package com.crpr.androidcinema.domain.common.viewmodels.converters

import com.crpr.androidcinema.data.api.models.ApiMovie
import com.crpr.androidcinema.data.api.models.enums.Size
import com.crpr.androidcinema.domain.common.providers.ImageUrlProvider
import com.crpr.androidcinema.domain.common.viewmodels.Converter
import com.crpr.androidcinema.domain.discover.ListMovieModel

/**
 * Created by claudioribeiro on 13/07/16.
 */
class ApiListMovieConverter : Converter<ListMovieModel, ApiMovie>{

    override fun mapTo(parseObject: ApiMovie): ListMovieModel {
        var url: String? = ImageUrlProvider.sharedInstance().getUrlFor(Size.W300)

        if (url != null) {
            url += parseObject.backdrop_path
        }

        return ListMovieModel.id(parseObject.id)
                .title(parseObject.title!!)
                .imagePath(url!!)
                .popularity(parseObject.popularity)
                .votesAvg(parseObject.vote_average)
                .build()
    }

}
