package com.aserbao.aserbaoanimationsummart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoveActivity extends AppCompatActivity {


    @BindView(R.id.move_image_view)
    ImageView mMoveImageView;
    @BindView(R.id.translate)
    Button mButton1;
    @BindView(R.id.alpha)
    Button mButton2;
    @BindView(R.id.scale)
    Button mScale;
    @BindView(R.id.rotate)
    Button mRotate;
    @BindView(R.id.frameLayout)
    RelativeLayout mFrameLayout;
    private Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.translate, R.id.alpha, R.id.scale, R.id.rotate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.translate:
                mAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,-0.5f,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,-0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
                break;
            case R.id.alpha:
                mAnimation = new AlphaAnimation(1, 0);
                break;
            case R.id.scale:
                mAnimation = new ScaleAnimation(1,3,1,3);
                break;
            case R.id.rotate:
                mAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                break;
        }
        Interpolator interpolator = new CycleInterpolator(0.55f);
        mAnimation.setInterpolator(interpolator);
        mAnimation.setDuration(3000);
        mAnimation.setFillAfter(true);
        mAnimation.setRepeatCount(5);
        mMoveImageView.startAnimation(mAnimation);
    }
}
