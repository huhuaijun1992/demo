package com.example.admin.demo.study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;
import com.example.admin.demo.study.DialogFragment.DialogLister;
import com.example.admin.demo.study.DialogFragment.DialogView;
import com.example.admin.demo.study.definview.DefindviewStudyMainActivity;
import com.example.admin.demo.study.service.ServiceMianActivity;
import com.example.admin.demo.utils.LogUtils;
import com.example.admin.demo.widget_collect.WidgetCollectActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/4/7.
 */

public class StudyMianActivity extends Activity implements DialogLister {
    @BindView(R.id.service_study)
    Button serviceStudy;
    @BindView(R.id.defind_study)
    Button defindStudy;
    @BindView(R.id.dialogfragment_study)
    Button dialogfragmentStudy;
    private Unbinder unbinder;
    DialogView dialogFragment;

    public static  void enter(Activity activity){
        Intent intent=new Intent();
        intent.setClass(activity,StudyMianActivity.class);
        activity.startActivity(intent);
    }
  //我们
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_mian_activity);
        unbinder = ButterKnife.bind(this);
        dialogFragment=new DialogView();
        Bundle bundle=new Bundle();
        bundle.putInt("type",1);
        dialogFragment.setArguments(bundle);

        dialogFragment.setOnDialogListener(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @OnClick({R.id.service_study, R.id.defind_study})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.service_study:
                intent.setClass(this, ServiceMianActivity.class);
                startActivity(intent);
                break;
            case R.id.defind_study:
                intent.setClass(this, DefindviewStudyMainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @OnClick(R.id.dialogfragment_study)
    public void onViewClicked() {

        dialogFragment.show(getFragmentManager(),"dialogFragment");

     }


    @Override
    public void getmessage(String s) {
        LogUtils.printe(s);
        dialogFragment.dismiss();
    }
}
