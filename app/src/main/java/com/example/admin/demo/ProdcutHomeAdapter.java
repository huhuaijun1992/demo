package com.example.admin.demo;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.demo.activity.ActivityRxToast;
import com.example.admin.demo.activity.ZxingCelection;
import com.example.admin.demo.activity.adapter.ZxingAdapter;
import com.example.admin.demo.animation.AnimationMainActivity;
import com.example.admin.demo.study.StudyMianActivity;
import com.example.admin.demo.thridwidget.ThirdWidgetCollectActivity;
import com.example.admin.demo.widget_collect.WidgetCollectActivity;
import com.vondear.rxtools.RxActivityTool;

import java.util.List;

/**
 * Created by Administrator on 2018/3/13.
 */

public class ProdcutHomeAdapter extends RecyclerView.Adapter {
    private List<DataEntity>list;
    private Activity activity;

    public ProdcutHomeAdapter(List<DataEntity> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_home_item_layout,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder holder1=(Holder)holder;
        holder1.setdata(list,position,activity);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
   public  static   class Holder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public View view;


       public Holder(View itemView) {
           super(itemView);
           this.view=itemView;
           imageView=(ImageView) itemView.findViewById(R.id.image);
           textView=(TextView)itemView.findViewById(R.id.title);
       }
       public  void setdata(List<DataEntity> list , final int position, final Activity activity){
           textView.setText(list.get(position).getName());
           imageView.setImageResource(list.get(position).getImagePath());
           view.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   switch (position){
                       case 0:
                           WidgetCollectActivity.enter(activity);
                           break;
                       case 1:
                           AnimationMainActivity.enter(activity);
                           break;
                       case 2:
                           ThirdWidgetCollectActivity.enter(activity);
                           break;
                       case 3:
                           StudyMianActivity.enter(activity);
                           break;
                       case 4:
                           ZxingCelection.enter(activity);
                           break;
                       case 5:
                           ActivityRxToast.enter(activity);
                           break;


                   }
               }
           });


       }
   }
}
