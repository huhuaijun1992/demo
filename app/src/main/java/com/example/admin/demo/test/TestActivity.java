package com.example.admin.demo.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.admin.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/5/18.
 */

public class TestActivity extends Activity {
    @BindView(R.id.callback_listnaer)
    Button callbackListnaer;
    public   People people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);
        ButterKnife.bind(this);
        people=new People();
        people.setCallback(new Callback() {
            @Override
            public void say(String s) {
                Log.i("hhj", "say: "+s);
            }
        });
    }

    @OnClick(R.id.callback_listnaer)
    public void onViewClicked() {
        people.say("我是测试一下的同步回调");
    }

}
