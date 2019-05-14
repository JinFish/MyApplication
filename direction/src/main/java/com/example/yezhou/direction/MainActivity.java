package com.example.yezhou.direction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView =(ImageView)findViewById(R.id.imageview);
        //设置渐变动画
        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        //设置缩放动画
        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,
                                                                 ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(2000);
        //设置旋转动画
        RotateAnimation rotateAnimation=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,
                                                                    RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(2000);
        //设置集合动画
        AnimationSet  animationSet=new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);

        //启动动画
        imageView.startAnimation(animationSet);
        animationSet.setAnimationListener(new MyAnimationListenner());


    }

    private class MyAnimationListenner implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation){

        }

        @Override
        public void onAnimationEnd(Animation animation){
            Intent intent=new Intent(MainActivity.this,StartActivity.class);
            startActivity(intent);
        }

        @Override
        public void onAnimationRepeat(Animation animation){

        }
    }
}
