package com.example.admin.demo.thridwidget.jiecaoplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.admin.demo.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by admin on 2017/7/27.
 */

public class JieCaoAdapter extends BaseAdapter {
    private Context context;
    private String[] urls={
            "http://video.jiecao.fm/8/17/bGQS3BQQWUYrlzP1K4Tg4Q__.mp4",
            "http://video.jiecao.fm/8/17/%E6%8A%AB%E8%90%A8.mp4",
            "http://video.jiecao.fm/8/18/%E5%A4%A7%E5%AD%A6.mp4",
            "http://video.jiecao.fm/8/16/%E8%B7%B3%E8%88%9E.mp4",
            "http://video.jiecao.fm/8/16/%E9%B8%AD%E5%AD%90.mp4",
            "http://video.jiecao.fm/8/16/%E9%A9%BC%E8%83%8C.mp4",
            "http://video.jiecao.fm/8/16/%E4%BF%AF%E5%8D%A7%E6%92%91.mp4",
            "http://video.jiecao.fm/5/1/%E8%87%AA%E5%8F%96%E5%85%B6%E8%BE%B1.mp4",
            "http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4",
            "http://video.jiecao.fm/11/23/xu/%E5%A6%B9%E5%A6%B9.mp4"
    };
    private String[]titiles={
            "嫂子出来",
            "嫂子溢出",
            "嫂子我姓王",
            "嫂子趴好了",
            "嫂子很渴",
            "嫂子这样不好",
            "嫂子别笑",
            "嫂子坐火车",
            "嫂子打游戏",
            "嫂子还小"
    };

    public JieCaoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return urls.length;
    }

    @Override
    public Object getItem(int position) {
        return urls[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.jiecao_item_layout,null);
            viewHolder =new ViewHolder();
            viewHolder.jcVideoPlayer=(JCVideoPlayerStandard) convertView.findViewById(R.id.videoplayer);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();

        }
        viewHolder.jcVideoPlayer.setUp(urls[position], JCVideoPlayer.SCREEN_LAYOUT_LIST,titiles[position]);

        return convertView;
    }
    class ViewHolder {
        JCVideoPlayerStandard jcVideoPlayer;
    }
}
