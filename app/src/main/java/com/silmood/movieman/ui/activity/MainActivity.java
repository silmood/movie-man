package com.silmood.movieman.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.silmood.movieman.R;
import com.silmood.movieman.ui.fragment.ComingSoonMoviesFragment;
import com.silmood.movieman.ui.fragment.TheatersMoviesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);

        if (fragment == null){
            fm.beginTransaction()
                    .add(R.id.container, new TheatersMoviesFragment())
                    .commit();
        }
    }
}
