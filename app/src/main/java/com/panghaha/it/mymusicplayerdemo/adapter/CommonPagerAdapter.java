package com.panghaha.it.mymusicplayerdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hezhiqiang on 2017/12/27.
 * 通用pagerAdapter
 */

public class CommonPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> titleList;

    public CommonPagerAdapter(FragmentManager fm, List<Fragment> list, List<String> titles) {
        super(fm);
        fragmentList = list;
        titleList = titles;
        if(fragmentList == null)
            fragmentList = new ArrayList<>();
        if(titleList == null)
            titleList = new ArrayList<>();

        if(fragmentList.size() != titleList.size())
            throw new RuntimeException("Fragments与titles数量不一致！");
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(titleList != null && titleList.size() > 0)
            return titleList.get(position);
        return super.getPageTitle(position);
    }

}
