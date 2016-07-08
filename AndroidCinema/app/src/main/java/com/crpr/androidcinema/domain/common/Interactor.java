package com.crpr.androidcinema.domain.common;

import rx.Scheduler;

/**
 * Created by cribeiro on 23/05/2016.
 */
public abstract class Interactor {

    protected final Scheduler _mainThread;
    protected final Scheduler _executorThread;

    public Interactor(Scheduler mainThread, Scheduler executorThread) {
        _mainThread = mainThread;
        _executorThread = executorThread;
    }
}
