package com.aserbao.aserbaoanimationsummart.classify.permission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission3);
    }

    public void btn_permission_one(View view) {
        startActivity(new Intent(this,Permission1Activity.class));
    }
    public void btn_permission_two(View view) {
        startActivity(new Intent(this,Permission2Activity.class));
    }
}
