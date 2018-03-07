package com.example.admin.demo.study.scrollview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.admin.demo.R;
import com.example.admin.demo.utils.ScreenUtils;
import com.example.admin.demo.widget_collect.ScrollVie.ScrollViewListener;
import com.example.admin.demo.widget_collect.ScrollVie.ScrollViewWithListener;

import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/2.
 */

public class ScrollviewWithListernerActivity extends AppCompatActivity implements ScrollViewListener {
    String TAG = "hhj";
    @BindView(R.id.srollview_srclllisterner)
    ScrollViewWithListener srollviewSrclllisterner;
    @BindView(R.id.title_top_lin)
    LinearLayout titleTopLin;
    int titlehight;
    private NumberFormat numberFormat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview_withlisterner_activity);
        ButterKnife.bind(this);
        srollviewSrclllisterner.setListener(this);
        titlehight= ScreenUtils.dip2px(getBaseContext(),55);
    }

    @Override
    public void scrollchange(ScrollViewWithListener viewWithListener, int x, int y, int oldx, int oldy) {
        Log.i(TAG, "oldy: ====" + oldy);
        Log.i(TAG, "y===========" + y);
        if (y>=0&&y<=255)
            titleTopLin.setBackgroundColor(ColorUtils.setAlphaComponent(getResources().getColor(R.color.color1), y));
        else
            titleTopLin.setBackgroundColor(getResources().getColor(R.color.color1));
    }
}
