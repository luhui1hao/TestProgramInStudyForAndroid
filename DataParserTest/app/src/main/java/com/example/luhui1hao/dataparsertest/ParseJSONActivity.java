package com.example.luhui1hao.dataparsertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.luhui1hao.dataparsertest.bean.Person;
import com.example.luhui1hao.dataparsertest.jsonparser.gson.GsonUtil;
import com.example.luhui1hao.dataparsertest.jsonparser.org.json.JSONParserUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luhui on 2016/12/26.
 */
public class ParseJSONActivity extends AppCompatActivity {

    private Button orgParseBtn, orgGenerateBtn, clearBtn, gsonParseBtn,gsonGenerateBtn;
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_json);

        tv = (TextView) findViewById(R.id.content_json_tv);
        orgParseBtn = (Button) findViewById(R.id.org_json_parser_btn);
        clearBtn = (Button) findViewById(R.id.clear_json_btn);
        orgGenerateBtn = (Button) findViewById(R.id.org_json_generate_btn);
        gsonParseBtn = (Button) findViewById(R.id.gson_parser_btn);
        gsonGenerateBtn = (Button) findViewById(R.id.gson_generate_btn);

        BtnListener listener = new BtnListener();
        orgParseBtn.setOnClickListener(listener);
        clearBtn.setOnClickListener(listener);
        orgGenerateBtn.setOnClickListener(listener);
        gsonParseBtn.setOnClickListener(listener);
        gsonGenerateBtn.setOnClickListener(listener);

    }

    class BtnListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.org_json_parser_btn) {
                try {
                    //通过inputStream获取集合
                    List<Person> persons = JSONParserUtils.parseEasyJsonWithIs(getResources().openRawResource(R.raw.cavaliers_json));
                    //将数据显示出来
                    for(Person temp : persons){
                        tv.append(temp.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (id == R.id.org_json_generate_btn) {
                String temp = JSONParserUtils.generateEasyJson();
                tv.append(temp);
            } else if(id == R.id.clear_json_btn){
                tv.setText("");
            } else if (id == R.id.gson_parser_btn){
                List<Person> list;
                list = GsonUtil.JsonArray2JavaList(getContentFromRaw(), Person.class);
                for(Person person : list){
                    tv.append(person.toString());
                }
            } else if(id == R.id.gson_generate_btn){
                List<Person> list;
                list = GsonUtil.JsonArray2JavaList(getContentFromRaw(), Person.class);
                String jsonStr = GsonUtil.JavaList2Json((ArrayList) list);
                tv.append(jsonStr);
            }
        }

        private String getContentFromRaw(){
            InputStream is = getResources().openRawResource(R.raw.cavaliers_json);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(is)));
            StringBuilder sb = new StringBuilder();
            String temp;
            try {
                while((temp = reader.readLine()) != null){
                    sb.append(temp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return sb.toString();
        }
    }
}
