package com.example.luhui1hao.viewpagertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.viewpager_btn);
        btn2 = (Button) findViewById(R.id.fragment_viewpager_btn);
        btn3 = (Button) findViewById(R.id.carousel_figure_btn);

        BtnListener listener = new BtnListener();

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
    }

    private class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if(id == R.id.viewpager_btn){
                Intent intent = new Intent(MainActivity.this, PagerAdapterActivity.class);
                startActivity(intent);
            }else if(id == R.id.fragment_viewpager_btn){
                Intent intent = new Intent(MainActivity.this, FragmentPagerAdapterActivity.class);
                startActivity(intent);
            }else if(id == R.id.carousel_figure_btn){
                Intent intent = new Intent(MainActivity.this, LoopViewPagerActivity.class);
                startActivity(intent);
            }
        }
    }
}
