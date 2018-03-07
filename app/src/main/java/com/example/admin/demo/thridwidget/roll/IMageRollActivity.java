package com.example.admin.demo.thridwidget.roll;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admin.demo.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/7/13.
 * 滚动图片+view共享元素
 */

public class IMageRollActivity extends Activity {
    @BindView(R.id.conver)
    LinearLayout conver;
    @BindView(R.id.scroll)
    HorizontalScrollView scroll;
    @BindView(R.id.photoview)
    ImageView photoview;
    private ArrayList<String> list = new ArrayList<>();
    private MyHandler roolHandler;
    private Timer timer;
    private MyTask task;
    private static final int SPEED = 30;
    private int moveSpeed = 2;
    private int moveSum = 0;
    private int lineWidth = 0;
    private int lineHeight = 0;
    private int moveEnd = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_roll_layout);
        ButterKnife.bind(this);
        setDate();
        showRollNews();

    }

    private void setDate() {
        list.add("信息1信息1信息1信息1信息1信息1");
        list.add("信息2信息2信息2信息2信息2信息2");
        list.add("信息3信息3信息3信息3信息3信息3");
    }

    private void showRollNews() {
        //设置不能有手势滚动操作，不然不会循环轮播
        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        setView(conver);
        if (roolHandler == null) {
            roolHandler = new MyHandler();
        }
        conver.measure(conver.getMeasuredWidth(), conver.getMeasuredHeight());
        lineWidth = conver.getMeasuredWidth();
        lineHeight = conver.getMeasuredHeight();
        moveEnd = -(lineWidth / 2);
        stopTimer();
        runRoll();
    }

    public void setView(LinearLayout line) {
        line.removeAllViews();
        int listsize = list.size();
        for (int i = 0; i < listsize * 2; i++) {
            final ImageView imageView = new ImageView(this);
            int poi = i % listsize;
            if (poi >= listsize) {
                return;
            }
            final String title = list.get(poi);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(600, 300);
            params.setMargins(40, 0, 0, 0);
            imageView.setId(i);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.material_img));
            line.addView(imageView, i, params);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), "点击了:" + title,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void runRoll() {
        if (timer == null) {
            timer = new Timer();
        }
        if (task == null) {
            task = new MyTask();
            if (roolHandler != null) {
                timer.schedule(task, 0, SPEED);
            }
        }
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (task != null) {
            task.cancel();
            task = null;
        }
    }

    @OnClick(R.id.photoview)
    public void onViewClicked() {
        Intent intent = new Intent(getBaseContext(), PhotoActivity.class);
        //android 5.0之后实现共享元素
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Pair<View, String> p = new Pair<View, String>(photoview, "head");//haderIv是头像控件
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(IMageRollActivity.this, p);
            startActivity(intent, options.toBundle());
        } else {
            //让新的Activity从一个小的范围扩大到全屏
            ActivityOptionsCompat options = ActivityOptionsCompat
                    .makeScaleUpAnimation(photoview, photoview.getWidth() / 2, photoview.getHeight() / 2, 0, 0);
            ActivityCompat.startActivity(IMageRollActivity.this, intent, options.toBundle());
        }
    }


    private class MyTask extends TimerTask {

        @Override
        public void run() {
            moveSum -= moveSpeed;
            if (moveSum < moveEnd) {
                moveSum = 0;
            } else {
                roolHandler.sendEmptyMessage(1);
            }
        }
    }


    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            conver.layout(moveSum, 0, moveSum + lineWidth, lineHeight);
        }
    }


}
