package com.aserbao.aserbaoanimationsummart.customAnimation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.Transformation;

/**
 * Created by aserbao on 2017 2017/6/7.23:54
 * Email:1142803753@qq.com
 * weixin: aserbao
 */

public class CustomAnimation extends Animation {
    private float centerX;
    private float centerY;
    private int duration;
    private Camera mCamera = new Camera();
    public CustomAnimation(float x,float y ,int duration) {
        this.centerX = x;
        this.centerY = y;
        this.duration = duration;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(duration);
        setFillAfter(true);
        setInterpolator(new CycleInterpolator(0.5f));
    }


    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        mCamera.save();
        mCamera.translate(100-100*interpolatedTime,150*interpolatedTime - 150,80 - 80*interpolatedTime);
        mCamera.rotateY(360*interpolatedTime);
        mCamera.rotateX(360*interpolatedTime);
        mCamera.rotateZ(360*interpolatedTime);
        Matrix matrix = t.getMatrix();
        mCamera.getMatrix(matrix);
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
        mCamera.restore();
    }

}
