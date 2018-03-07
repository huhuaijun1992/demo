package com.example.admin.demo.flowlayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.demo.R;
import com.example.admin.demo.flowlayout.view.FlowLayout;


/**
 * Created by admin on 2017/4/1.
 */

public class FlowLayoutActivity  extends Activity {
    private FlowLayout flowlayout,flowlayout1;
    String[] strings=new String[]{"我爱北京天安门","南京是一个好城市","夫子庙","南京钟山陵","水游城","大汉网络","南京房价突破4万","万达广场在哪里","南京最低工资标准","海底世界"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flowlayout_activity);
        flowlayout=(FlowLayout)findViewById(R.id.flowlayout);
        flowlayout1=(FlowLayout)findViewById(R.id.flowlayout1);
        showMoreColorTextView();
        showTextView();

    }
    /**
     * 定义好的TextView只需传入view以及字体的颜色，背景资源文件，以及上下左右的外边距。
     *
     * **/
    public void showTextView(){                                                                                            
        for (int i=0;i<10;i++){
            final TextView textView=new TextView(this);
            textView.setId(i);
            textView.setText(strings[i]);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(FlowLayoutActivity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            flowlayout.addTextView(textView, Color.WHITE,getResources().getDrawable(R.drawable.hotsearch_selector),10,10,10,10);
        }
    }
    /***
     *  通过原始的addview()可以自己定义view的属性
     * 这是多种热门标签的随机背景颜色
     */

    public void showMoreColorTextView(){
        for (int i=0;i<10;i++){
            final TextView textView=new TextView(this);
            textView.setText(strings[i]);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(FlowLayoutActivity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            flowlayout1.moreColorrTextView(textView, Color.WHITE, 10, 10, 10, 10);
        }
    }



}
