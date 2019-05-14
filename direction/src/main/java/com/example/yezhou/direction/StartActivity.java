package com.example.yezhou.direction;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;



public class StartActivity extends Activity {
    private ViewPager viewpager;
    private Button btn_start;
    private LinearLayout point_group;
    private ArrayList<ImageView> imageviews;
    private ImageView iv_red_point;
    private int leftmax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        btn_start = (Button) findViewById(R.id.btn_start);
        point_group= (LinearLayout) findViewById(R.id.point_group);
        iv_red_point = (ImageView) findViewById(R.id.iv_red_point);
        //准备数据
        int[]images={R.drawable.start2,R.drawable.start1,R.drawable.start3};
        imageviews=new ArrayList<>();
        for(int i=0;i<images.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setBackgroundResource(images[i]);
            //添加到集合中
            imageviews.add(imageView);
            //创建点
            ImageView point=new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(30,30);
            //不包括第0个所有的点距离左边有30个像素
            if(i!=0){
                params.leftMargin=30;
            }
            point.setLayoutParams(params);
            //添加到线性布局中
            point_group.addView(point);

        }
        //设置ViewPager的适配器
        viewpager.setAdapter(new MyPagerAdapter());
        //根据View的生命周期，当视图执行到onLayout或者onDraw的时候，视图的高和宽，边距都有了
        iv_red_point.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());

        //得到屏幕滑动的百分比
        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());

    }
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /**
         * 当页面发生变化了会回调这个方法
         * @param position 当前滑动页面的位置
         * @param positionOffset 页面滑动的百分比
         * @param positionOffsetPixels 滑动的像素
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            //两点间移动的距离 = 屏幕滑动百分比 * 间距
            //            int leftmargin = (int) (positionOffset * leftmax);

            //两点间滑动距离对应的坐标 = 原来的起始位置 +  两点间移动的距离
            int leftmargin = (int) (position*leftmax +  (positionOffset * leftmax));
            //params.leftMargin = 两点间滑动距离对应的坐标

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv_red_point.getLayoutParams();
            params.leftMargin = leftmargin;
            iv_red_point.setLayoutParams(params);

        }
        /**
         * 当页面被选中的时候，回调这个方法
         * @param position 被选中页面的对应的位置
         */
        @Override
        public void onPageSelected(int position) {
            if(position==imageviews.size()-1){
                //最后一个页面
                btn_start.setVisibility(View.VISIBLE);
            }else{
                //其他页面
                btn_start.setVisibility(View.GONE);
            }

        }

        /**
         * 当ViewPager页面滑动状态发生变化的时候
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

        @Override
        public void onGlobalLayout() {

            //执行不只一次，执行一次就移除监听
            iv_red_point.getViewTreeObserver().removeGlobalOnLayoutListener(MyOnGlobalLayoutListener.this);

            //            间距  = 第1个点距离左边的距离 - 第0个点距离左边的距离
            leftmax = point_group.getChildAt(1).getLeft() - point_group.getChildAt(0).getLeft();

        }
    }

        class MyPagerAdapter extends PagerAdapter{
            //返回数据的总个数
             @Override
             public int getCount() {
                 return imageviews.size();
             }
           //判断
             @Override
             public boolean isViewFromObject(View view, Object object) {
                 return view==object;
             }

             /**
              *
              * @param container viewPager
              * @param position   要创建页面的位置
              * @return   返回和创建当前页面有关系的值
              */
             @Override
             public Object instantiateItem(ViewGroup container, int position) {

                 ImageView  imageView=imageviews.get(position);
                 container.addView(imageView);
                 return  imageView;
                 //return super.instantiateItem(container, position);
             }

             /**
              *
              * @param container
              * @param position   要销毁页面的位置
              * @param object
              */
             @Override
             public void destroyItem(ViewGroup container, int position, Object object) {
                 //super.destroyItem(container, position, object);
                 container.removeView((View) object);
             }
         }
}
