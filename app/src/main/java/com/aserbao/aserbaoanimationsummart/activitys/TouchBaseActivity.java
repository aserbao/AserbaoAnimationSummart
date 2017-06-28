package com.aserbao.aserbaoanimationsummart.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.listener.GestureDetectorActivity;

public class TouchBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_base);
    }

    public void btn_gesture(View view) {
        startActivity(new Intent(this, GestureDetectorActivity.class));
    }

    public void btn_dispatch(View view) {
        startActivity(new Intent(this, DispatchActivity.class));
    }
}
