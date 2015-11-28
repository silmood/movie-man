package com.silmood.movieman.rest;

import android.content.Context;

import com.silmood.movieman.rest.response.MoviesResponse;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

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
public class MoviesApiClient {

    private static final String ACCESS_TOKEN = "68552c20-bd0a-442c-8f88-6b0863711384";

    private static MoviesApiClient ourInstance;
    private MoviesApiService mApiService;

    public static MoviesApiClient getInstance(Context context) {
        if (ourInstance == null)
            ourInstance = new MoviesApiClient(context);

        return ourInstance;
    }

    private MoviesApiClient(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.myapifilms.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiService = retrofit.create(MoviesApiService.class);
    }

    public void getComingSoonResponse(Callback<MoviesResponse> callback){
        Call<MoviesResponse> call = mApiService.getComingSoonMovies(ACCESS_TOKEN, "es-mx");
        call.enqueue(callback);
    }

    public void getInTheatersMovies(Callback<MoviesResponse> callback){
        Call<MoviesResponse> call = mApiService.getInTheatersMovies(ACCESS_TOKEN, "es-mx");
        call.enqueue(callback);
    }
}
