package com.example.luhui1hao.animationtest;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class FrameAnimationTest extends Activity {

    private ImageView frameAnimImg, frameAnimImg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation_test);

        frameAnimImg = (ImageView) findViewById(R.id.frame_anim_img);
        AnimationDrawable animationDrawable = (AnimationDrawable)frameAnimImg.getDrawable();
        animationDrawable.start();

        frameAnimImg2 = (ImageView) findViewById(R.id.frame_anim_img2);
        AnimationDrawable animationDrawable2 = (AnimationDrawable) frameAnimImg2.getDrawable();
        animationDrawable2.start();
    }
}
