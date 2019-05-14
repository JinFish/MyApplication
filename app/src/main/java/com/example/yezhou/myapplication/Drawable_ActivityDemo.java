package com.example.yezhou.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Drawable_ActivityDemo extends AppCompatActivity {
    TextView tv10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_layout);
        tv10=(TextView) findViewById(R.id.tv10);
        tv10.setBackgroundDrawable(getResources().getDrawable(R.drawable.little));
    }
}
