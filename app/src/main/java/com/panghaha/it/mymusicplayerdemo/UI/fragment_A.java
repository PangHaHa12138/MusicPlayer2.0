package com.panghaha.it.mymusicplayerdemo.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.adapter.CommonPagerAdapter;
import com.panghaha.it.mymusicplayerdemo.widget.CardSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * ━━━━ Code is far away from ━━━━━━
 * 　　  () 　　　  ()
 * 　　  ( ) 　　　( )
 * 　　  ( ) 　　　( )
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━ bug with the more protecting ━━━
 * <p/>
 * Created by PangHaHa12138 on 2017/6/25.
 */
public class fragment_A extends Fragment {

    private View mview;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CommonPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mview = inflater.inflate(R.layout.fragment_a, container, false);
        tabLayout = (TabLayout) mview.findViewById(R.id.tablayout);
        viewPager = (ViewPager) mview.findViewById(R.id.viewpager);
        init();

        return mview;
    }

    private void init() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new fragment_tab());
        fragments.add(new fragment_tab());
        fragments.add(new fragment_tab());

        ArrayList<String> strings = new ArrayList<>();
        strings.add("推荐");
        strings.add("朋友");
        strings.add("电台");
        adapter = new CommonPagerAdapter(getFragmentManager(),fragments,strings);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }




}
