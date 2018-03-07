package com.example.admin.demo.thridwidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;
import com.example.admin.demo.flowlayout.FlowLayoutActivity;
import com.example.admin.demo.permission.PerimissionActivity;
import com.example.admin.demo.thridwidget.adverment.AdvermentActivity;
import com.example.admin.demo.thridwidget.data_time.DataMainActivity;
import com.example.admin.demo.thridwidget.guid.aty.GuideHomeActivity;
import com.example.admin.demo.thridwidget.jiecaoplayer.JieCaoMainActivity;
import com.example.admin.demo.thridwidget.roll.IMageRollActivity;
import com.example.admin.demo.thridwidget.roll.TextRollActivity;
import com.example.admin.demo.thridwidget.slidinglayout.SlidingMainActivity;
import com.example.admin.demo.thridwidget.stepview.XiaoguoFragmentActivity;
import com.example.admin.demo.thridwidget.xtablayout.XtablayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by admin on 2017/7/4.
 */

public class ThirdWidgetCollectActivity extends Activity {
    @BindView(R.id.folwlayout)
    Button folwlayout;
    @BindView(R.id.stepview)
    Button stepview;
    @BindView(R.id.Dragview)
    Button Dragview;
    @BindView(R.id.perimission)
    Button perimission;
    @BindView(R.id.utils)
    Button utils;
    @BindView(R.id.data)
    Button data;
    @BindView(R.id.guide)
    Button guide;
    @BindView(R.id.xtablayout)
    Button xtablayout;
    @BindView(R.id.marquetext)
    Button marquetext;
    @BindView(R.id.marqueimage)
    Button marqueimage;
    @BindView(R.id.adverment)
    Button adverment;
    @BindView(R.id.player)
    Button player;
    @BindView(R.id.sliding)
    Button sliding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdwidgetlayout);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.sliding,R.id.player, R.id.adverment, R.id.marquetext, R.id.marqueimage, R.id.folwlayout, R.id.stepview, R.id.Dragview, R.id.perimission, R.id.utils, R.id.data, R.id.guide, R.id.xtablayout})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.folwlayout:
                intent.setClass(this, FlowLayoutActivity.class);
                break;
            case R.id.stepview:
                intent.setClass(this, XiaoguoFragmentActivity.class);
                break;
            case R.id.Dragview:
                break;
            case R.id.perimission:
                intent.setClass(this, PerimissionActivity.class);
                break;
            case R.id.utils:
                break;
            case R.id.data:
                intent.setClass(this, DataMainActivity.class);
                break;
            case R.id.guide:
                intent.setClass(this, GuideHomeActivity.class);
                break;
            case R.id.xtablayout:
                intent.setClass(this, XtablayoutActivity.class);
                break;
            case R.id.marquetext:
                intent.setClass(this, TextRollActivity.class);
                break;
            case R.id.marqueimage:
                intent.setClass(this, IMageRollActivity.class);
                break;
            case R.id.adverment:
                intent.setClass(this, AdvermentActivity.class);
                break;
            case R.id.player:
                intent.setClass(this, JieCaoMainActivity.class);
                break;
            case R.id.sliding:
                intent.setClass(this, SlidingMainActivity.class);
                break;

        }
        startActivity(intent);
    }



}
