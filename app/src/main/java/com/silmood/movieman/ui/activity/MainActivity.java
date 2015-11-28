package com.silmood.movieman.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.silmood.movieman.R;
import com.silmood.movieman.ui.adapter.MoviesPagerAdapter;
import com.silmood.movieman.ui.fragment.ComingSoonMoviesFragment;
import com.silmood.movieman.ui.fragment.TheatersMoviesFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager();

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TheatersMoviesFragment());
        fragments.add(new ComingSoonMoviesFragment());

        MoviesPagerAdapter adapter = new MoviesPagerAdapter(getSupportFragmentManager(), fragments, this);
        mViewPager.setAdapter(adapter);
    }
}
