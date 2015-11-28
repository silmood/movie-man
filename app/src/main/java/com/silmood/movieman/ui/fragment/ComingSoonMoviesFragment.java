package com.silmood.movieman.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silmood.movieman.rest.MoviesApiClient;
import com.silmood.movieman.rest.response.MoviesResponse;
import com.silmood.movieman.ui.adapter.ComingSoonMoviesAdapter;
import com.silmood.movieman.R;
import com.silmood.movieman.ui.util.SimpleOffsetDecorator;
import com.silmood.movieman.model.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComingSoonMoviesFragment extends Fragment {


    public static final int SPAN_COUNT = 2;

    private RecyclerView mMoviesList;
    private ComingSoonMoviesAdapter mMoviesAdapter;

    public ComingSoonMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_theaters_movies, container, false);

        mMoviesList = (RecyclerView) view.findViewById(R.id.list_theaters_movies);
        mMoviesList.setLayoutManager(new GridLayoutManager(getActivity(), SPAN_COUNT));
        mMoviesList.addItemDecoration(new SimpleOffsetDecorator(getActivity(), R.integer.offset));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchMovies();
    }

    private void fetchMovies() {
        MoviesApiClient.getInstance(getContext().getApplicationContext())
                .getComingSoonResponse(new Callback<MoviesResponse>() {
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

    private void updateUi(List<Movie> movies) {

        if (mMoviesAdapter == null) {
            mMoviesAdapter = new ComingSoonMoviesAdapter(getActivity(), movies);
            mMoviesList.setAdapter(mMoviesAdapter);
        }

        else {
            mMoviesAdapter.setMovies(movies);
            mMoviesAdapter.notifyDataSetChanged();
        }
    }

}
