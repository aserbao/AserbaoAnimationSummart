package com.aserbao.aserbaoanimationsummart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SurfaceViewSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view_summary);
    }

    public void btn_play_fish(View view) {
        startActivity(new Intent(this,PlayFishActivity.class));
    }
}
