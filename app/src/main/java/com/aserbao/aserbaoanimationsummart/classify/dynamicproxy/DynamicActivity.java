package com.aserbao.aserbaoanimationsummart.classify.dynamicproxy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.dynamicproxy.Demo1.Dynamic1Activity;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
    }

    public void btn_dynamic_one(View view) {
        startActivity(new Intent(this, Dynamic1Activity.class));
    }
    public void btn_dynamic_two(View view) {
    }
}
