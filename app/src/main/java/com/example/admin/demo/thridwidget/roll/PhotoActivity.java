package com.example.admin.demo.thridwidget.roll;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.demo.R;

/**
 * Created by admin on 2017/8/22.
 */

public class PhotoActivity extends Activity {
    ImageView closeImage,photo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.photo_activity_layout);
        closeImage=(ImageView)findViewById(R.id.close_image);
        closeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    finishAfterTransition();
                else
                    finish();

            }
        });
        photo=(ImageView)findViewById(R.id.photo);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            photo .setTransitionName("head");//第二个Activity里的头像控件
            postponeEnterTransition();
            startPostponedEnterTransition();
        }

    }



}
