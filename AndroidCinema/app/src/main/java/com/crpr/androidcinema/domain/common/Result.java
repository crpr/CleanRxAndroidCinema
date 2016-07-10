package com.crpr.androidcinema.domain.common;

/**
 * Created by cribeiro on 14/01/2016.
 */
public class Result {

    public static final int OK = 1;
    public static final int ERROR = 2;
    private final int _resultStatusCode;
    private String _message;

    public Result(int statusCode){
        _resultStatusCode = statusCode;
        _message = "";
    }

    public Result(int statusCode, String message){
        _resultStatusCode = statusCode;
        _message = message;
    }

    public String getMessage(){
        return _message == null ? "" : _message;
    }

    public boolean hasError(){
        return this._resultStatusCode == ERROR;
    }
}
