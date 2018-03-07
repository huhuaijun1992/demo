package com.example.admin.demo.test;


/**
 * Created by admin on 2017/5/18.
 */

public class People {
    public  Callback callback;
    public void say(String s){
        callback.say(s);
    }
    public void setCallback(Callback callback){
        this.callback=callback;
    }


}
