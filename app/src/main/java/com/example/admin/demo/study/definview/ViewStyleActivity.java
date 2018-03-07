package com.example.admin.demo.study.definview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.admin.demo.R;

/**
 * Created by admin on 2017/9/8.
 */

public class ViewStyleActivity  extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_style_activity);
    }
    public static void staractivit(Activity activity){
        Intent intent=new Intent();
        intent.setClass(activity,ViewStyleActivity.class);
        activity.startActivity(intent);
    }
}
