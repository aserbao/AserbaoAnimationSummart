package com.aserbao.aserbaoanimationsummart.classify.module.ui.progressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.progressbar.views.MediaObject;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.progressbar.views.ProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressBarActivity extends AppCompatActivity {

    @BindView(R.id.progress_view)
    ProgressView mProgressView;
    @BindView(R.id.btn_start)
    Button mBtnStart;
    @BindView(R.id.btn_stop)
    Button mBtnStop;
    private long mStartTime;
    private MediaObject mMediaObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        ButterKnife.bind(this);
        mMediaObject = new MediaObject();
    }

    @OnClick({R.id.btn_start, R.id.btn_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                mStartTime = System.currentTimeMillis();
                break;
            case R.id.btn_stop:
                int l = (int)(System.currentTimeMillis() - mStartTime);
                mMediaObject.buildMediaPart("s",l);
                break;
        }
    }
}
