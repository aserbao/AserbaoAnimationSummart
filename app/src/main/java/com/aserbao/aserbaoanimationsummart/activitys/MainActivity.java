package com.aserbao.aserbaoanimationsummart.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.MoveActivity;
import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.StereoSummaryActivity;
import com.aserbao.aserbaoanimationsummart.SurfaceViewSummaryActivity;
import com.aserbao.aserbaoanimationsummart.canvasAndPaint.CanvasAndPaintActivity;
import com.aserbao.aserbaoanimationsummart.sendgif.SendGifActivity;
import com.aserbao.aserbaolibrary.activity.AserbaoActivity;

public class MainActivity extends AppCompatActivity {

    private int num = 0;

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

    public void start_activity(View view) {
        Toast.makeText(this, String.valueOf(num), Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, AserbaoActivity.class);
        startActivityForResult(it, 0);
        switch (num){
            case 0:
                overridePendingTransition(R.anim.fade, R.anim.hold);
                break;
            case 1:
                overridePendingTransition(R.anim.my_scale_action,
                        R.anim.my_alpha_action);
                break;
            case 2:
                overridePendingTransition(R.anim.scale_rotate,
                        R.anim.my_alpha_action);
                break;
            case 3:
                overridePendingTransition(R.anim.scale_translate_rotate,
                        R.anim.my_alpha_action);
                break;
            case 4:
                overridePendingTransition(R.anim.scale_translate,
                        R.anim.my_alpha_action);
                break;
            case 5:
                overridePendingTransition(R.anim.hyperspace_in,
                        R.anim.hyperspace_out);
                break;
            case 6:
                overridePendingTransition(R.anim.push_left_in,
                        R.anim.push_left_out);
                break;
            case 7:
                overridePendingTransition(R.anim.push_up_in,
                        R.anim.push_up_out);
                break;
            case 8:
                overridePendingTransition(R.anim.slide_left,
                        R.anim.slide_right);
                break;
            case 9:
                overridePendingTransition(R.anim.wave_scale,
                        R.anim.my_alpha_action);
                break;
            case 10:
                overridePendingTransition(R.anim.zoom_enter,
                        R.anim.zoom_exit);
                break;
            case 11:
                overridePendingTransition(R.anim.slide_up_in,
                        R.anim.slide_down_out);
                break;
        }
        num ++;
    }
}
