package com.example.admin.demo.widget_collect.imageview_collect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.admin.demo.R;
import com.example.admin.demo.thridwidget.photoView.galleryWidget.BasePagerAdapter;
import com.example.admin.demo.thridwidget.photoView.galleryWidget.GalleryViewPager;
import com.example.admin.demo.thridwidget.photoView.galleryWidget.UrlPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/9/4.
 */

public class PhotoBrowser extends Activity {
    @BindView(R.id.picture_viewPager)
    GalleryViewPager pictureViewPager;
    @BindView(R.id.picture_back)
    RelativeLayout pictureBack;
    @BindView(R.id.picture_top)
    RelativeLayout pictureTop;
    @BindView(R.id.picture_title)
    TextView pictureTitle;
    @BindView(R.id.picture_count)
    TextView pictureCount;
    @BindView(R.id.picture_text)
    TextView pictureText;
    @BindView(R.id.picture_scroll)
    ScrollView pictureScroll;
    @BindView(R.id.picture_bottom)
    RelativeLayout pictureBottom;
    String title;
    private UrlPagerAdapter adapter;
    private List<String> picpaths = new ArrayList<String>();
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photobrower_activity);
        unbinder = ButterKnife.bind(this);
        picpaths.add("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1742626185,2547278809&os=2248809637,1244502461&simid=4089525120,398972452&pn=13&rn=1&di=131664912280&ln=1930&fr=&fmq=1504496848434_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fuploads.xuexila.com%2Fallimg%2F1612%2F902-16120GA510.jpg&rpstart=0&rpnum=0&adpicid=0");
        picpaths.add("http://img1.imgtn.bdimg.com/it/u=1794894692,1423685501&fm=27&gp=0.jpg");
        picpaths.add("http://img4.imgtn.bdimg.com/it/u=2611079001,3896435225&fm=27&gp=0.jpg");
        picpaths.add("http://img1.imgtn.bdimg.com/it/u=2899492451,3422113638&fm=27&gp=0.jpg");
        pictureTitle.setText("这个是图片浏览器");
        pictureText.setText("这个是内容，你喜欢吗？这个效果还是不错的");
        adapter = new UrlPagerAdapter(this, picpaths);
        pictureViewPager.setAdapter(adapter);
        pictureCount.setText(1 + "/" + picpaths.size());
        adapter.setOnItemChangeListener(new BasePagerAdapter.OnItemChangeListener() {
            @Override
            public void onItemChange(int currentPosition) {
                pictureCount.setText((currentPosition + 1) + "/" + picpaths.size());
            }
        });

    }

    static void startactivity(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, PhotoBrowser.class);
        activity.startActivity(intent);
    }

    @OnClick(R.id.picture_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
