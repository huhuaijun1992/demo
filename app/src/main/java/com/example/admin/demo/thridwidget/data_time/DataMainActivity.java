package com.example.admin.demo.thridwidget.data_time;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.demo.R;

import org.feezu.liuli.timeselector.TimeSelector;

/**
 * Created by admin on 2017/4/7.
 *详情见博客：http://blog.csdn.net/SetO2/article/details/50757170
 */

public class DataMainActivity extends Activity implements View.OnClickListener{
    private Button dataios,timeios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_main_activity_layout);
        dataios=(Button)findViewById(R.id.dataios);
        timeios=(Button)findViewById(R.id.timeios);
        dataios.setOnClickListener(this);
        timeios.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dataios:
                TimeSelector  timeSelector =new TimeSelector(this, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        Toast.makeText(getApplicationContext(), time, Toast.LENGTH_SHORT).show();
                    }
                },"2017-04-07 00:00","2099-04-07 00:00");
                timeSelector.setMode(TimeSelector.MODE.YMDHM);
                timeSelector.show();
                break;
            case R.id.timeios:
                TimeSelector  timeSelector1 =new TimeSelector(this, new TimeSelector.ResultHandler() {
                    @Override
                    public void handle(String time) {
                        Toast.makeText(getApplicationContext(), time, Toast.LENGTH_SHORT).show();
                    }
                },"2017-04-07 00:00","2099-04-07 00:00");
                timeSelector1.setMode(TimeSelector.MODE.YMD);
                timeSelector1.show();
                break;

        }

    }
}
