package com.example.admin.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.admin.demo.study.StudyMianActivity;
import com.example.admin.demo.thridwidget.ThirdWidgetCollectActivity;
import com.example.admin.demo.utils.WaterMarkTextUtil;
import com.example.admin.demo.widget_collect.WidgetCollectActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductHomeActivity extends AppCompatActivity {
    @BindView(R.id.widget)
    Button widget;
    @BindView(R.id.animation)
    Button animation;
    @BindView(R.id.study)
    Button study;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.third_wedigt)
    Button thirdWedigt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        findview();
    }

    public void findview() {

        WaterMarkTextUtil util = new WaterMarkTextUtil();
        util.setWaterMarkTextBg(scrollView, this, "胡怀俊的android效果集");
    }


    @OnClick({R.id.widget, R.id.animation, R.id.study, R.id.third_wedigt})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.widget:
                intent.setClass(this, WidgetCollectActivity.class);
                startActivity(intent);
                break;
            case R.id.animation:
                break;
            case R.id.study:
                intent.setClass(this, StudyMianActivity.class);
                startActivity(intent);
                break;
            case R.id.third_wedigt:
                intent.setClass(this, ThirdWidgetCollectActivity.class);
                startActivity(intent);
                break;
        }

    }
}
