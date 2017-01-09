package com.example.administrator.permissiontest;


import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void ButtonStart(View view){
           BaseActivity.requestRunTimePermission(new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, new IPermission() {
               @Override
               public void onGranted() {
                   doSomeThing();
               }

               @Override
               public void onDenied(List<String> deniedPermissions) {
                   for (String deniedPermission : deniedPermissions) {

                   Toast.makeText(MainActivity.this, "被拒绝的权限是"+deniedPermission, Toast.LENGTH_SHORT).show();
                   }
               }
           });

    }

    private void doSomeThing() {
        Toast.makeText(MainActivity.this,"所以权限都可以用", Toast.LENGTH_SHORT).show();
    }


}
