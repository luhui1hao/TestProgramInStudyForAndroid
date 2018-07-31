package com.example.luhui1hao.viewpagertest;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.luhui1hao.viewpagertest.adapter.MyFragmentPagerAdapter;
import com.example.luhui1hao.viewpagertest.fragment.ImageFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagerAdapterActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MyFragmentPagerAdapter adapter;
    private int[] imgIdArr;
    private List<ImageFragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager_adapter);

        initView();
        init();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.fragment_viewpager);
    }

    private void init() {
        //获取图片资源数组
        Resources resources = getResources();
        TypedArray typedArray = resources.obtainTypedArray(R.array.image_id_arr);
        imgIdArr = new int[typedArray.length()];
        for (int i = 0; i < typedArray.length(); i++) {
            imgIdArr[i] = typedArray.getResourceId(i, 0);
        }

        for (int i = 0; i < imgIdArr.length; i++) {
            ImageFragment fragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("imgId", imgIdArr[i]);
            fragment.setArguments(bundle);

            list.add(fragment);
        }

        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
    }
}
