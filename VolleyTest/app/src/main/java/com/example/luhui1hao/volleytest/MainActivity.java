package com.example.luhui1hao.volleytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;
    private Button stringRequestBtn, jsonRequestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initView();
    }

    private void initView() {
        stringRequestBtn = (Button) findViewById(R.id.string_request_btn);
        jsonRequestBtn = (Button) findViewById(R.id.json_request_btn);

        BtnListener listener = new BtnListener();
        stringRequestBtn.setOnClickListener(listener);
        jsonRequestBtn.setOnClickListener(listener);
    }

    private void init() {
        mQueue = Volley.newRequestQueue(getApplicationContext());
    }

    class BtnListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.string_request_btn) {
                execStringRequest();
            } else if (id == R.id.json_request_btn) {
                execJSONRequest();
            }
        }

        /**
         * 一个最基本的HTTP发送与响应的功能
         * <p>
         * 1. 创建一个RequestQueue对象。
         * 2. 创建一个StringRequest对象。
         * 3. 将StringRequest对象添加到RequestQueue里面。
         * <p>
         * 这里只是用了一个get方法，可以用四个参数的构造函数来创建post方法的请求方式
         */
        private void execStringRequest() {
            StringRequest stringRequest = new StringRequest("https://www.baidu.com",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("luhui", response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("luhui", error.getMessage(), error);
                }
            });

            mQueue.add(stringRequest);
        }

        /**
         * 获取JSON格式数据的方法
         */
        private void execJSONRequest() {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html", null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("luhui", response.toString());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("luhui", error.getMessage(), error);
                }
            });

            mQueue.add(jsonObjectRequest);
        }
    }



}
