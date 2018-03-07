package com.example.admin.demo.study.scrollview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/2/2.
 */

public class ScollViewActivity extends AppCompatActivity {

    @BindView(R.id.srollview_srclllisterner_btn)
    Button srollviewSrclllisternerBtn;
    @BindView(R.id.srollview_srclllisterner_topimage)
    Button srollviewSrclllisternerTopimage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.srcollview_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.srollview_srclllisterner_btn, R.id.srollview_srclllisterner_topimage})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.srollview_srclllisterner_btn:
                intent.setClass(this, ScrollviewWithListernerActivity.class);
                startActivity(intent);
                break;
            case R.id.srollview_srclllisterner_topimage:
                intent.setClass(this, ScollViewTopImage.class);
                startActivity(intent);
                break;
        }
    }
}


