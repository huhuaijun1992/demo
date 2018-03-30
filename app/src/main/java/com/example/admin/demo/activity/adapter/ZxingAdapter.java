package com.example.admin.demo.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.demo.DataEntity;
import com.example.admin.demo.R;
import com.example.admin.demo.activity.ActivityCodeTool;

import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */

public class ZxingAdapter extends RecyclerView.Adapter {
    private List<DataEntity>list;
    private Activity context;

    public ZxingAdapter(List<DataEntity> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.product_home_item_layout,null);
        return new Hoder(view,context);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       Hoder hoder= (Hoder) holder;
       hoder.setdata(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private  class  Hoder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;
        private  View view ;
        private Activity context;


        public Hoder(View itemView ,Activity context) {
            super(itemView);
            this.view=itemView;
            this.context=context;
            imageView=(ImageView) itemView.findViewById(R.id.image);
            textView=(TextView)itemView.findViewById(R.id.title);
        }
        public  void setdata(int position){
            textView.setText(list.get(position).getName());
            imageView.setImageResource(list.get(position).getImagePath());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityCodeTool.enter(context);

                }
            });
        }

    }
}
