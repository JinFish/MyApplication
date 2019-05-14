package com.example.yezhou.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Dimen_ActivityDemo extends AppCompatActivity {
    TextView tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dimen_layout);
        tv6=(TextView) findViewById(R.id.tv6);
        tv6.setTextSize(getResources().getDimension(R.dimen.dimen_java));
    }
}
