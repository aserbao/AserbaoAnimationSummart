package com.aserbao.aserbaoanimationsummart.classify.permission;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;

public class Permission2Activity extends AppCompatActivity {
    private final String[] BASIC_PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private AlertDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission2);
        init();
    }

    private void init() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            startRequestPermission();
        }
    }

    private void showDialogTipUerRequestPermission(){
        mDialog = new AlertDialog.Builder(this)
                .setTitle("权限不可用")
                .setMessage("由于缓存需要存储权限，为你存储个人信息，若不同意，我们将没法进行下一步。")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startRequestPermission();
                    }
                })
                .setNegativeButton("拒绝，打死不开", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDialog.dismiss();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this,BASIC_PERMISSIONS,123);
    }


    //用户权限申请的回调方法
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 123){
            checkPermission();
        }
    }

    private void checkPermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            for (String s : BASIC_PERMISSIONS) {
                boolean b = shouldShowRequestPermissionRationale(s);
                if(!b){
                    showDialogTipUerRequestSetting();
                    break;
                }
                if(s == BASIC_PERMISSIONS[BASIC_PERMISSIONS.length-1]){
                    Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void showDialogTipUerRequestSetting() {
        mDialog = new AlertDialog.Builder(this).setTitle("权限不可用")
                .setMessage("请到应用设置-权限中，允许当前应用的部分权限")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gotoSetting();
                    }
                })
                .setNegativeButton("打死不开", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDialog.dismiss();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void gotoSetting() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent,321);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 321){
            checkPermission();
        }
    }
}
