package com.crpr.androidcinema.presentation.common

/**
 * Created by claudioribeiro on 10/07/16.
 */
interface Base {

    interface View {
        fun showError(message: String)
        fun showNoConnection()
    }

    interface Presenter {
        fun onError(throwable: Throwable)
        fun onStart()
        fun onPause()
        fun onDestroy()
        fun bindView(view: View)
    }
}
