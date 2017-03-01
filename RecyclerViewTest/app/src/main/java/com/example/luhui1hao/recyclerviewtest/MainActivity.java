package com.example.luhui1hao.recyclerviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.luhui1hao.recyclerviewtest.activity.HorizontalActivity;
import com.example.luhui1hao.recyclerviewtest.activity.StaggeredGridActivity;
import com.example.luhui1hao.recyclerviewtest.activity.VerticalActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vertical_btn)
    Button verticalBtn;
    @BindView(R.id.horizontal_btn)
    Button horizontalBtn;
    @BindView(R.id.staggered_grid_vertical_btn)
    Button staggeredGridVerticalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.vertical_btn, R.id.horizontal_btn, R.id.staggered_grid_vertical_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.vertical_btn: {
                Intent intent = new Intent(MainActivity.this, VerticalActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.horizontal_btn: {
                Intent intent = new Intent(MainActivity.this, HorizontalActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.staggered_grid_vertical_btn:{
                Intent intent = new Intent(MainActivity.this, StaggeredGridActivity.class);
                startActivity(intent);
            }
            break;
        }
    }

}
