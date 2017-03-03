package com.crpr.androidcinema.presentation.common.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View

import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener

/**
 * Created by claudioribeiro on 22/08/16.
 */
abstract class BaseViewHolder<in T>(itemView: View, listener: RecyclerItemTouchListener) : RecyclerView.ViewHolder(itemView) {

    init {
        bindListener(itemView, listener)
    }

    private fun bindListener(itemView: View, recyclerClickListener: RecyclerItemTouchListener) {
        itemView.setOnClickListener { recyclerClickListener.onTouch(itemView, layoutPosition) }
    }

    abstract fun render(model: T, context: Context)
}
