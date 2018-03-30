package com.example.admin.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.admin.demo.study.StudyMianActivity;
import com.example.admin.demo.thridwidget.ThirdWidgetCollectActivity;
import com.example.admin.demo.utils.StatusBarUtils;
import com.example.admin.demo.utils.WaterMarkTextUtil;
import com.example.admin.demo.widget_collect.WidgetCollectActivity;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.home_reclerview)
    RecyclerView homeReclerview;
    private ProdcutHomeAdapter adapter;
    private List<DataEntity>list=new ArrayList<DataEntity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        沉浸式状态栏
//        StatusBarUtils.setTransparentStatusBar(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        findview();
    }


    public void findview() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        homeReclerview.setLayoutManager(gridLayoutManager);
        adapter=new ProdcutHomeAdapter(list,this);
        homeReclerview.setAdapter(adapter);
        WaterMarkTextUtil util = new WaterMarkTextUtil();
        util.setWaterMarkTextBg(homeReclerview, this, "胡怀俊的android效果集");
    }

    public void  initData(){
        list.add(new DataEntity(R.mipmap.product_icon1,"组件学习",0));
        list.add(new DataEntity(R.mipmap.product_icon2,"动画",1));
        list.add(new DataEntity(R.mipmap.product_icon3,"控件效果",2));
        list.add(new DataEntity(R.mipmap.product_icon4,"学无止境",3));
        list.add(new DataEntity(R.mipmap.product_icon5,"二维码的相关操作",4));
        list.add(new DataEntity(R.mipmap.product_icon6,"弹窗的艺术",5));
    }
}
