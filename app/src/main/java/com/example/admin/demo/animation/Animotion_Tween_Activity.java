package com.example.admin.demo.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/30.
 */

public class Animotion_Tween_Activity extends AppCompatActivity {
    @BindView(R.id.alpha)
    TextView alpha;
    @BindView(R.id.scale)
    TextView scale;
    @BindView(R.id.translate)
    TextView translate;
    @BindView(R.id.rotate)
    TextView rotate;
    @BindView(R.id.zuhe)
    TextView zuhe;
    @BindView(R.id.imageview)
    ImageView imageview;

    public static void enter(@NonNull Activity activity) {
        activity.startActivity(new Intent(activity, Animotion_Tween_Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.alpha)
    public void onAlphaClicked() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slpha);
        imageview.startAnimation(animation);


    }

    @OnClick(R.id.scale)
    public void onScaleClicked() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        imageview.startAnimation(animation);
    }

    @OnClick(R.id.translate)
    public void onTranslateClicked() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        imageview.startAnimation(animation);
    }

    @OnClick(R.id.rotate)
    public void onRotateClicked() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageview.startAnimation(animation);
    }

    @OnClick(R.id.zuhe)
    public void onZuheClicked() {
    }
}
