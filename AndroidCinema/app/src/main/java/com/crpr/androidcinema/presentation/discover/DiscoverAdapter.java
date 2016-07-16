package com.crpr.androidcinema.presentation.discover;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crpr.androidcinema.R;
import com.crpr.androidcinema.domain.discover.ListMovieModel;
import com.crpr.androidcinema.presentation.common.listeners.RecyclerItemTouchListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by claudioribeiro on 16/07/16.
 */
public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.DiscoverMovieViewholder>{

    private final Context _context;
    private List<ListMovieModel> _models;
    private final RecyclerItemTouchListener _listener;

    public DiscoverAdapter(Context context, List<ListMovieModel> models, RecyclerItemTouchListener listener){
        this._context = context;
        _models = new ArrayList<>(models);
        this._listener = listener;
    }

    @Override
    public DiscoverMovieViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(_context).inflate(
                R.layout.layout_movie_discover_item, parent, false);

        return new DiscoverMovieViewholder(rootView, _listener);
    }

    @Override
    public int getItemCount() {
        return this._models.size();
    }

    @Override
    public void onBindViewHolder(DiscoverMovieViewholder holder, int position) {
        holder.render(_models.get(position), _context);
    }

    static class DiscoverMovieViewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.discover_title)
        TextView title;

        @BindView(R.id.discover_rating)
        TextView rating;

        @BindView(R.id.discover_poster_image)
        ImageView poster;

        public DiscoverMovieViewholder(View itemView, final RecyclerItemTouchListener recyclerClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            bindListener(itemView, recyclerClickListener);
        }

        private void bindListener(View itemView, final RecyclerItemTouchListener recyclerClickListener) {
            itemView.setOnClickListener(v ->
                    recyclerClickListener.onTouch(itemView, getLayoutPosition()));
        }

        public void render(ListMovieModel model, Context context){
            if(model == null){
                return;
            }

            this.title.setText(model.getTitle());
            this.rating.setText(String.valueOf(model.getVoteAverage()));

            Glide.with(context)
                    .load(model.getPosterPath())
                    .fitCenter()
                    .crossFade()
                    .into(this.poster);
        }
    }

}
