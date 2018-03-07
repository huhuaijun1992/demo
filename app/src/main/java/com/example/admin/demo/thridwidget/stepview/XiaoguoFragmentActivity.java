package com.example.admin.demo.thridwidget.stepview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.admin.demo.R;
import com.example.admin.demo.thridwidget.stepview.fragment.HorizontalStepviewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/4/19.
 */

public class XiaoguoFragmentActivity extends FragmentActivity {
    @BindView(R.id.sytle1)
    Button sytle1;
    @BindView(R.id.sytle2)
    Button sytle2;
    @BindView(R.id.sytle3)
    Button sytle3;
    @BindView(R.id.sytle4)
    Button sytle4;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private HorizontalStepviewFragment fragment1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiaoguofragementactivity);
        ButterKnife.bind(this);
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        fragment1=new HorizontalStepviewFragment();
        transaction.replace(R.id.framelayout,fragment1).commit();
    }

    @OnClick(R.id.sytle1)
    public void onSytle1Clicked() {
        if (fragment1==null){
            fragment1=new HorizontalStepviewFragment();
        }
        transaction=manager.beginTransaction();
        transaction.replace(R.id.framelayout,fragment1).commit();
    }

    @OnClick(R.id.sytle2)
    public void onSytle2Clicked() {
        transaction=manager.beginTransaction();
    }

    @OnClick(R.id.sytle3)
    public void onSytle3Clicked() {
        transaction=manager.beginTransaction();
    }

    @OnClick(R.id.sytle4)
    public void onSytle4Clicked() {
        transaction=manager.beginTransaction();
    }
}
