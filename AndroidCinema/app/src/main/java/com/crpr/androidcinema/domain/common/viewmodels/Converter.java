package com.crpr.androidcinema.domain.common.viewmodels;

public interface Converter<M, T> {
    M map(T parseObject);
}
