package com.crpr.androidcinema.presentation.common.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudioribeiro on 22/08/16.
 */
public abstract class CoreAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    private final Context context;
    private final CoreLayoutFactory<T> factory;
    private List<T> models;
    private final RecyclerItemTouchListener listener;

    public CoreAdapter(Context context, CoreLayoutFactory<T> factory, List<T> models,
                       RecyclerItemTouchListener listener){
        this.context = context;
        this.factory = factory;
        this.models = models;
        this.listener = listener;
    }

    @Override
    public BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        return factory.build(context, parent, viewType, listener);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        holder.render(models.get(position), context);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public T getItemByPosition(int position){
        return models.get(position);
    }

    public void updateItems(List<T> newItems){
        if(models == null){
            models = new ArrayList<>();
        } else {
            models.clear();
        }

        models.addAll(newItems);
    }
}
