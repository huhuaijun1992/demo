package com.example.admin.demo.thridwidget.jiecaoplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/7/27.
 */

public class JieCaoMainActivity extends Activity{
    @BindView(R.id.jiecao_list)
    Button jiecaoList;
    @BindView(R.id.jiecao_list_viewpager)
    Button jiecaoListViewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiecao_mian_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.jiecao_list, R.id.jiecao_list_viewpager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jiecao_list:
                startActivity(new Intent(this,JiecaoListActivity.class));
                break;
            case R.id.jiecao_list_viewpager:
                break;
        }
    }
}
