package com.example.admin.demo.splash;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.VideoView;

import com.example.admin.demo.ProductHomeActivity;
import com.example.admin.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/9/9.
 */

public class SplashActivity extends Activity {
    @BindView(R.id.video)
    VideoView video;
    @BindView(R.id.skip)
    Button skip;
    private Conunt conunt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.splash_activity);
        ButterKnife.bind(this);
        Uri localUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.welcome);
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                            video.setBackgroundColor(Color.TRANSPARENT);
                        return true;
                    }
                });
            }
        });
        video.setVideoURI(localUri);
        video.start();
        video.requestFocus();
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, ProductHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        conunt = new Conunt(3000, 1000);
        conunt.start();

    }

    @OnClick(R.id.skip)
    public void onViewClicked() {
        if (conunt!=null){
            conunt.cancel();
        }
        Intent intent = new Intent();
        intent.setClass(SplashActivity.this, ProductHomeActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onPause() {
        super.onPause();
        video.canPause();
    }

    class Conunt extends CountDownTimer {
        public Conunt(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            Intent intent = new Intent();
            intent.setClass(SplashActivity.this, ProductHomeActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
