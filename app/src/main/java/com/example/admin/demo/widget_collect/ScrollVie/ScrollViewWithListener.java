package com.example.admin.demo.widget_collect.ScrollVie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by admin on 2017/9/12.
 */

public class ScrollViewWithListener extends ScrollView {
    private ScrollViewListener listener;
    public ScrollViewWithListener(Context context) {
        super(context);
    }

    public ScrollViewWithListener(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewWithListener(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setListener(ScrollViewListener listener){
        this.listener=listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (listener!=null){
            listener.scrollchange(this,l,t,oldl,oldt);
        }
    }
    public  void settitlebar(View view){

    }
}
