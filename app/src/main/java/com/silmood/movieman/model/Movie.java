package com.silmood.movieman.model;

/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Created by Pedro Hernández on 11/2015.
 */
public class Movie {

    private String title;
    private String runtime;
    private String metascore;
    private String urlPoster;
    private String mReleaseDate;

    public Movie(String title, String runtime, String metascore, String urlPoster) {
        this.title = title;
        this.runtime = runtime;
        this.metascore = metascore;
        this.urlPoster = urlPoster;
    }

    public Movie(String title, String releaseDate) {
        this.title = title;
        mReleaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public void setUrlPosters(String urlPoster) {
        this.urlPoster = urlPoster;
    }

    public Object getReleaseDate() {
        return mReleaseDate;
    }
}
