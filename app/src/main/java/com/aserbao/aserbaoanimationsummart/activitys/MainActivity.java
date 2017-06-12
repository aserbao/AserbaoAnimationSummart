package com.aserbao.aserbaoanimationsummart.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.MoveScaleActivity;
import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.StereoSummaryActivity;
import com.aserbao.aserbaoanimationsummart.SurfaceViewSummaryActivity;
import com.aserbao.aserbaoanimationsummart.canvasAndPaint.CanvasAndPaintActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_onclick_move(View view) {
        startActivity(new Intent(this,MoveScaleActivity.class));
    }

    public void btn_stereo_animation(View view) {
        startActivity(new Intent(this,StereoSummaryActivity.class));
    }

    public void btn_surface_view(View view) {
        startActivity(new Intent(this,SurfaceViewSummaryActivity.class));
    }

    public void btn_onclick_draw_image(View view) {
        startActivity(new Intent(this,CanvasAndPaintActivity.class));
    }
}
