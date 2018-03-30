package com.example.admin.demo.thridwidget.slidinglayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.demo.R;

public class SlidingMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding_main_actitivity);
        Button listView = (Button)this.findViewById(R.id.btnListView);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SlidingMainActivity.this,ListViewActivity.class));
            }
        });
    }
}
