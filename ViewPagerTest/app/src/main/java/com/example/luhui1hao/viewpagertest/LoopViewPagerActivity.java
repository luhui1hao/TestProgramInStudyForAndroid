package com.example.luhui1hao.viewpagertest;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.example.luhui1hao.viewpagertest.adapter.MyLoopViewPagerAdapter;
import com.example.luhui1hao.viewpagertest.pagertransformer.DepthPageTransformer;
import com.imbryk.viewPager.LoopViewPager;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class LoopViewPagerActivity extends AppCompatActivity {
    public static final int UPDATE_VIEWPAGER = 0x01;
    private LoopViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private int[] imgIdArr;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_view_pager_adapter);

        initView();
        startLoop();
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == UPDATE_VIEWPAGER){
                viewPager.setCurrentItem(msg.arg1, true);
            }
        }
    };

    private void startLoop() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int currentItem = viewPager.getCurrentItem();
                Message msg = handler.obtainMessage();
                msg.what = UPDATE_VIEWPAGER;
                msg.arg1 = ++currentItem;
                handler.sendMessage(msg);
            }
        }, 1000, 1000);
    }

    private void initView() {
        //获取图片资源数组
        Resources resources = getResources();
        TypedArray typedArray = resources.obtainTypedArray(R.array.image_id_arr);
        imgIdArr = new int[typedArray.length()];
        for (int i = 0; i < typedArray.length(); i++) {
            imgIdArr[i] = typedArray.getResourceId(i, 0);
        }

        //资源集合初始化!!!!!(会出错，原因不明，View的创建最好放在Adapter里)!!!!!
//        List<ImageView> list = new ArrayList<>();
//        for (int i = 0; i < imgIdArr.length; i++) {
//            ImageView imageView = new ImageView(LoopViewPagerActivity.this);
//            imageView.setImageResource(imgIdArr[i]);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//按比例缩放，使得内容充满容器
//            list.add(imageView);
//        }
        //ViewPager和Adapter的初始化
        viewPager = (LoopViewPager) findViewById(R.id.loopviewpager);
        pagerAdapter = new MyLoopViewPagerAdapter(this, imgIdArr);
        viewPager.setAdapter(pagerAdapter);
        //添加翻页动画
        viewPager.setPageTransformer(true, new DepthPageTransformer());
//        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        //加上indicator
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.loopindicator);
        indicator.setViewPager(viewPager);
    }
}
