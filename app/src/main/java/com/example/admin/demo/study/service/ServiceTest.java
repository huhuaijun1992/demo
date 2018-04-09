package com.example.admin.demo.study.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.admin.demo.R;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;

/**
 * Created by admin on 2017/4/11.
 */

public class ServiceTest extends Service {
    private boolean isplay = true;
    private MyBinder binder = new MyBinder();
    private TimerTask task;
    private Timer timer;
    private String isTAG="demo";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("demo", "onCreate:==========" + "service 创建了");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i("demo", "onStart:==========" + "service start");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("demo", "onStartCommand:==========" + "service startcommand");
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("demo", "onBind:==========" + "service bind");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("demo", "onUnbind:==========" + "service unbind");
        return super.onUnbind(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("demo", "onDestroy:==========" + "service destory");
    }
    //发送一个简单的通知
    public void sendMessage(){
        Notification notification=new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.icon)
                .setContentText("这是一个测试通知")
                .setContentTitle("通知")
                .build();
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification);
    }


    class MyBinder extends Binder {

        public void stopplay() {
            isplay=false;
            Log.i("demo", "stopplay:=============停止唱歌 ");
            Log.i("demo", "stopplay: "+isplay);

        }

        public void star(String name) {
            Log.i("demo", "star: ==================开始唱歌");
        }

        //发送一个简单的通知
        public void sendMessage(){
           ServiceTest.this.sendMessage();
        }
    }

}
