package com.aserbao.aserbaoanimationsummart.classify.module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.activity.LauncherActivity;
import com.aserbao.aserbaoanimationsummart.classify.module.fragments.FragmentActivity;
import com.aserbao.aserbaoanimationsummart.classify.module.soundCode.SoundCodeActivity;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.UIActivity;

public class ModuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moudle);
    }

    public void btn_activity(View view) {
        startActivity(new Intent(this, LauncherActivity.class));
    }

    public void btn_fragment(View view) {
        startActivity(new Intent(this, FragmentActivity.class));
    }

    public void btn_ui(View view) {
        startActivity(new Intent(this, UIActivity.class));
    }

    public void btn_source_code(View view) {
        startActivity(new Intent(this, SoundCodeActivity.class));
    }
}
