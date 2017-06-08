package com.aserbao.aserbaoanimationsummart.stereo_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.aserbao.aserbaoanimationsummart.R;

public class StereoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stereo);
        //		Rotate3dAnimation animation = new Rotate3dAnimation(Rotate3dAnimation.ROLL_BY_X,0f,360f);
        final ImageView img = (ImageView) findViewById(R.id.img);
		Animation animation = MyAnimationUtil.loadAnimation(this, R.anim.rotate3d);
		animation.setFillAfter(true);
		animation.setRepeatCount(-1);
		animation.setDuration(1000);
		img.startAnimation(animation);
    }
}
