package com.example.admin.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
 /**
 @data on $DATES
 @Author 胡怀俊
 @email 1130456163@qq.com
 @describe 添加描述
 */

public class APPBarColection extends Activity {

    @BindView(R.id.backdrop)
    ImageView backdrop;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbar_collection_layout);
        ButterKnife.bind(this);
        toolbar.setTitle("测试下");
    }

}
