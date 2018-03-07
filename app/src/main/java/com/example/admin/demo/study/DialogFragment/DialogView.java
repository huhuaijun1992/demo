package com.example.admin.demo.study.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.demo.R;

/**
 * Created by admin on 2017/11/30.
 */

public class DialogView extends DialogFragment {
    public View view;
    private TextView confige,neirong;

    public  DialogLister lister;

    public int type;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialogview, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findviewbyid();
        Bundle bundle=getArguments();
         type= bundle.getInt("type");
        Toast.makeText(getActivity(),type+"",Toast.LENGTH_SHORT).show();
    }

    public void findviewbyid(){
        confige=(TextView)view.findViewById(R.id.config);
        neirong=(TextView)view.findViewById(R.id.neirong);
        confige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lister.getmessage(neirong.getText().toString());

            }
        });
    }
    public void setOnDialogListener(DialogLister listener){
        this.lister=listener;
    }
}

