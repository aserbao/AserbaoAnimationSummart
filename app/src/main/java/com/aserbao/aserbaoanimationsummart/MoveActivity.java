package com.aserbao.aserbaoanimationsummart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
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

import com.aserbao.aserbaoanimationsummart.customAnimation.CustomAnimation;
import com.aserbao.aserbaoanimationsummart.customAnimation.CustomAnimation2;

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
    @BindView(R.id.btn_custom_tween)
    Button mBtnCustomTween;
    @BindView(R.id.move_image_view2)
    ImageView mMoveImageView2;

    private Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.translate, R.id.alpha, R.id.scale, R.id.rotate, R.id.btn_custom_tween})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.translate:
                mAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -0.5f,
                        Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, -0.5f,
                        Animation.RELATIVE_TO_PARENT, 0.5f);
                normalTweenAnimation();
                break;
            case R.id.alpha:
                mAnimation = new AlphaAnimation(1, 0);
                normalTweenAnimation();
                break;
            case R.id.scale:
                mAnimation = new ScaleAnimation(1, 3, 1, 3);
                normalTweenAnimation();
                break;
            case R.id.rotate:
                mAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                normalTweenAnimation();
                break;
            case R.id.btn_custom_tween:
                WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
                Display display = windowManager.getDefaultDisplay();
                DisplayMetrics metrics = new DisplayMetrics();
                display.getMetrics(metrics);
                mMoveImageView.startAnimation(new CustomAnimation(metrics.xdpi / 2, metrics.ydpi
                        / 2, 6500));
                mMoveImageView2.startAnimation(new CustomAnimation2(metrics.xdpi / 2,
                        metrics.ydpi / 2, 6500));
                break;
        }

    }

    private void normalTweenAnimation() {
        Interpolator interpolator = new CycleInterpolator(0.5f);
        mAnimation.setInterpolator(interpolator);
        mAnimation.setDuration(3000);
        mAnimation.setFillAfter(true);
        mAnimation.setRepeatCount(5);
        mMoveImageView.startAnimation(mAnimation);
        mMoveImageView2.startAnimation(mAnimation);
    }
}
