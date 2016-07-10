package com.crpr.androidcinema.injection.modules;

import android.content.Context;

import com.crpr.androidcinema.data.preferences.PreferencesService;
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration;
import com.crpr.androidcinema.domain.common.configuration.GetConfigurationProcess;
import com.crpr.androidcinema.domain.splash.Splash;
import com.crpr.androidcinema.domain.splash.SplashInteractor;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizard;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardInteractor;
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardProcess;
import com.crpr.androidcinema.presentation.splash.SplashNavigator;
import com.crpr.androidcinema.presentation.splash.SplashPresenter;
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardNavigator;
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardPresenter;
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardStepsGenerator;

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

    @Provides
    WelcomeWizard.Presenter provideWelcomeWizardPresenter(WelcomeWizardStepsGenerator generator,
                                                          WelcomeWizard.Interactor interactor){
        return new WelcomeWizardPresenter(generator, interactor);
    }

    /************************* INTERACTOR *******************************/
    @Provides
    Splash.Interactor provideSplashInteractor(@Named("marvel_main_thread") Scheduler mainThread,
                                                @Named("marvel_executor_thread") Scheduler executorThread,
                                                GetConfiguration.Process process){
        return new SplashInteractor(mainThread, executorThread, process);
    }

    @Provides
    WelcomeWizard.Interactor provideWelcomeWizardInteractor(@Named("marvel_main_thread") Scheduler mainThread,
                                                @Named("marvel_executor_thread") Scheduler executorThread,
                                                WelcomeWizard.Process process){
        return new WelcomeWizardInteractor(mainThread, executorThread, process);
    }

    /************************* NAVIGATOR *******************************/
    @Provides
    @Singleton
    Splash.Navigator provideSplashNavigator(){
        return new SplashNavigator();
    }

    @Provides
    @Singleton
    WelcomeWizard.Navigator provideWelcomeWizardNavigator(){
        return new WelcomeWizardNavigator();
    }

    /************************* PROCESS *******************************/
    @Provides
    WelcomeWizard.Process provideWelcomeWizardProcess(PreferencesService preferencesService){
        return new WelcomeWizardProcess(preferencesService);
    }

    /************************* GENERATORS *******************************/

    @Provides
    @Singleton
    WelcomeWizardStepsGenerator provideWelcomeWizardStepsGenerator(Context context){
        return new WelcomeWizardStepsGenerator(context);
    }
}
