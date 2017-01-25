package com.example.luhui1hao.viewpagertest.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by luhui on 2017/1/25.
 */

public class MyLoopViewPagerAdapter extends PagerAdapter {
    private int[] imgIdArr;
    private int mSize;

    public MyLoopViewPagerAdapter(int[] imgIdArr){
        this.mSize = imgIdArr.length;
        this.imgIdArr = imgIdArr;
    }

    @Override
    public int getCount() {
        return mSize;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d("luhui", position+"");
        ImageView iv = new ImageView(container.getContext());
        iv.setImageResource(imgIdArr[position]);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);//按比例缩放，使得内容充满容器
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
