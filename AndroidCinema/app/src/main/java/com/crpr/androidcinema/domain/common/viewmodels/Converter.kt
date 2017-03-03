package com.crpr.androidcinema.domain.common.viewmodels

interface Converter<out M, in T> {
    fun mapTo(parseObject: T): M
}
