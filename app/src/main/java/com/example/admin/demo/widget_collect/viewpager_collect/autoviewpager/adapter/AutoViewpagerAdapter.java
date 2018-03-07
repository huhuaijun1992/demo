package com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.demo.R;

/**
 * Created by admin on 2017/4/5.
 */

public class AutoViewpagerAdapter extends PagerAdapter {

     private String [] strings={};
    private Activity activity;

    public AutoViewpagerAdapter(String[] strings, Activity activity) {
        this.strings = strings;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        if (strings.length > 1) {
            return Integer.MAX_VALUE;
        }
        return strings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
           View view= LayoutInflater.from(activity).inflate(R.layout.viewpageradapter_layout,null);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View)object);
    }
}
