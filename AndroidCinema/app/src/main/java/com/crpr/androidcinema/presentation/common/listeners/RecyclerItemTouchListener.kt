package com.crpr.androidcinema.presentation.common.listeners

import android.view.View

interface RecyclerItemTouchListener {
    fun onTouch(view: View, position: Int)
}
