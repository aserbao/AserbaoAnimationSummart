package com.aserbao.aserbaoanimationsummart.media.aserbao;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.media.aserbao.surface.SurfacePreview;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoCameraActivity extends AppCompatActivity implements Camera.PictureCallback{


    @BindView(R.id.fragment)
    FrameLayout mFrameLayout;
    private SurfacePreviews mSurfacePreviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_camera);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mSurfacePreviews = new SurfacePreviews(this);
        mFrameLayout.addView(mSurfacePreviews);
    }


    @Override
    public void onPictureTaken(byte[] data, Camera camera) {

    }
}
