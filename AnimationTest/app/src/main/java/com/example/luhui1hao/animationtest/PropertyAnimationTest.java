package com.example.luhui1hao.animationtest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 为什么要引入属性动画？
 * 1.补间动画比较单调，只有四种动画（渐变，缩放，平移，旋转）
 * 2.补间动画针对的甚至是继承了View的UI控件
 * 3.补间动画只是改变了View的显示效果，不会改变View的属性
 *
 * 属性动画是什么东西？
 *
 *你可以发现，补间动画如果一个动画还没结束，你执行下一个动画，会把前一个动画取消掉。
 * 而属性动画并不会，因为它修改的是Object的属性，而不是简单地视图重绘！！！
 */
public class PropertyAnimationTest extends Activity {

    private Button alphaBtn, scaleBtn, translationBtn, rotateBtn, setBtn;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation_test);

        initView();
    }

    private void initView() {
        BtnListener listener = new BtnListener();

        img = (ImageView) findViewById(R.id.property_anim_img);

        alphaBtn = (Button) findViewById(R.id.property_alpha_btn);
        scaleBtn = (Button) findViewById(R.id.property_scale_btn);
        translationBtn = (Button) findViewById(R.id.property_translation_btn);
        rotateBtn = (Button) findViewById(R.id.property_rotate_btn);
        setBtn = (Button) findViewById(R.id.property_set_btn);

        alphaBtn.setOnClickListener(listener);
        scaleBtn.setOnClickListener(listener);
        translationBtn.setOnClickListener(listener);
        rotateBtn.setOnClickListener(listener);
        setBtn.setOnClickListener(listener);
    }

    class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.property_alpha_btn:{
                    ObjectAnimator anim = ObjectAnimator.ofFloat(img, "alpha", 1f, 0f, 1f);
                    anim.setDuration(3000);
                    anim.start();
                    break;
                }
                case R.id.property_scale_btn:{
                    ObjectAnimator animator = ObjectAnimator.ofFloat(img, "scaleY", 1f, 3f, 1f);
                    animator.setDuration(3000);
                    animator.start();
                    break;
                }
                case R.id.property_translation_btn:{
                    float curTranslationX = translationBtn.getTranslationX();
                    ObjectAnimator anim = ObjectAnimator.ofFloat(translationBtn, "translationX", curTranslationX, curTranslationX+500f);
                    anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            float curValue = (float)animation.getAnimatedValue();
                            Log.i("luhui", curValue+"");
                        }
                    });
                    anim.setDuration(3000);
                    anim.start();
                    break;
                }
                case R.id.property_rotate_btn:{
                    ObjectAnimator anim = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    anim.setDuration(3000);
                    anim.start();
                    break;
                }
                case R.id.property_set_btn:{
                    ObjectAnimator moveIn = ObjectAnimator.ofFloat(img, "translationX", -500f, 0f);
                    ObjectAnimator rotate = ObjectAnimator.ofFloat(img, "rotation", 0f, 360f);
                    ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(img, "alpha", 1f, 0f, 1f);
                    AnimatorSet animSet = new AnimatorSet();
                    animSet.play(rotate).with(fadeInOut).after(moveIn);
                    animSet.setDuration(3000);
                    animSet.start();
                    break;
                }
            }
        }
    }
}
