package com.crpr.androidcinema.data.api.factories;

import com.crpr.androidcinema.data.api.interceptors.AuthInterceptor;
import com.crpr.androidcinema.data.api.interceptors.LogInterceptor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.inject.Provider;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by claudioribeiro on 12/07/16.
 */
public class InterceptorsFactoryTest {

    private Provider<LogInterceptor> logProvider;
    private Provider<AuthInterceptor> authProvider;
    private Provider<HttpLoggingInterceptor> httpProvider;
    private InterceptorsFactory factory;

    @Before
    public void setup(){
        logProvider = (Provider<LogInterceptor>)Mockito.mock(Provider.class);
        authProvider = (Provider<AuthInterceptor>)Mockito.mock(Provider.class);
        httpProvider = (Provider<HttpLoggingInterceptor>)Mockito.mock(Provider.class);
        factory = new InterceptorsFactory(logProvider, authProvider, httpProvider);
    }

    @Test
    public void getLogInterceptorTest(){
        LogInterceptor rvalue = new LogInterceptor();

        when(logProvider.get()).thenReturn(rvalue);

        Interceptor result = factory.get(InterceptorsFactory.LOG);

        verify(logProvider, times(1)).get();
        verifyNoMoreInteractions(logProvider);
        verifyZeroInteractions(authProvider);
        verifyZeroInteractions(httpProvider);

        assertThat(result, notNullValue());
        assertEquals(result.getClass().getName(), LogInterceptor.class.getName());
    }

    @Test
    public void getAuthInterceptorTest(){
        String key = "2342342342342";

        AuthInterceptor rvalue = new AuthInterceptor(key);

        when(authProvider.get()).thenReturn(rvalue);

        Interceptor result = factory.get(InterceptorsFactory.AUTH);

        verify(authProvider, times(1)).get();
        verifyNoMoreInteractions(authProvider);
        verifyZeroInteractions(logProvider);
        verifyZeroInteractions(httpProvider);

        assertThat(result, notNullValue());
        assertEquals(result.getClass().getName(), AuthInterceptor.class.getName());
    }

    @Test
    public void getHttpInterceptorTest(){
        HttpLoggingInterceptor rvalue = new HttpLoggingInterceptor();

        when(httpProvider.get()).thenReturn(rvalue);

        Interceptor result = factory.get(InterceptorsFactory.HTTP);

        verify(httpProvider, times(1)).get();
        verifyNoMoreInteractions(httpProvider);
        verifyZeroInteractions(authProvider);
        verifyZeroInteractions(logProvider);

        assertThat(result, notNullValue());
        assertEquals(result.getClass().getName(), HttpLoggingInterceptor.class.getName());
    }

    @Test
    public void getNullInterceptorTest(){
        Interceptor result = factory.get(-1);
        assertThat(result, nullValue());
    }
}
