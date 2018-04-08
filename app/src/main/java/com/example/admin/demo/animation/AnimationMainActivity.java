package com.example.admin.demo.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.admin.demo.R;
import com.example.admin.demo.animation.tweened_animation.Animation_Property_Activity;
import com.vondear.rxtools.view.RxToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * android动画效果集合
 * Created by admin on 2017/8/22.
 */

public class AnimationMainActivity extends AppCompatActivity {

    @BindView(R.id.tween)
    TextView tween;
    @BindView(R.id.frame)
    TextView frame;
    @BindView(R.id.object)
    TextView object;

    public static void enter(Activity activity) {
        activity.startActivity(new Intent(activity, AnimationMainActivity.class));

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mian_animotion);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tween, R.id.frame, R.id.object})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tween:
                Animotion_Tween_Activity.enter(this);
                break;
            case R.id.frame:
                RxToast.normal("程序猿正在抓紧开发中，请期待以后的更新");
                break;
            case R.id.object:
                Animation_Property_Activity.enter(this);
                break;
        }
    }
}
