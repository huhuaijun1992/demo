package com.example.admin.demo.list.pinned_section_listview.entity;

/**
 * Created by admin on 2017/4/12.
 */

public class Item {
    //类型 0是分组名称 1是分组下面的成员
    public static final int ITEM = 0;
    public static final int SECTION = 1;

    public final int type;
    public final LawClassEntity entity;

    public int sectionPosition;
    public int listPosition;

    public Item(int type, LawClassEntity entity,int sectionPosition,int listPosition) {
        this.type = type;
        this.entity = entity;
        this.sectionPosition=sectionPosition;
        this.listPosition=listPosition;
    }

    public LawClassEntity getEntity() {
        return entity;
    }

    public int getType() {
        return type;
    }

    public int getSectionPosition() {
        return sectionPosition;
    }

    public void setSectionPosition(int sectionPosition) {
        this.sectionPosition = sectionPosition;
    }

    public int getListPosition() {
        return listPosition;
    }

    public void setListPosition(int listPosition) {
        this.listPosition = listPosition;
    }
}
