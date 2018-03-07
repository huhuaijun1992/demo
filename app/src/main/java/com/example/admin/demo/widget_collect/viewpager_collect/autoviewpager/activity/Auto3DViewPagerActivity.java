package com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.admin.demo.R;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.adapter.AutoViewpagerAdapter;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.transform.AlphaPageTransformer;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.transform.NonPageTransformer;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.transform.RotateDownPageTransformer;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.transform.RotateUpPageTransformer;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.transform.RotateYTransformer;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.transform.ScaleInTransformer;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.view.AutoScrollViewPager;

/**
 * Created by admin on 2017/4/5.
 */

public class Auto3DViewPagerActivity  extends Activity implements View.OnClickListener{
    private RelativeLayout layout;
    private AutoScrollViewPager viewPager;
    private AutoViewpagerAdapter adapter;
    private String[] strings={"andorid","ios","java","c","c#"};
    private Button button1,button2,button3,button4,button5,button6;

    @Override
    protected void onResume() {
        super.onResume();
        viewPager.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewPager.stopAutoScroll();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_3d_activity);
        findviewById();
        //此处一屏展示过个item的关键设置，父容器也要设置
        viewPager.setInterval(2000);
        // 滑动到第一个或最后一个Item的处理方式，支持没有任何操作、轮播以及传递到父View三种模式
        viewPager.setSlideBorderMode(1);
        adapter=new AutoViewpagerAdapter(strings,this);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        if (strings.length>1){
            viewPager.setCurrentItem(strings.length*500);
        }
        viewPager.setPageTransformer(true,new NonPageTransformer());
        //
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void findviewById() {
        viewPager=(AutoScrollViewPager)findViewById(R.id.viewpager);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        viewPager.setAdapter(adapter);
        switch (v.getId()){
            case R.id.button1:
                viewPager.setPageTransformer(true, new NonPageTransformer());
                break;
            case R.id.button2:
                viewPager.setPageTransformer(true,new RotateDownPageTransformer());
                break;
            case R.id.button3:
                viewPager.setPageTransformer(true,new RotateUpPageTransformer());
                break;
            case R.id.button4:
                viewPager.setPageTransformer(true,new RotateYTransformer());
                break;
            case R.id.button5:
                viewPager.setPageTransformer(true,new AlphaPageTransformer());
                break;
            case R.id.button6:
                viewPager.setPageTransformer(true,new ScaleInTransformer());
                break;
        }

    }
}
