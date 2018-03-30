package com.example.admin.demo.widget_collect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;
import com.example.admin.demo.study.scrollview.ScollViewActivity;
import com.example.admin.demo.widget_collect.imageview_collect.ImageCollect;
import com.example.admin.demo.widget_collect.itemtouchhelperdemo.demochannel.ChannelActivity;
import com.example.admin.demo.widget_collect.popwindow_collect.PopwindowActivity;
import com.example.admin.demo.widget_collect.textinputlayout.TextLayoutInputActivity;
import com.example.admin.demo.widget_collect.textview_collect.TextViewCollection;
import com.example.admin.demo.widget_collect.viewpager_collect.autoviewpager.activity.Auto3DViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/7/4.
 */

public class WidgetCollectActivity extends Activity {
    @BindView(R.id.textview_collect)
    Button textviewCollect;
    @BindView(R.id.image_collect)
    Button imageCollect;
    @BindView(R.id.tablayout_collect)
    Button tablayoutCollect;
    @BindView(R.id.viewpager_collect)
    Button viewpagerCollect;
    @BindView(R.id.listview_collect)
    Button listviewCollect;
    @BindView(R.id.scroll_collect)
    Button scrollCollect;
    @BindView(R.id.recyclerview_collect)
    Button recyclerviewCollect;
    @BindView(R.id.PopupWindow_collect)
    Button PopupWindowCollect;
    @BindView(R.id.textinputlayout)
    Button textinputlayout;
    public static  void enter(Activity activity){
        Intent intent=new Intent();
        intent.setClass(activity,WidgetCollectActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_collect_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.textinputlayout,R.id.PopupWindow_collect, R.id.textview_collect, R.id.image_collect, R.id.viewpager_collect, R.id.scroll_collect, R.id.recyclerview_collect})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.textview_collect:
                intent.setClass(this, TextViewCollection.class);
                break;
            case R.id.image_collect:
                intent.setClass(this, ImageCollect.class);
                break;
            case R.id.viewpager_collect:
                intent.setClass(this, Auto3DViewPagerActivity.class);
                break;
            case R.id.scroll_collect:
                intent.setClass(this, ScollViewActivity.class);
                break;
            case R.id.recyclerview_collect:
                intent.setClass(this, ChannelActivity.class);
                break;
            case R.id.PopupWindow_collect:
                intent.setClass(this, PopwindowActivity.class);
                break;
            case R.id.textinputlayout:
                intent.setClass(this, TextLayoutInputActivity.class);
                break;

        }
        startActivity(intent);
    }



}
