package com.example.luhui1hao.viewpagertest;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.luhui1hao.viewpagertest.adapter.MyViewPagerAdapter;
import com.example.luhui1hao.viewpagertest.pagertransformer.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class PagerAdapterActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private int[] imgIdArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_adapter);

        initView();
    }

    private void initView() {
//        imgIdArr = getResources().getIntArray(R.array.image_id_arr);//图片数组初始化
//        imgIdArr = new int[]{R.drawable.girl1,
//                R.drawable.girl2,
//                R.drawable.girl3,
//                R.drawable.girl4,
//                R.drawable.girl5};
        //获取图片资源数组
        Resources resources = getResources();
        TypedArray typedArray = resources.obtainTypedArray(R.array.image_id_arr);
        imgIdArr = new int[typedArray.length()];
        for (int i = 0; i < typedArray.length(); i++) {
            imgIdArr[i] = typedArray.getResourceId(i, 0);
        }

        //资源集合初始化
        List<ImageView> list = new ArrayList<>();
        for (int i = 0; i < imgIdArr.length; i++) {
            ImageView imageView = new ImageView(PagerAdapterActivity.this);
            imageView.setImageResource(imgIdArr[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//按比例缩放，使得内容充满容器
            list.add(imageView);
        }
        //ViewPager和Adapter的初始化
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        pagerAdapter = new MyViewPagerAdapter(list);
        viewPager.setAdapter(pagerAdapter);
        //添加翻页动画
        viewPager.setPageTransformer(true, new DepthPageTransformer());
//        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        //加上indicator
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
    }
}
