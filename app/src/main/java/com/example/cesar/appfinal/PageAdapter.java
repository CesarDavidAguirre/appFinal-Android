package com.example.cesar.appfinal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Ing.Cesar on 19/03/2017.
 */


    public class PageAdapter extends FragmentStatePagerAdapter {
        int NumOfTabs = 0;
        public PageAdapter (FragmentManager fm, int NumTabs){
            super(fm);
            this.NumOfTabs = NumTabs;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Fragment_1 tab1 = new Fragment_1();
                    return tab1 ;
                case 1:
                    Fragment_2 tab2 = new Fragment_2();
                    return tab2 ;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return this.NumOfTabs;
        }
    }

