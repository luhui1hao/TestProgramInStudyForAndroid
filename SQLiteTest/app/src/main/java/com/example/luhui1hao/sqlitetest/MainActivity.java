package com.example.luhui1hao.sqlitetest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.luhui1hao.sqlitetest.sqlite.MySQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    private TextView idTv, nameTv, urlTv, alexaTv, countryTv;
    private StringBuilder info = new StringBuilder();
    private Button insertBtn,upDateBtn,initBtn,deleteBtn,queryBtn;

    MySQLiteOpenHelper helper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = MySQLiteOpenHelper.getInstance(this);
        database = helper.getReadableDatabase();

        initView();
        helper.initData("Websites");
        updateUI();
    }

    private void initView() {
        idTv = (TextView) findViewById(R.id.id);
        nameTv = (TextView) findViewById(R.id.name);
        urlTv = (TextView) findViewById(R.id.url);
        alexaTv = (TextView) findViewById(R.id.alexa);
        countryTv = (TextView) findViewById(R.id.country);

        initBtn = (Button) findViewById(R.id.initBtn);
        insertBtn = (Button) findViewById(R.id.insertBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        upDateBtn = (Button) findViewById(R.id.updateBtn);
        queryBtn = (Button) findViewById(R.id.queryBtn);

        BtnOnClickListener listener = new BtnOnClickListener();
        initBtn.setOnClickListener(listener);
        insertBtn.setOnClickListener(listener);
        deleteBtn.setOnClickListener(listener);
        upDateBtn.setOnClickListener(listener);
        queryBtn.setOnClickListener(listener);
    }

    private class BtnOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.initBtn:
                    helper.initData("Websites");
                    break;
                case R.id.insertBtn:
                    helper.insertData2("Websites", "name", "url", 1, "CN");
                    break;
                case R.id.deleteBtn:
                    helper.deleteData();
                    break;
                case R.id.updateBtn:
                    helper.updateData();
                    break;
                case R.id.queryBtn:
                    break;
            }
            updateUI();
        }
    }

    private void updateUI(){
        //清空TextView
        idTv.setText("id");
        nameTv.setText("name");
        urlTv.setText("url");
        alexaTv.setText("alexa");
        countryTv.setText("country");
        //
        Cursor cursor = database.query("Websites", null, null, null, null, null, null);
        Log.i("luhui", "rows num is " + cursor.getCount());
        Log.i("luhui", "moveToFirst() retuen " + cursor.moveToFirst());
        if (cursor.moveToFirst()) {
            do {
                Log.i("luhui", "one");
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String url = cursor.getString(cursor.getColumnIndex("url"));
                int alexa = cursor.getInt(cursor.getColumnIndex("alexa"));
                String country = cursor.getString(cursor.getColumnIndex("country"));

                idTv.append("\n" + id);
                nameTv.append("\n" + name);
                urlTv.append("\n" + url);
                alexaTv.append("\n" + alexa);
                countryTv.append("\n" + country);
            } while (cursor.moveToNext());
            cursor.close();
        }
    }
}
