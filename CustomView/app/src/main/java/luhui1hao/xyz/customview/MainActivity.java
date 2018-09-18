package luhui1hao.xyz.customview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hencoder.hencoderpracticedraw1.Practice1MainActivity;

public class MainActivity extends ListActivity {

    private String[] titles = new String[]{"Canvas 的 drawXXX() 系列方法及 Paint 最常见的使用"};
    private Class[] clazzs = new Class[]{Practice1MainActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titles);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(this, clazzs[position]);
        startActivity(intent);
    }
}
