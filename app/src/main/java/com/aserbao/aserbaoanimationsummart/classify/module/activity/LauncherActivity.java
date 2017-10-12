package com.aserbao.aserbaoanimationsummart.classify.module.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;

public class LauncherActivity extends AppCompatActivity {

    private long exitTime  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            moveTaskToBack(false);
           /* System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());*/
        }
    }
}
