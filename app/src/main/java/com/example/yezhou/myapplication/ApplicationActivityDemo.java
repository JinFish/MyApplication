package com.example.yezhou.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ApplicationActivityDemo extends AppCompatActivity {
    private MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        application=(MyApplication) getApplication();
        Log.d("应用程序Name原来的值为：",application.getName());
        application.setName("青岛");
        Log.d("应用程序Name修改后的值为：",application.getName());

    }
}
