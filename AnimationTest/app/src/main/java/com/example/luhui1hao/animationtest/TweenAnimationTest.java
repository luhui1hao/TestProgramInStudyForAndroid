package com.example.luhui1hao.animationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Andoird所支持的补间动画效果有如下这五种，或者说四种吧，第五种是前面几种的组合而已
 *
 *AlphaAnimation：透明度渐变效果，创建时许指定开始以及结束透明度，还有动画的持续 时间，透明度的变化范围(0,1)，0是完全透明，1是完全不透明；对应<alpha/>标签！
 *ScaleAnimation：缩放渐变效果，创建时需指定开始以及结束的缩放比，以及缩放参考点， 还有动画的持续时间；对应<scale/>标签！
 *TranslateAnimation：位移渐变效果，创建时指定起始以及结束位置，并指定动画的持续 时间即可；对应<translate/>标签！
 *RotateAnimation：旋转渐变效果，创建时指定动画起始以及结束的旋转角度，以及动画 持续时间和旋转的轴心；对应<rotate/>标签
 *AnimationSet：组合渐变，就是前面多种渐变的组合，对应<set/>标签
 */
public class TweenAnimationTest extends Activity {

    private Button alphaBtn,scaleBtn,translateBtn,rotateBtn,setBtn;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation_test);

        initView();
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);

        alphaBtn = (Button) findViewById(R.id.alphaBtn);
        scaleBtn = (Button) findViewById(R.id.scaleBtn);
        translateBtn = (Button) findViewById(R.id.translateBtn);
        rotateBtn = (Button) findViewById(R.id.rotateBtn);
        setBtn = (Button) findViewById(R.id.setBtn);

        BtnListener listener = new BtnListener();
        alphaBtn.setOnClickListener(listener);
        scaleBtn.setOnClickListener(listener);
        translateBtn.setOnClickListener(listener);
        rotateBtn.setOnClickListener(listener);
        setBtn.setOnClickListener(listener);
    }

    class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.alphaBtn:{
                    Animation animation = AnimationUtils.loadAnimation(TweenAnimationTest.this, R.anim.alpha_anim);
                    img.startAnimation(animation);
                    break;
                }
                case R.id.scaleBtn:{
                    Animation animation = AnimationUtils.loadAnimation(TweenAnimationTest.this, R.anim.scale_anim);
                    img.startAnimation(animation);
                    break;
                }
                case R.id.translateBtn:{
                    Animation animation = AnimationUtils.loadAnimation(TweenAnimationTest.this, R.anim.translate_anim);
                    img.startAnimation(animation);
                    break;
                }
                case R.id.rotateBtn:{
                    Animation animation = AnimationUtils.loadAnimation(TweenAnimationTest.this, R.anim.rotate_anim);
                    img.startAnimation(animation);
                    break;
                }
                case R.id.setBtn:{
                    Animation animation = AnimationUtils.loadAnimation(TweenAnimationTest.this, R.anim.set);
                    img.startAnimation(animation);
                    break;
                }
            }
        }
    }
}
