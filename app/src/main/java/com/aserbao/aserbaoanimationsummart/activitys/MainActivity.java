package com.aserbao.aserbaoanimationsummart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.canvasAndPaint.CanvasAndPaintActivity;
import com.aserbao.aserbaoanimationsummart.sendgif.SendGifActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_onclick_move(View view) {
        startActivity(new Intent(this,MoveActivity.class));
    }

    public void btn_stereo_animation(View view) {
        startActivity(new Intent(this,StereoSummaryActivity.class));
    }

    public void btn_surface_view(View view) {
        startActivity(new Intent(this,SurfaceViewSummaryActivity.class));
    }

    public void btn_send_gif(View view) {
        startActivity(new Intent(this,SendGifActivity.class));
    }

    public void btn_onclick_draw_image(View view) {
        startActivity(new Intent(this,CanvasAndPaintActivity.class));
    }
}
