package com.aserbao.aserbaoanimationsummart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoveActivity extends AppCompatActivity {

    @BindView(R.id.move_image_view)
    ImageView mMoveImageView;
    @BindView(R.id.frameLayout)
    FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        ButterKnife.bind(this);
    }

    public void btn_move_start(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_rotate);
        /*Animation translate = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -0.2f,
                Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);*/
        Animation translate = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, -0.5f, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translate.setDuration(3000);
        mMoveImageView.startAnimation(translate);
    }
}
