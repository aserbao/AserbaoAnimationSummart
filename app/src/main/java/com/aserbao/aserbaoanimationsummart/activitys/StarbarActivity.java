package com.aserbao.aserbaoanimationsummart.activitys;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoutils.window.AStatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StarbarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    public static final int SET_COLOR = 1;
    public static final int SETCOLORFORSWIPEBACK = 2;
    public static final int SETTRANSLUCENT = 3;
    public static final int SETTRANSLUCENTFORIMAGEVIEW = 4;
    @BindView(R.id.seek_bar)
    SeekBar mSeekBar;
    @BindView(R.id.rg)
    RadioGroup mRg;
    private int mSel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starbar);
        ButterKnife.bind(this);
        setWindowStatusBarColor(1);
        mSeekBar.setOnSeekBarChangeListener(this);
    }
    protected void setWindowStatusBarColor(int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
            /*    //清除
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);*/
//                window.setStatusBarColor(Color.TRANSPARENT);
                //底部导航栏
                AStatusBarUtil.setTranslucentForImageView(this, 0, mRg);
//                window.setNavigationBarColor(Color.BLACK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (mSel) {
            case SET_COLOR:
                AStatusBarUtil.setColor(StarbarActivity.this, Color.WHITE, seekBar.getProgress());
                break;
            case SETCOLORFORSWIPEBACK:
                AStatusBarUtil.setColorForSwipeBack(this, Color.WHITE, seekBar.getProgress());
                break;
            case SETTRANSLUCENT:
                AStatusBarUtil.setTranslucent(this, seekBar.getProgress());
                break;
            case SETTRANSLUCENTFORIMAGEVIEW:
                AStatusBarUtil.setTranslucentForImageView(this, seekBar.getProgress(), mRg);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @OnClick({R.id.setColor, R.id.setColorForSwipeBack, R.id.setTranslucent, R.id.setTranslucentForImageView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setColor:
                mSel = SET_COLOR;
                break;
            case R.id.setColorForSwipeBack:
                mSel = SETCOLORFORSWIPEBACK;
                break;
            case R.id.setTranslucent:
                mSel = SETTRANSLUCENT;
                break;
            case R.id.setTranslucentForImageView:
                mSel = SETTRANSLUCENTFORIMAGEVIEW;
                break;
        }
    }
}
