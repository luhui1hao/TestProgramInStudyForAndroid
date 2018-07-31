package com.example.luhui1hao.viewpagertest.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.luhui1hao.viewpagertest.fragment.ImageFragment;

import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    List<ImageFragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, List<ImageFragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
