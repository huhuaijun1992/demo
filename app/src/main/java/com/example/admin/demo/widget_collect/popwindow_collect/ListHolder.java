package com.example.admin.demo.widget_collect.popwindow_collect;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.demo.R;


/**
 * Created by DongJr on 2017/2/21.
 */

public class ListHolder extends RecyclerView.ViewHolder {

    ImageView ivRemove;

    public ListHolder(View itemView) {
        super(itemView);
        ivRemove = (ImageView) itemView.findViewById(R.id.iv_remove);
    }


}
