package com.example.luhui1hao.dataparsertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.luhui1hao.dataparsertest.utils.PermissionUtil;

public class MainActivity extends AppCompatActivity {

    private Button xmlBtn,jsonBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        PermissionUtil.checkPermission(this);
    }

    private void initView() {
        setContentView(R.layout.activity_main);

        xmlBtn = (Button) findViewById(R.id.xml_btn);
        jsonBtn = (Button) findViewById(R.id.json_btn);

        BtnLstener listener = new BtnLstener();
        xmlBtn.setOnClickListener(listener);
        jsonBtn.setOnClickListener(listener);
    }

    class BtnLstener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            int id = view.getId();
            if(id == R.id.xml_btn){
                startActivity(new Intent(getApplicationContext(), ParseXMLActivity.class));
            }else if(id == R.id.json_btn){
                startActivity(new Intent(getApplicationContext(), ParseJSONActivity.class));
            }
        }
    }
}
