package com.example.admin.demo.list.pinned_section_listview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.demo.R;
import com.example.admin.demo.list.pinned_section_listview.entity.Item;
import com.example.admin.demo.list.pinned_section_listview.entity.LawClassEntity;

import java.util.List;

/**
 * Created by admin on 2017/4/18.
 */

public class MyRecyclerAdapter  extends RecyclerView.Adapter {
  private final List<Item> lists;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public MyRecyclerAdapter(List<Item> lists, Context mContext, LayoutInflater mLayoutInflater) {
        this.lists = lists;
        this.mContext = mContext;
        this.mLayoutInflater = mLayoutInflater;
    }
    

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new MyViewHolder(mLayoutInflater.inflate(R.layout.pinner_section_listview_item_layout,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1=(MyViewHolder) holder;
        holder1.setData(position);

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mv_name;
  

        public MyViewHolder(View itemView) {
            super(itemView);
            mv_name = (TextView) itemView.findViewById(R.id.text_name);
        }

        public void setData(int position) {
            Item entity = lists.get(position);
            String name = entity.getEntity().getClassname();
            mv_name.setText(name);
            
        }
    }

}
