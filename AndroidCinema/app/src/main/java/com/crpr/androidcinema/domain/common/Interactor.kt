package com.crpr.androidcinema.domain.common

import rx.Scheduler

/**
 * Created by cribeiro on 23/05/2016.
 */
abstract class Interactor(protected val _mainThread: Scheduler, protected val _executorThread: Scheduler)
