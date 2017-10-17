package com.aserbao.aserbaoanimationsummart.classify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.annotations.AnnotationActivity;
import com.aserbao.aserbaoanimationsummart.classify.dynamicproxy.DynamicActivity;
import com.aserbao.aserbaoanimationsummart.classify.logic.LogicActivity;
import com.aserbao.aserbaoanimationsummart.classify.module.ModuleActivity;

public class ClassifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);
    }


    public void btn_logic(View view) {
        startActivity(new Intent(this, LogicActivity.class));
    }

    public void btn_module(View view) {
        startActivity(new Intent(this, ModuleActivity.class));
    }

    public void btn_annotation(View view) {
        startActivity(new Intent(this, AnnotationActivity.class));
    }

    public void btn_dynamic(View view) {
        startActivity(new Intent(this, DynamicActivity.class));
    }
}
