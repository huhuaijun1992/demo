package com.example.admin.demo.study.definview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.example.admin.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/9/8.
 */

public class DefindviewStudyMainActivity extends Activity {
    @BindView(R.id.frist_view)
    Button fristView;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.defindview_studymian);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.frist_view)
    public void onViewClicked() {
        ViewStyleActivity.staractivit(this);

    }
}
