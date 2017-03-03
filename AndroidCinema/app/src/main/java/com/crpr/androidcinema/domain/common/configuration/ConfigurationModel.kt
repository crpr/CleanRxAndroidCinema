package com.crpr.androidcinema.domain.common.configuration

/**
 * Created by claudioribeiro on 09/07/16.
 */
class ConfigurationModel private constructor() {

    var baseUrl: String? = null
        private set
    var secureBaseUrl: String? = null
        private set

    interface ISecureUrl {
        fun secureUrl(url: String): IBuild
    }

    interface IBuild {
        fun build(): ConfigurationModel
    }

    private class Builder(url: String) : ISecureUrl, IBuild {

        private val instance = ConfigurationModel()

        init {
            instance.baseUrl = url
        }

        override fun build(): ConfigurationModel {
            return instance
        }

        override fun secureUrl(url: String): IBuild {
            instance.secureBaseUrl = url
            return this
        }
    }

    companion object {

        val BACKDROP = 1
        val LOGO = 2
        val POSTER = 3
        val PROFILE = 4
        val STILL = 5

        fun url(url: String): ISecureUrl {
            return ConfigurationModel.Builder(url)
        }
    }

}