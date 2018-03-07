package com.example.admin.demo.widget_collect.imageview_collect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/9/4.
 */

public class ImageCollect extends Activity {
    Unbinder unbinder;
    @BindView(R.id.photo_broaswer)
    Button photoBroaswer;
    @BindView(R.id.compress_image)
    Button compressImage;
    @BindView(R.id.crop_image)
    Button cropImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_collect);
        unbinder = ButterKnife.bind(this);
        ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    @OnClick({R.id.photo_broaswer, R.id.compress_image,R.id.crop_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.photo_broaswer:
                //图片浏览器
                PhotoBrowser.startactivity(this);
                break;
            case R.id.compress_image:
                ComPressImageActivity.startactivity(this);
                //图片压缩
                break;
            case R.id.crop_image:
                CropImageActivity.startactivity(this);

                break;
        }
    }


}
