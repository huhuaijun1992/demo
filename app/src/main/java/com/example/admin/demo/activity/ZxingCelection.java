package com.example.admin.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.demo.DataEntity;
import com.example.admin.demo.R;
import com.example.admin.demo.activity.adapter.ZxingAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZxingCelection extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private ZxingAdapter adapter;
    private List<DataEntity>list=new ArrayList<DataEntity>();
    public static void enter(Activity activity){
      activity.startActivity(new Intent().setClass(activity,ZxingCelection.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing_celection);
        ButterKnife.bind(this);
        setData();
        init();
    }
    private void init(){
        adapter=new ZxingAdapter(list,ZxingCelection.this);
        GridLayoutManager linearLayoutManager=new GridLayoutManager(this,3);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(adapter);

    }
    private void setData(){
        list.add(new DataEntity(R.mipmap.circle_dynamic_generation_code,"二维码与条形码的扫描生成",1));
        list.add(new DataEntity(R.mipmap.circle_dynamic_generation_code,"动态生成码",2));
    }
}
