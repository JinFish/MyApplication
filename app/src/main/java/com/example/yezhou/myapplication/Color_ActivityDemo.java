package com.example.yezhou.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Color_ActivityDemo extends AppCompatActivity {
    TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_layout);
        tv4=(TextView) findViewById(R.id.tv4);
        tv4.setTextColor(getResources().getColor(R.color.color_java));
    }
}
