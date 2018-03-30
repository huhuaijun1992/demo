package com.example.admin.demo.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.demo.R;

/**
 * Created by Administrator on 2018/3/30.
 *
 */

public class Animotion_Tween_Activity  extends AppCompatActivity{
    public static  void enter(@NonNull  Activity activity){
        activity.startActivity(new Intent(activity,Animotion_Tween_Activity.class));
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);
    }
}
