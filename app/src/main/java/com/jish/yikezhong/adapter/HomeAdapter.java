package com.jish.yikezhong.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2017/12/15.
 */

public class HomeAdapter extends FragmentPagerAdapter{
    List<Fragment>fragment;
    List<String>list;

    public HomeAdapter(FragmentManager fm, List<Fragment> fragment) {
        super(fm);
        this.fragment = fragment;
    }
    public void setData(ArrayList<Fragment> fragment) {
        this.fragment = fragment;
    }
    public void setTabs(ArrayList<String> list) {
        this.list = list;
    }
    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return  list.get(position);
    }
}
