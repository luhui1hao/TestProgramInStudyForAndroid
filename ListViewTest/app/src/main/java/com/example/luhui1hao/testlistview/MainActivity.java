package com.example.luhui1hao.testlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 *02-15 17:41:46.781 18632-18632/com.example.luhui1hao.testlistview D/luhui: position = 5convertViewId = 0
 *02-15 17:41:46.791 18632-18632/com.example.luhui1hao.testlistview D/luhui: position = 6convertViewId = 1
 *02-15 17:41:47.961 18632-18632/com.example.luhui1hao.testlistview D/luhui: position = 2convertViewId = 2
 *02-15 17:41:48.001 18632-18632/com.example.luhui1hao.testlistview D/luhui: position = 1convertViewId = 6
 *02-15 17:41:48.021 18632-18632/com.example.luhui1hao.testlistview D/luhui: position = 0convertViewId = 5
 *02-15 17:41:48.941 18632-18632/com.example.luhui1hao.testlistview D/luhui: position = 4convertViewId = 4
 *02-15 17:41:48.991 18632-18632/com.example.luhui1hao.testlistview D/luhui: position = 5convertViewId = 0
 *02-15 17:41:49.001 18632-18632/com.example.luhui1hao.testlistview D/luhui: position = 6convertViewId = 1
 *Log表明，被创建完成并被弹出的那个“Item的View”将被作为下一个要生成的Item的convertView！
 */
public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits = new ArrayList<>();
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        lv = (ListView) findViewById(R.id.lv);
        FruitAdapyer adapter = new FruitAdapyer(this, fruits);
        lv.setAdapter(adapter);
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
