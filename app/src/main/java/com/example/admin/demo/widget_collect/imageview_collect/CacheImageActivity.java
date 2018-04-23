package com.example.admin.demo.widget_collect.imageview_collect;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.demo.R;
import com.example.admin.demo.utils.ImageCacheUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/20.
 */

public class CacheImageActivity extends AppCompatActivity {
    @BindView(R.id.down)
    Button down;
    @BindView(R.id.imageview)
    ImageView imageview;
    private ImageCacheUtil imageCacheUtil;
    public static void enter(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, CacheImageActivity.class);
        activity.startActivity(intent);
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
           Bitmap bitmap=(Bitmap) msg.obj;
           imageview.setImageBitmap(bitmap);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cache_image_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.down)
    public void onViewClicked() {
        imageCacheUtil=new ImageCacheUtil();
        new Thread(){
            @Override
            public void run() {
                super.run();
                 Bitmap bitmap= imageCacheUtil.getBitmap("c494b7ca3d81d5c3ced147a4793c31c6");
                 Message message=new Message();
                 message.obj=bitmap;
                 message.what=0;
                handler.sendMessage(message);

            }
        }.start();

    }
}
