package com.aserbao.aserbaoanimationsummart.media.aserbao;

import android.graphics.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.aserbao.aserbaoanimationsummart.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoCamera2Activity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_camera2);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().replace(R.id.container,Camera2Fragment.newInstance())
                    .commit();
        }
    }
}
