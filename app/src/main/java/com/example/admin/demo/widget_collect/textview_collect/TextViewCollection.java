package com.example.admin.demo.widget_collect.textview_collect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.example.admin.demo.R;
import com.example.admin.demo.expandableTextView.Activity.ExpandableTextViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/9/1.
 */

public class TextViewCollection extends Activity {
    @BindView(R.id.expand_tv)
    Button expandTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_collect);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.expand_tv)
    public void onViewClicked() {
        Intent intent=new Intent();
        intent.setClass(this, ExpandableTextViewActivity.class);
        startActivity(intent);
    }
}
