package com.aserbao.aserbaoanimationsummart.classify.logic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.logic.rxJava.RxJavaActivity;

public class LogicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic);
    }

    public void btn_rxJava(View view) {
        startActivity(new Intent(this, RxJavaActivity.class));
    }
}
