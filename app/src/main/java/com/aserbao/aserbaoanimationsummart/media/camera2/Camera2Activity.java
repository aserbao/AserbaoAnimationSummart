package com.aserbao.aserbaoanimationsummart.media.camera2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.aserbao.aserbaoanimationsummart.R;
import com.linj.camera.view.CameraContainer;

public class Camera2Activity extends AppCompatActivity implements CameraContainer.TakePictureListener{
    private CameraContainer mContainer;
    private String mSaveRoot;
    private boolean isRecording=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_camera2);
        mContainer=(CameraContainer)findViewById(R.id.container);
        mSaveRoot="aserbao";
        mContainer.setRootPath(mSaveRoot);
    }

    public void show(View view) {
        startActivity(new Intent(this,AlbumAty.class));
    }
    public void stop(View view) {
        if (isRecording) {
            stopRecord();
        }
    }
    public void start(View view) {
        isRecording = mContainer.startRecord();
    }
    private void stopRecord() {
        mContainer.stopRecord(this);
        isRecording=false;
    }

    @Override
    public void onTakePictureEnd(Bitmap bm) {

    }

    @Override
    public void onAnimtionEnd(Bitmap bm, boolean isVideo) {

    }
}
