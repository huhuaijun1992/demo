package com.example.admin.demo.list.horizontalListView.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.admin.demo.R;

/**
 * Created by admin on 2017/4/1.
 */

public class HorizontalListViewAdapter extends BaseAdapter {
    private  int[] strings;
    private Activity activity;
    public HorizontalListViewAdapter(int[] strings, Activity activity) {
        this.strings = strings;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler=null;
        if (convertView==null){
            convertView= LayoutInflater.from(activity).inflate(R.layout.horizontallistview_adapter_layout,null);
            hodler=new ViewHodler();
            hodler.imageView=(ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(hodler);

        }else {
            hodler=(ViewHodler) convertView.getTag();
        }
        hodler.imageView.setImageResource(strings[position]);
        return convertView;
    }
    class  ViewHodler{
        private ImageView imageView;
    }
}
