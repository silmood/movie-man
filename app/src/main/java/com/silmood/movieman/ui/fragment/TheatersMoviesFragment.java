package com.silmood.movieman.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silmood.movieman.R;
import com.silmood.movieman.rest.MoviesApiClient;
import com.silmood.movieman.rest.response.MoviesResponse;
import com.silmood.movieman.ui.adapter.TheatersMoviesAdapter;
import com.silmood.movieman.model.Movie;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class TheatersMoviesFragment extends Fragment {

    private RecyclerView mMoviesList;
    private TheatersMoviesAdapter mMoviesAdapter;

    public TheatersMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_theaters_movies, container, false);

        mMoviesList = (RecyclerView) view.findViewById(R.id.list_theaters_movies);
        mMoviesList.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchMovies();
    }

    private void updateUi(List<Movie> movies) {

        if (mMoviesAdapter == null) {
            mMoviesAdapter = new TheatersMoviesAdapter(getActivity(), movies);
            mMoviesList.setAdapter(mMoviesAdapter);
        }

        else {
            mMoviesAdapter.setMovies(movies);
            mMoviesAdapter.notifyDataSetChanged();
        }
    }

    public void fetchMovies() {
        MoviesApiClient.getInstance(getContext().getApplicationContext())
                .getInTheatersMovies(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Response<MoviesResponse> response, Retrofit retrofit) {
                        updateUi(response.body().getMovies());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
