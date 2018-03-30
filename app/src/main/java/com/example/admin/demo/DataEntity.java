package com.example.admin.demo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/13.
 */

public class DataEntity  implements Serializable {
    private int  imagePath;
    private String name;
    private int id;

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DataEntity(int imagePath, String name, int id) {
        this.imagePath = imagePath;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "imagePath=" + imagePath +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
