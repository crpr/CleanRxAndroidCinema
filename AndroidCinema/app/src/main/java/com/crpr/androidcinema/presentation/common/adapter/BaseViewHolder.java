package com.crpr.androidcinema.presentation.common.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener;

/**
 * Created by claudioribeiro on 22/08/16.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView, RecyclerItemTouchListener listener) {
        super(itemView);
        bindListener(itemView, listener);
    }

    private void bindListener(View itemView, final RecyclerItemTouchListener recyclerClickListener) {
        itemView.setOnClickListener(v ->
                recyclerClickListener.onTouch(itemView, getLayoutPosition()));
    }

    public abstract void render(T model, Context context);
}
