package com.silmood.movieman.rest.response;

import com.silmood.movieman.model.Movie;

import java.util.ArrayList;
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
public class MoviesResponse {

    private Data data;

    public List<Movie> getMovies() {
        List<Movie> allMovies = new ArrayList<>();

        for (InTheaters inTheater : data.inTheaters) {
            allMovies.addAll(inTheater.movies);
        }

        return allMovies;
    }

    private class Data {
        private List<InTheaters> inTheaters;
    }

    private class InTheaters {
        String date;
        List<Movie> movies;
    }
}
