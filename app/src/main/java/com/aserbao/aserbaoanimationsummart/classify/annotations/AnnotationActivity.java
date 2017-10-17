package com.aserbao.aserbaoanimationsummart.classify.annotations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo1.Annotation1Activity;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo2.Annotation2Activity;

public class AnnotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
    }
    public void btn_demo1(View view) {
        startActivity(new Intent(this, Annotation1Activity.class));
    }

    public void btn_demo2(View view) {
        startActivity(new Intent(this, Annotation2Activity.class));
    }
}
