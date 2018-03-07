package com.example.admin.demo.thridwidget.adverment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.admin.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/7/18.
 * view轮播与切换的的集中实现方式
 */

public class AdvermentActivity extends Activity {
    @BindView(R.id.vf)
    ViewFlipper vf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewfile_layout);
        ButterKnife.bind(this);
        for (int i=0;i<3;i++){
            final int j=i;
            View view =View.inflate(this,R.layout.adverment_layout,null);
            TextView textView=(TextView) view.findViewById(R.id.textview);
            textView.setText("小米6来了：晓龙835+8G运存！"+i);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(AdvermentActivity.this,j+"",Toast.LENGTH_SHORT).show();
                }
            });
            vf.addView(view);
        }

    }

}
