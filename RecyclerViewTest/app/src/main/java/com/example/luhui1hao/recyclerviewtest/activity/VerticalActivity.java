package com.example.luhui1hao.recyclerviewtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.luhui1hao.recyclerviewtest.R;
import com.example.luhui1hao.recyclerviewtest.adapter.FruitAdapter;
import com.example.luhui1hao.recyclerviewtest.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class VerticalActivity extends AppCompatActivity {

    private List<Fruit> fruits = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        initData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        //指定layoutManager的布局方式
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruits);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        Fruit fruit1 = new Fruit(0, "苹果", "红色");
        Fruit fruit2 = new Fruit(1, "苹果", "黄色");
        Fruit fruit3 = new Fruit(2, "苹果", "绿色");
        Fruit fruit4 = new Fruit(3, "橙子", "橙色");
        Fruit fruit5 = new Fruit(4, "桃子", "粉色");
        Fruit fruit6 = new Fruit(5, "梨子", "黄色");
        Fruit fruit7 = new Fruit(6, "枣子", "红色");
        fruits.add(fruit1);
        fruits.add(fruit2);
        fruits.add(fruit3);
        fruits.add(fruit4);
        fruits.add(fruit5);
        fruits.add(fruit6);
        fruits.add(fruit7);
    }
}
