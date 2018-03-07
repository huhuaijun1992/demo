package com.example.admin.demo.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;
import com.example.admin.demo.list.horizontalListView.activity.HorizontalListViewActivity;
import com.example.admin.demo.list.pinned_section_listview.PinnerSectionListviewActivity;

/**
 * Created by admin on 2017/4/1.
 */

public class ListMain extends Activity  implements View.OnClickListener{
    private Button group_list,sortlist,scrollViewlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main_activit);
        findview();
    }
    public void findview(){
        group_list=(Button)findViewById(R.id.group_list);
        sortlist=(Button)findViewById(R.id.sortlist);
        scrollViewlist=(Button)findViewById(R.id.scrollViewlist);
        group_list.setOnClickListener(this);
        sortlist.setOnClickListener(this);
        scrollViewlist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.group_list:
                intent.setClass(this, PinnerSectionListviewActivity.class);
                startActivity(intent);

                break;
            case R.id.sortlist:
                break;
            case R.id.scrollViewlist:
                intent.setClass(this, HorizontalListViewActivity.class);
                startActivity(intent);
                break;
        }

    }
}
