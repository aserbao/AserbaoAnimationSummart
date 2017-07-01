package com.aserbao.aserbaoanimationsummart.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;

public class UISummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uisummary);
    }

    public void btn_edit_click(View view) {
        startActivity(new Intent(this,EditTextActivity.class));
    }

    public void btn_recycler_view(View view) {
        startActivity(new Intent(this,RecyclerViewSummary.class));
    }
}
