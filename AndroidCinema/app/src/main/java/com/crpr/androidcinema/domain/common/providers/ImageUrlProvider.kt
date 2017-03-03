package com.crpr.androidcinema.domain.common.providers

import com.crpr.androidcinema.data.api.models.enums.Size
import com.crpr.androidcinema.domain.common.configuration.ConfigurationModel

/**
 * Created by claudioribeiro on 09/07/16.
 */
class ImageUrlProvider {

    private var _config: ConfigurationModel? = null

    fun setCurrentConfig(configuration: ConfigurationModel) {
        _config = configuration
    }

    fun getUrlFor(size: Size): String {
        return _config!!.baseUrl + size.raw()
    }

    companion object {

        private var _instance: ImageUrlProvider? = null

        fun sharedInstance(): ImageUrlProvider {
            if (_instance == null) {
                _instance = ImageUrlProvider()
            }

            return _instance as ImageUrlProvider
        }
    }
}
