package com.example.luhui1hao.runtimepermissiontest;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 详情请看AndroidTraining和印象笔记
 * https://developer.android.com/training/permissions/requesting.html?hl=zh-cn
 */
public class MainActivity extends AppCompatActivity {

    public static final int MY_PERMISSIONS_REQUEST = 0x01;
    private Button checkBtn, requestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        checkBtn = (Button) findViewById(R.id.check_btn);
        requestBtn = (Button) findViewById(R.id.request_btn);

        BtnListener listener = new BtnListener();
        checkBtn.setOnClickListener(listener);
        requestBtn.setOnClickListener(listener);
    }

    private class BtnListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.check_btn) {
                checkPermission();
            } else if (id == R.id.request_btn) {
                requestPermission();
            }
        }

        private void requestPermission() {
            if(!checkPermission()){
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("使用权限说明")
                            .setMessage("需要将文件保存到SD卡上，为了确保程序正常运行，请务必允许")
                            .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ActivityCompat.requestPermissions(MainActivity.this,
                                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                                            MY_PERMISSIONS_REQUEST);
                                }
                            })
                            .show();

                } else {

                    // No explanation needed, we can request the permission.

                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            MY_PERMISSIONS_REQUEST);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            }else{
                Toast.makeText(MainActivity.this, "已授权，不需要请求", Toast.LENGTH_SHORT).show();
            }
        }

        private boolean checkPermission() {
            int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if(permissionCheck == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this, "已授权", Toast.LENGTH_SHORT).show();
                return true;
            }else{
                Toast.makeText(MainActivity.this, "未授权", Toast.LENGTH_SHORT).show();
                return false;
            }
        }


    }
}
