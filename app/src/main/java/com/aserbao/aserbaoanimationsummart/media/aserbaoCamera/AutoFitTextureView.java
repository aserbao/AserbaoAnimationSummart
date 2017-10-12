package com.aserbao.aserbaoanimationsummart.media.aserbaoCamera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/**
 * description:
 * Created by aserbao on 2017/6/15.
 */

public class AutoFitTextureView extends TextureView {
    private int mRatioWidth = 0;
    private int mRatioHeight = 0;

    public AutoFitTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setAspectRatio(int width,int height){
        mRatioWidth = width;
        mRatioHeight = height;
        requestLayout();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if( 0 == mRatioWidth || 0 == mRatioHeight){
            setMeasuredDimension(width,height);
        }else{
            int bi = mRatioWidth / mRatioHeight;
            if(width < height * bi ){
                setMeasuredDimension(width,width * bi);
            }else{
                setMeasuredDimension(width * bi,height);
            }
        }

    }
}
