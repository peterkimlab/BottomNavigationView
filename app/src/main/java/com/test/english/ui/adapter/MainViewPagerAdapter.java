package com.test.english.ui.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    public List<Fragment> mFragmentList = new ArrayList<>();

    public MainViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }
}
