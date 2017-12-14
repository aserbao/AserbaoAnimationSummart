package com.aserbao.aserbaoanimationsummart.classify.module.soundCode;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoundCodeActivity extends AppCompatActivity {

    public static final int AUTO_CLICK = 0;
    public static final int START_ACTION_MODE = 1;
    @BindView(R.id.btn_auto_click)
    Button mBtnAutoClick;

    private MyHandler mHandler = new MyHandler(this);
    private static class MyHandler extends Handler {
        private final WeakReference<SoundCodeActivity> mActivity;

        public MyHandler(SoundCodeActivity activity) {
            mActivity = new WeakReference<SoundCodeActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            SoundCodeActivity activity = mActivity.get();
            if (activity != null) {
                switch (msg.what){
                    case AUTO_CLICK:
                        activity.mBtnAutoClick.performClick();
                        break;
                    case START_ACTION_MODE:
                        break;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_code);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mBtnAutoClick.startActionMode(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.sendEmptyMessageDelayed(AUTO_CLICK,300);
    }

    public void btn_auto_click(View view) {
        Toast.makeText(this, "自动点击", Toast.LENGTH_SHORT).show();
    }
}
