package com.silmood.movieman.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.silmood.movieman.R;
import com.silmood.movieman.model.Movie;

import java.util.List;

/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Created by Pedro Hernández on 11/2015.
 */
public class TheatersMoviesAdapter extends RecyclerView.Adapter<TheatersMoviesAdapter.MovieViewHolder>{

    private Context mContext;
    private List<Movie> mMovies;

    public TheatersMoviesAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(mContext).inflate(R.layout.item_theater_movie, parent, false);

        return new MovieViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = mMovies.get(position);

        holder.bindMovie(movie);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPosterImage;
        private TextView mTitle;
        private TextView mDuration;
        private TextView mRating;

        public MovieViewHolder(View itemView) {
            super(itemView);

            mPosterImage = (ImageView) itemView.findViewById(R.id.image_movie);
            mTitle = (TextView) itemView.findViewById(R.id.label_name);
            mDuration = (TextView) itemView.findViewById(R.id.label_duration);
            mRating = (TextView) itemView.findViewById(R.id.label_rating);
        }

        public void bindMovie(Movie movie) {
            mTitle.setText(movie.getTitle());

            String durationFormatted = String.format(mContext.getString(R.string.format_duration), movie.getRuntime());
            mDuration.setText(durationFormatted);

            String ratingFormatted = String.format(mContext.getString(R.string.format_rating),movie.getMetascore());
            mRating.setText(ratingFormatted);

            Glide.with(mContext)
                    .load(movie.getUrlPoster())
                    .into(mPosterImage);

        }
    }
}
