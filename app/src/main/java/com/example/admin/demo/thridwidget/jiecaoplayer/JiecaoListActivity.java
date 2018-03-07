package com.example.admin.demo.thridwidget.jiecaoplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.example.admin.demo.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by admin on 2017/7/27.
 */

public class JiecaoListActivity extends AppCompatActivity {
    @BindView(R.id.listview)
    ListView listview;
    private JieCaoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiecao_list_activity);
        ButterKnife.bind(this);
        adapter=new JieCaoAdapter(this);
        listview.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
