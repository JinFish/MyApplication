package com.example.yezhou.myapplication;

import android.app.Application;

public class MyApplication extends Application {
    private String name;
    @Override
    public void onCreate(){
        super.onCreate();
        setName("北京");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}