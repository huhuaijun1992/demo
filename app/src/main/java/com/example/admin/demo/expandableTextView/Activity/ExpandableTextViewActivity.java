package com.example.admin.demo.expandableTextView.Activity;

        import android.app.Activity;
        import android.os.Bundle;

        import com.example.admin.demo.R;
        import com.example.admin.demo.expandableTextView.view.ExpandableTextView;

/**
 * Created by admin on 2017/4/1.
 */

public class ExpandableTextViewActivity extends Activity {
    private ExpandableTextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandabletext_activity_layout);
        findview();
    }
    public void findview(){
        textView=(ExpandableTextView)findViewById(R.id.expand_text_view);
        textView.setText("言归正传开始说说Android Butterknife Zelezny这个插件，事实上这是个Android Studio的plugin，他可以让你在添加Butterkinfe注解时偷偷懒，直接点击几下鼠标既可以完成注解的增加，同时还是图形化的操作，可以说，大大的减轻了开发负担。尤其是当你的layout中有很多很多的view需要通过findviewbyid来获得引用时。实际上如果不用这个插件而通过手打加ButtefKnife注解的方式，要是view很多启示也挺麻烦的，不是吗？");

    }

}
