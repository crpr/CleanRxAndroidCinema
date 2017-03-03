package com.crpr.androidcinema.injection.modules

import android.content.Context
import com.crpr.androidcinema.data.preferences.PreferencesService
import com.crpr.androidcinema.domain.common.configuration.GetConfiguration
import com.crpr.androidcinema.domain.splash.Splash
import com.crpr.androidcinema.domain.splash.SplashInteractor
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizard
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardInteractor
import com.crpr.androidcinema.domain.welcome_wizard.WelcomeWizardProcess
import com.crpr.androidcinema.presentation.splash.SplashNavigator
import com.crpr.androidcinema.presentation.splash.SplashPresenter
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardNavigator
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardPresenter
import com.crpr.androidcinema.presentation.welcome_wizard.WelcomeWizardStepsGenerator
import dagger.Module
import dagger.Provides
import rx.Scheduler
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by claudioribeiro on 09/07/16.
 */
@Module
class IntroModule {

    /************************* PRESENTER  */
    @Provides
    internal fun provideSplashPresenter(interactor: Splash.Interactor): Splash.Presenter {
        return SplashPresenter(interactor)
    }

    @Provides
    internal fun provideWelcomeWizardPresenter(generator: WelcomeWizardStepsGenerator,
                                               interactor: WelcomeWizard.Interactor): WelcomeWizard.Presenter {
        return WelcomeWizardPresenter(generator, interactor)
    }

    /************************* INTERACTOR  */
    @Provides
    internal fun provideSplashInteractor(@Named("cinema_main_thread") mainThread: Scheduler,
                                         @Named("cinema_executor_thread") executorThread: Scheduler,
                                         process: GetConfiguration.Process,
                                         wwProcess: WelcomeWizard.Process): Splash.Interactor {
        return SplashInteractor(mainThread, executorThread, process, wwProcess)
    }

    @Provides
    internal fun provideWelcomeWizardInteractor(@Named("cinema_main_thread") mainThread: Scheduler,
                                                @Named("cinema_executor_thread") executorThread: Scheduler,
                                                process: WelcomeWizard.Process): WelcomeWizard.Interactor {
        return WelcomeWizardInteractor(mainThread, executorThread, process)
    }

    /************************* NAVIGATOR  */
    @Provides
    @Singleton
    internal fun provideSplashNavigator(): Splash.Navigator {
        return SplashNavigator()
    }

    @Provides
    @Singleton
    internal fun provideWelcomeWizardNavigator(): WelcomeWizard.Navigator {
        return WelcomeWizardNavigator()
    }

    /************************* PROCESS  */
    @Provides
    internal fun provideWelcomeWizardProcess(appPreferences: PreferencesService): WelcomeWizard.Process {
        return WelcomeWizardProcess(appPreferences)
    }

    /************************* GENERATORS  */

    @Provides
    @Singleton
    internal fun provideWelcomeWizardStepsGenerator(context: Context): WelcomeWizardStepsGenerator {
        return WelcomeWizardStepsGenerator(context)
    }
}
