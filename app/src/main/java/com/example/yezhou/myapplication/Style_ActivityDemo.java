package com.example.yezhou.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Style_ActivityDemo extends AppCompatActivity {
    TextView tv8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style_layout);
        tv8=(TextView) findViewById(R.id.tv8);
        tv8.setTextAppearance(this,R.style.red_textview);
    }
}
