package com.aserbao.aserbaoanimationsummart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.aserbao.aserbaoanimationsummart.media.MediaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SummaryActivity extends AppCompatActivity {

    @BindView(R.id.btn_animation)
    Button mBtnAnimation;
    @BindView(R.id.btn_media)
    Button mBtnMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_animation, R.id.btn_media})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_animation:
                startActivity(new Intent(this, com.aserbao.aserbaoanimationsummart.MainActivity.class));
                break;
            case R.id.btn_media:
                startActivity(new Intent(this,MediaActivity.class));
                break;
        }
    }
}
