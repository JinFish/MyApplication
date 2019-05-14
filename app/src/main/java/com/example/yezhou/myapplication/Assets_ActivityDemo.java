package com.example.yezhou.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Assets_ActivityDemo extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assets_layout);
        iv=(ImageView) findViewById(R.id.iml);
        try{
            InputStream is=getResources().getAssets().open("test1.png");
            Bitmap bitmap= BitmapFactory.decodeStream(is);
            iv.setImageBitmap(bitmap);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
