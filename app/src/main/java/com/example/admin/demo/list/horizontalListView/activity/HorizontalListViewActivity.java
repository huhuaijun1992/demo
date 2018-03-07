package com.example.admin.demo.list.horizontalListView.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.admin.demo.R;
import com.example.admin.demo.list.horizontalListView.adapter.HorizontalListViewAdapter;
import com.example.admin.demo.list.horizontalListView.view.HorizontalListView;

/**
 * Created by admin on 2017/4/1.
 */

public class HorizontalListViewActivity extends Activity {
    private HorizontalListView horizontalListView;
    private HorizontalListViewAdapter adapter;
    private int[] images={R.mipmap.icon1,R.mipmap.icon2,R.mipmap.icon3,R.mipmap.icon4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_horizontallistview_activity_layout);
    findview();
        adapter=new HorizontalListViewAdapter(images,this);
        horizontalListView.setAdapter(adapter);

    }
    public void findview(){
        horizontalListView=(HorizontalListView)findViewById(R.id.horizontalListView);
    }
}
