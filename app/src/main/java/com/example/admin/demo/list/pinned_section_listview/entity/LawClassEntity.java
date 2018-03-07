package com.example.admin.demo.list.pinned_section_listview.entity;

import java.io.Serializable;

/**
 * Created by hhj on 2017/3/15.
 */
public class LawClassEntity implements Serializable {
    public String id;  //id
    public String classname;//列别名称
    public String paraid;  //父级id
    public String ispara;  //是否是父级

    public LawClassEntity(String id, String classname, String paraid, String ispara) {
        this.id = id;
        this.classname = classname;
        this.paraid = paraid;
        this.ispara = ispara;
    }

    public LawClassEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getIspara() {
        return ispara;
    }

    public void setIspara(String ispara) {
        this.ispara = ispara;
    }

    public String getParaid() {
        return paraid;
    }

    public void setParaid(String paraid) {
        this.paraid = paraid;
    }

    @Override
    public String toString() {
        return "LawClassEntity{" +
                "id='" + id + '\'' +
                ", classname='" + classname + '\'' +
                ", paraid='" + paraid + '\'' +
                ", ispara='" + ispara + '\'' +
                '}';
    }
}
