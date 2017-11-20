package com.example.jose.heartbits;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Samuel on 19/11/2017.
 */

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Cama> camas;

    public MyFragmentPageAdapter(FragmentManager fm , ArrayList<Cama> camas){
        super(fm);
        this.camas=camas;
    }

    @Override
    public Fragment getItem(int position) {
        if(position > camas.size())
            return null;
        return new CamaFragment(camas.get(position-1));
    }

    @Override
    public int getCount() {
        return this.camas.size();
    }
}
