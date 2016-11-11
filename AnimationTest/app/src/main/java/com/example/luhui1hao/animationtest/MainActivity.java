package com.example.luhui1hao.animationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button tweenBtn, frameBtn, propertyBtn, highPropertyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tweenBtn = (Button) findViewById(R.id.tween_anim_btn);
        frameBtn = (Button) findViewById(R.id.frame_anim_btn);
        propertyBtn = (Button) findViewById(R.id.property_anim_btn);
        highPropertyBtn = (Button) findViewById(R.id.property_anim_high_btn);

        BtnListener listener = new BtnListener();
        tweenBtn.setOnClickListener(listener);
        frameBtn.setOnClickListener(listener);
        propertyBtn.setOnClickListener(listener);
        highPropertyBtn.setOnClickListener(listener);
    }

    class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.tween_anim_btn:{
                    /**
                     * 补间动画本质上是动画对象，所以是通过View的方法进行播放的
                     */
                    Intent intent = new Intent(MainActivity.this, TweenAnimationTest.class);
                    startActivity(intent);
                    break;
                }
                case R.id.frame_anim_btn:{
                    /**
                     * 逐帧动画本质上是属于Drawable，所以是通过Drawable的方法进行播放的
                     */
                    Intent intent = new Intent(MainActivity.this, FrameAnimationTest.class);
                    startActivity(intent);
                    break;
                }
                case R.id.property_anim_btn:{
                    Intent intent = new Intent(MainActivity.this, PropertyAnimationTest.class);
                    startActivity(intent);
                    break;
                }
                case R.id.property_anim_high_btn:{
                    Intent intent = new Intent(MainActivity.this, HighLevelPropertyAnimationTest.class);
                    startActivity(intent);
                    break;
                }
            }
        }
    }
}
