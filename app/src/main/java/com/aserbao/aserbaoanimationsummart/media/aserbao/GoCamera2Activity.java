package com.aserbao.aserbaoanimationsummart.media.aserbao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aserbao.aserbaoanimationsummart.R;

public class GoCamera2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_camera2);
        if (savedInstanceState == null) {
            /*getFragmentManager().beginTransaction().replace(R.id.container,Camera2Fragment.newInstance())
                    .commit();*/
        }
    }
}
