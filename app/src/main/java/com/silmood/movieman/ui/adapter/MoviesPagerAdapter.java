package com.silmood.movieman.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;

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
public class MoviesPagerAdapter extends FragmentPagerAdapter{

    List<Fragment> mFragments;
    Context mContext;

    public MoviesPagerAdapter(FragmentManager fm, List<Fragment> fragments, Context context) {
        super(fm);
        mFragments = fragments;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Fragment currentFragment = mFragments.get(position);

        if (currentFragment instanceof PagerTitle) {
            int stringId = ((PagerTitle) currentFragment).getTitleStringId();
            return mContext.getString(stringId);
        }

        return super.getPageTitle(position);
    }

    public interface PagerTitle {
        int getTitleStringId();
    }
}
