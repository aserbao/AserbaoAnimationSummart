package com.aserbao.aserbaoanimationsummart.media;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.media.aserbaoCamera.AserbaoCameraActivity;
import com.aserbao.aserbaoanimationsummart.media.aserbao.GoCameraActivity;
import com.aserbao.aserbaoanimationsummart.media.camera.CameraActivity;
import com.aserbao.aserbaoanimationsummart.media.camera2.Camera2Activity;
import com.aserbao.aserbaoanimationsummart.media.record.RecordActivity;
import com.aserbao.aserbaoanimationsummart.media.record.VideoRecordActivity;
import com.aserbao.aserbaolibrary.activity.Mp4Activity;

public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
    }
    public void btn_camera(View view) {
        startActivity(new Intent(this, CameraActivity.class));
    }

    public void btn_camera2(View view) {
        startActivity(new Intent(this, Camera2Activity.class));
    }


    public void btn_media_record(View view) {
        startActivity(new Intent(this, RecordActivity.class));
    }

    public void btn_aserbao_camera(View view) {
        startActivity(new Intent(this, AserbaoCameraActivity.class));
    }

    public void btn_video_record(View view) {
        startActivity(new Intent(this, VideoRecordActivity.class));
    }

    public void btn_fu_media_record(View view) {

    }

    public void btn_compound(View view) {
        startActivity(new Intent(this, Mp4Activity.class));
    }

    public void go_camera(View view) {
        startActivity(new Intent(this, GoCameraActivity.class));
    }
}
