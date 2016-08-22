package com.crpr.androidcinema.presentation.discover;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.crpr.androidcinema.R;
import com.crpr.androidcinema.domain.discover.ListMovieModel;
import com.crpr.androidcinema.presentation.common.adapter.BaseViewHolder;
import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by claudioribeiro on 22/08/16.
 */
public class DiscoverViewHolder {

    static class Movie extends BaseViewHolder<ListMovieModel> {

        public static final int MOVIE_TYPE = 0;

        @BindView(R.id.discover_title)
        TextView title;

        @BindView(R.id.discover_rating)
        TextView rating;

        @BindView(R.id.discover_poster_image)
        ImageView poster;

        public Movie(View itemView, final RecyclerItemTouchListener recyclerClickListener) {
            super(itemView, recyclerClickListener);
            ButterKnife.bind(this, itemView);
        }

        public void render(ListMovieModel model, Context context){
            if(model == null){
                return;
            }

            this.title.setText(model.getTitle());
            this.rating.setText(String.valueOf(model.getVoteAverage()));

            Picasso.with(context)
                    .load(model.getImagePath())
                    .fit()
                    .centerCrop()
                    .into(this.poster);
        }

        public static Movie getInstance(View view, RecyclerItemTouchListener listener){
            return new Movie(view, listener);
        }
    }

    static class TopMovie extends Movie {

        public static final int TOP_MOVIE_TYPE = 1;

        @BindView(R.id.discover_title)
        TextView title;

        @BindView(R.id.discover_rating)
        TextView rating;

        @BindView(R.id.discover_poster_image)
        ImageView poster;

        @BindView(R.id.discover_star_image)
        ImageView start;

        public TopMovie(View itemView, final RecyclerItemTouchListener recyclerClickListener) {
            super(itemView, recyclerClickListener);
        }

        public static TopMovie getInstance(View view, RecyclerItemTouchListener listener){
            return new TopMovie(view, listener);
        }
    }
}
