package com.dataction.petvet.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dataction.petvet.R;
import com.dataction.petvet.fragments.DashboardFragment;
import com.dataction.petvet.fragments.PetListFragment;

/**
 * Created by adiktz on 8/23/2015.
 */
public class DashboardPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 4;
    private static Context context;

    public DashboardPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:{
                fragment = new PetListFragment();
                break;
            }
            default:{
                fragment = new DashboardFragment();
            }
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String [] pageTitle = context.getResources().getStringArray(R.array.dashboardPagerItems);
        return pageTitle[position];
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
