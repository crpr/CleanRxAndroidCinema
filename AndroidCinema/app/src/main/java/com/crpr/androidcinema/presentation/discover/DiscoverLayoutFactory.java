package com.crpr.androidcinema.presentation.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crpr.androidcinema.R;
import com.crpr.androidcinema.domain.discover.ListMovieModel;
import com.crpr.androidcinema.presentation.common.adapter.BaseViewHolder;
import com.crpr.androidcinema.presentation.common.adapter.CoreLayoutFactory;
import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener;

/**
 * Created by claudioribeiro on 22/08/16.
 */
public class DiscoverLayoutFactory implements CoreLayoutFactory<ListMovieModel> {

    @Override
    public BaseViewHolder<ListMovieModel> build(Context context, ViewGroup parent, int viewType,
                                                RecyclerItemTouchListener listener) {

        View rootView;

        switch (viewType){
            case DiscoverViewHolder.Movie.MOVIE_TYPE:
                rootView = LayoutInflater.from(context)
                        .inflate(R.layout.layout_movie_discover_item, parent, false);
                return DiscoverViewHolder.Movie.getInstance(rootView, listener);
            case DiscoverViewHolder.TopMovie.TOP_MOVIE_TYPE:
                rootView = LayoutInflater.from(context)
                        .inflate(R.layout.layout_top_movie_discover_item, parent, false);
                return DiscoverViewHolder.TopMovie.getInstance(rootView, listener);

            default:
                return null;
        }
    }
}
