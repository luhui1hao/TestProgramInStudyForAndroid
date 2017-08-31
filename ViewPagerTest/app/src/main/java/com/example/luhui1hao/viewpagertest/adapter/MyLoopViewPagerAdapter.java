package com.example.luhui1hao.viewpagertest.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.luhui1hao.viewpagertest.R;

/**
 * Created by luhui on 2017/1/25.
 */

public class MyLoopViewPagerAdapter extends PagerAdapter {
    private int[] imgIdArr;
    private int mSize;
    private Context mContext;

    public MyLoopViewPagerAdapter(Context mContext, int[] imgIdArr){
        this.mSize = imgIdArr.length;
        this.imgIdArr = imgIdArr;
        this.mContext = mContext;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.loopviewpager_item_layout, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.img);
        iv.setImageResource(imgIdArr[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
