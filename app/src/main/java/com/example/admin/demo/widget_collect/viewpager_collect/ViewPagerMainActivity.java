package com.example.admin.demo.widget_collect.viewpager_collect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.activity.Auto3DViewPagerActivity;

/**
 * Created by admin on 2017/4/5.
 * 3D效果的自动滚动效果
 */

public class ViewPagerMainActivity extends Activity implements View.OnClickListener {
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main_activit);
        button=(Button)findViewById(R.id.viewpager_3d);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.viewpager_3d:
                intent.setClass(this, Auto3DViewPagerActivity.class);
                startActivity(intent);
                break;
        }

    }
}
