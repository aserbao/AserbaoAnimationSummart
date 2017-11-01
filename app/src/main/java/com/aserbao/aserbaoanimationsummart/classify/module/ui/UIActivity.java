package com.aserbao.aserbaoanimationsummart.classify.module.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.coordinatorLayout.CoordinatorLayoutActivity;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.RecyclerViewActivity;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.scrollview.ScrollViewActivity;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.smartRefreshLayout
        .SmartRefreshLayoutActivity;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.timepicker.TimePickerActivity;

public class UIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
    }

    public void btn_recycler(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void btn_coordinatorLayout(View view) {
        startActivity(new Intent(this, CoordinatorLayoutActivity.class));
    }

    public void btn_scroll_view(View view) {
        startActivity(new Intent(this, ScrollViewActivity.class));
    }

    public void btn_time_picker(View view) {
        startActivity(new Intent(this, TimePickerActivity.class));
    }

    public void btn_smart_refresh_layout(View view) {
        startActivity(new Intent(this, SmartRefreshLayoutActivity.class));
    }
}
