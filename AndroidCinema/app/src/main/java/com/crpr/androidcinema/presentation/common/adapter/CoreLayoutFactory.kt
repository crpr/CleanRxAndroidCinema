package com.crpr.androidcinema.presentation.common.adapter

import android.content.Context
import android.view.ViewGroup

import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener

/**
 * Created by claudioribeiro on 22/08/16.
 */
interface CoreLayoutFactory<T> {
    fun build(context: Context, parent: ViewGroup, viewType: Int,
              listener: RecyclerItemTouchListener): BaseViewHolder<T>
}
