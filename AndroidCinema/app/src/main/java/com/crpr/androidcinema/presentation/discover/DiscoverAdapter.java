package com.crpr.androidcinema.presentation.discover;

import android.content.Context;

import com.crpr.androidcinema.domain.discover.ListMovieModel;
import com.crpr.androidcinema.presentation.common.adapter.CoreAdapter;
import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener;

import java.util.List;

/**
 * Created by claudioribeiro on 16/07/16.
 */
public class DiscoverAdapter extends CoreAdapter<ListMovieModel> {

    public DiscoverAdapter(Context context, List<ListMovieModel> models, RecyclerItemTouchListener listener) {
        super(context, new DiscoverLayoutFactory(), models, listener);
    }

    @Override
    public int getItemViewType(int position) {
        return getItemByPosition(position).getVoteAverage() < 7.0 ?
                DiscoverViewHolder.Movie.MOVIE_TYPE :
                DiscoverViewHolder.TopMovie.TOP_MOVIE_TYPE;
    }

}
