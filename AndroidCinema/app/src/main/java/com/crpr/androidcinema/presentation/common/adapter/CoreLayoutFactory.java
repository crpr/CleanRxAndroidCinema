package com.crpr.androidcinema.presentation.common.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener;

/**
 * Created by claudioribeiro on 22/08/16.
 */
public interface CoreLayoutFactory<T> {
    BaseViewHolder<T> build(Context context, ViewGroup parent, int viewType,
                            RecyclerItemTouchListener listener);
}
