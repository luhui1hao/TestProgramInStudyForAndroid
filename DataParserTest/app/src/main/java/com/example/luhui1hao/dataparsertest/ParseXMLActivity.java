package com.example.luhui1hao.dataparsertest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.luhui1hao.dataparsertest.bean.Person;
import com.example.luhui1hao.dataparsertest.xmlparser.pull.PullParserUtils;
import com.example.luhui1hao.dataparsertest.xmlparser.sax.SaxParserUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ParseXMLActivity extends AppCompatActivity {
    private Button saxParerBtn, pullParserBtn,pullgenerateBtn;
    private Button clearBtn;
    private TextView contentTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        initView();

    }

    private void initView() {
        saxParerBtn = (Button) findViewById(R.id.sax_parser_btn);
        pullParserBtn = (Button) findViewById(R.id.pull_parser_btn);
        pullgenerateBtn = (Button) findViewById(R.id.pull_generate_btn);
        clearBtn = (Button) findViewById(R.id.clear_btn);
        contentTv = (TextView) findViewById(R.id.content_tv);

        BtnListener listener = new BtnListener();

        saxParerBtn.setOnClickListener(listener);
        pullParserBtn.setOnClickListener(listener);
        pullgenerateBtn.setOnClickListener(listener);
        clearBtn.setOnClickListener(listener);
    }

    class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                //利用SAX解析XML
                case R.id.sax_parser_btn:{
                    InputStream inputStream = getResources().openRawResource(R.raw.cavaliers);
                    List<Person> list = new ArrayList<>();
                    try {
                        list = SaxParserUtils.parseXmlBySax(inputStream);
                        for(Person temp : list){
                            contentTv.append(temp.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                //利用PUll解析XML
                case R.id.pull_parser_btn:{
                    InputStream inputStream = getResources().openRawResource(R.raw.cavaliers);
                    List<Person> list = new ArrayList<>();
                    try {
                        list = PullParserUtils.parseXmlByPull(inputStream);
                        for(Person temp : list){
                            contentTv.append(temp.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                //利用PULL生成XML
                case R.id.pull_generate_btn:{
                    InputStream inputStream = getResources().openRawResource(R.raw.cavaliers);
                    List<Person> list = new ArrayList<>();
                    try {
                        list = PullParserUtils.parseXmlByPull(inputStream);
                        //生成OutputStream
                        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/克里夫兰骑士队.xml";
                        File file = new File(path);
                        if(!file.exists()){
                            file.createNewFile();
                        }
                        OutputStream os = new FileOutputStream(file);
                        PullParserUtils.generateXMLByPull(list, os);
                        //然后再读取出来显示在TextView上
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                        String temp = "";
                        StringBuilder sb = new StringBuilder();
                        while((temp = br.readLine()) != null){
                            sb.append(temp);
                        }
                        contentTv.setText(sb.toString());
                        //加分割线
                        contentTv.append("\n\n********************\n\n");
                        //显示解析到的内容
                        for(Person p : list){
                            contentTv.append(p.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case R.id.clear_btn:{
                    contentTv.setText("");
                    break;
                }
            }
        }
    }
}
