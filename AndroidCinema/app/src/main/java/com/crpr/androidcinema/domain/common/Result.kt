package com.crpr.androidcinema.domain.common

/**
 * Created by cribeiro on 14/01/2016.
 */
open class Result {
    private val _resultStatusCode: Int
    private var _message: String? = null

    constructor(statusCode: Int) {
        _resultStatusCode = statusCode
        _message = ""
    }

    constructor(statusCode: Int, message: String) {
        _resultStatusCode = statusCode
        _message = message
    }

    val message: String
        get() = if (_message == null) "" else _message!!

    fun hasError(): Boolean {
        return this._resultStatusCode == ERROR
    }

    companion object {

        val OK = 1
        val ERROR = 2
    }
}
