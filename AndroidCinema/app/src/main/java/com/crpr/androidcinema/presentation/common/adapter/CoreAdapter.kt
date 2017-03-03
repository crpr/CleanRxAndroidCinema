package com.crpr.androidcinema.presentation.common.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener
import java.util.*

/**
 * Created by claudioribeiro on 22/08/16.
 */
abstract class CoreAdapter<T>(private val context: Context, private val factory: CoreLayoutFactory<T>, private var models: MutableList<T>?,
                              private val listener: RecyclerItemTouchListener) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return factory.build(context, parent, viewType, listener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.render(models!![position], context)
    }

    override fun getItemCount(): Int {
        return models!!.size
    }

    fun getItemByPosition(position: Int): T {
        return models!![position]
    }

    fun updateItems(newItems: List<T>) {
        if (models == null) {
            models = ArrayList<T>()
        } else {
            models!!.clear()
        }

        models!!.addAll(newItems)
    }
}
