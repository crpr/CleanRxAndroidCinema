package com.crpr.androidcinema.presentation.common

import rx.subscriptions.CompositeSubscription

/**
 * Created by claudioribeiro on 08/07/16.
 */
abstract class Presenter : Base.Presenter {

    protected var _isMakingRequest: Boolean = false
    protected var _subscriptions: CompositeSubscription? = CompositeSubscription()

    //This methods should map to activities lifecycle

    open fun onCreate() {}

    override fun onStart() {}

    fun onStop() {}

    override fun onPause() {}

    override fun onDestroy() {
        if (_subscriptions != null && _subscriptions!!.hasSubscriptions()) {
            _subscriptions!!.unsubscribe()
            _subscriptions = null
        }
    }

    abstract override fun bindView(view: Base.View)

}
