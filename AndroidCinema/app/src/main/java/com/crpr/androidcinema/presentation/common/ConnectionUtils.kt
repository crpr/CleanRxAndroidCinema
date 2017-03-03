package com.crpr.androidcinema.presentation.common

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by DEATH_STAR on 21/01/2017.
 */

object ConnectionUtils {

    fun isConnectionAvailable(context: Context): Boolean {
        val networkTypes = intArrayOf(ConnectivityManager.TYPE_MOBILE, ConnectivityManager.TYPE_WIFI)
        try {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            for (networkType in networkTypes) {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.type == networkType)
                    return true
            }
        } catch (e: Exception) {
            return false
        }

        return false
    }

}
