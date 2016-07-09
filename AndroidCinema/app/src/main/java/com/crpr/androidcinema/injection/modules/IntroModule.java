package com.crpr.androidcinema.injection.modules;

import com.crpr.androidcinema.domain.common.configuration.GetConfiguration;
import com.crpr.androidcinema.domain.splash.Splash;
import com.crpr.androidcinema.domain.splash.SplashInteractor;
import com.crpr.androidcinema.domain.splash.SplashNavigator;
import com.crpr.androidcinema.presentation.splash.SplashPresenter;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;

/**
 * Created by claudioribeiro on 09/07/16.
 */
@Module
public class IntroModule {

    /************************* PRESENTER *******************************/
    @Provides
    Splash.Presenter provideSplashPresenter(Splash.Interactor interactor){
        return new SplashPresenter(interactor);
    }

    /************************* INTERACTOR *******************************/
    @Provides
    Splash.Interactor provideSplashInteractor(@Named("marvel_main_thread") Scheduler mainThread,
                                                        @Named("marvel_executor_thread") Scheduler executorThread,
                                                        GetConfiguration.Process process){
        return new SplashInteractor(mainThread, executorThread, process);
    }

    /************************* PRESENTER *******************************/
    @Provides
    @Singleton
    Splash.Navigator provideSplashNavigator(){
        return new SplashNavigator();
    }
}
