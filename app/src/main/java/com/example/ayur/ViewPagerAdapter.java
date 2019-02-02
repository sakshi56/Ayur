package com.example.ayur;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> fragmentlistTitle= new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentlistTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentlistTitle.get(position);
    }
    public void AddFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentlistTitle.add(title);
    }
}