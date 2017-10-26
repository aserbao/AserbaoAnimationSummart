package com.aserbao.aserbaoanimationsummart.classify.module.ui.coordinatorLayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.coordinatorLayout.demo1.CoordinatorLayout1Activity;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.coordinatorLayout.demo1.CoordinatorLayout2Activity;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
    }

    public void btn_simple(View view) {
        startActivity(new Intent(this, CoordinatorLayout1Activity.class));
    }

    public void btn_simple_custom(View view) {
        startActivity(new Intent(this, CoordinatorLayout2Activity.class));
    }
}
