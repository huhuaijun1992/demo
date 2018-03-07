package com.example.admin.demo.study.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;

/**
 * Created by admin on 2017/4/7.
 */

public class ServiceMianActivity extends Activity implements View.OnClickListener{
    private Button  start,bind,unbind,stop,start_sing,stop_sing;
    private ServiceTest.MyBinder binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_main_activity);
        start=(Button)findViewById(R.id.start);
        bind=(Button)findViewById(R.id.bind);
        unbind=(Button)findViewById(R.id.unbind);
        stop=(Button)findViewById(R.id.stop);
        start_sing=(Button)findViewById(R.id.start_sing);
        stop_sing=(Button)findViewById(R.id.stop_sing);
        start_sing.setOnClickListener(this);
        stop_sing.setOnClickListener(this);
        start.setOnClickListener(this);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
        stop.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.start:
                intent.setClass(this,ServiceTest.class);
                startService(intent);
                break;
            case R.id.bind:
                intent.setClass(this,ServiceTest.class);
                 bindService(intent,conn,BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                intent.setClass(this,ServiceTest.class);
                unbindService(conn);

                break;
            case R.id.stop:
                intent.setClass(this,ServiceTest.class);
                stopService(intent);
                break;
            case R.id.start_sing:
                binder.star("");
                break;
            case R.id.stop_sing:
                binder.stopplay();
                break;
        }
    }
    private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder=(ServiceTest.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}
