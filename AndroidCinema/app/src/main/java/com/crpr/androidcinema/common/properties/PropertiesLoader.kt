package com.crpr.androidcinema.common.properties

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import com.crpr.androidcinema.BuildConfig
import java.util.*

/**
 * Created by cribeiro on 12-09-2015.
 */
class PropertiesLoader(context: Context) {

    private val _envToken = "[ENV]"
    private var _configFile = "configuration-$_envToken.properties"
    private var _properties: Properties? = null

    init {
        loadProperties(context)
    }

    private fun getConfiguration(ctx: Context): String {
        try {
            val ai = ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)
            val bundle = ai.metaData
            val environment = bundle.getString("environment")
            Log.d("LOADED_ENVIRONMENT", " VAL = " + environment!!)
            return environment
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return ""
    }

    fun loadProperties(ctx: Context) {
        try {
            _properties = Properties()
            _configFile = _configFile.replace(_envToken, getConfiguration(ctx))
            val inputStream = PropertiesLoader::class.java.classLoader.getResourceAsStream(_configFile)
            _properties!!.load(inputStream)
            if (BuildConfig.DEBUG) {
                printLoadedConfiguration()
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            throw RuntimeException(ex)
        }
    }

    private fun printLoadedConfiguration() {
        Log.d(API_BASE_URL, " = " + getProperty(API_BASE_URL))
        Log.d(API_KEY, " = " + getProperty(API_KEY))
    }

    fun getProperty(property: String): String {
        return _properties!!.getProperty(property)
    }

    companion object {
        val API_BASE_URL = "api.base_url"
        val API_KEY = "api.key"
    }
}
