package com.crpr.androidcinema.data.api.responses

import java.io.Serializable

/**
 * Created by cribeiro on 23/05/2016.
 */
class ApiResponse<T> : Serializable {
    var page: Int = 0
    var totalPages: Int = 0
    var totalResults: Int = 0
    var results: List<T>? = null
}
