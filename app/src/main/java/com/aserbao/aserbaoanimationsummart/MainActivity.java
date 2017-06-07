package com.aserbao.aserbaoanimationsummart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_onclick_move(View view) {
        startActivity(new Intent(this,MoveActivity.class));
    }

    public void btn_surface_view(View view) {
        startActivity(new Intent(this,SurfaceViewSummaryActivity.class));
    }
}
