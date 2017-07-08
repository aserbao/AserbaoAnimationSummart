package com.aserbao.aserbaoanimationsummart.aserbaoUtil.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;

/**
 * description:
 * Created by aserbao on 2017/7/8.
 */


public class RectFProgresss extends View {
    private boolean isGoing = true;
    private int mTime = 12;
    private int mShowColor = Color.YELLOW;
    private int mNumProgress = 0;
    private int sleepTime = 50;
    private int mNumProgressCount = (mTime * 1000) / sleepTime ;
    private int m2whCount;
    private int mCurrProgress;
    private int mwhCount;
    private int mwwhCount;

    public RectFProgresss(Context context) {
        this(context,null);
    }

    public RectFProgresss(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RectFProgresss(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ARectFProgress, defStyleAttr, 0);
        for (int i = 0; i < a.getIndexCount(); i++) {
            switch (a.getIndex(i)){
                case R.styleable.ARectFProgress_timeFinish:
                    mTime = a.getInt(a.getIndex(i),12);
                    break;
                case R.styleable.ARectFProgress_showColor:
                    mShowColor = a.getInt(a.getIndex(i), Color.YELLOW);
                    break;
                case R.styleable.ARectFProgress_sleepTime:
                    sleepTime = a.getInt(a.getIndex(i),50);
            }
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(isGoing){
                    if(mNumProgress > mNumProgressCount){
                        isGoing = false;
                    }
                    mNumProgress++;
                    postInvalidate();
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mwhCount = getWidth()+getHeight();
        mwwhCount = mwhCount +getWidth();
        m2whCount = (getWidth()+getHeight())*2;

        mCurrProgress = (mNumProgress * m2whCount)/mNumProgressCount;
        Log.d("dak faljd fadf", "onDraw: "+mCurrProgress);
        Paint paint = new Paint();
        paint.setStrokeWidth(50);
        paint.setColor(mShowColor);
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        Path path1 = new Path();
        path.moveTo(0,0);

        if(mCurrProgress < getWidth()){
            path.lineTo(mCurrProgress,0);
        }else if(mCurrProgress < mwhCount){
            path.lineTo(getWidth(),0);
            path.lineTo(getWidth(), mCurrProgress - getWidth());
        }else if(mCurrProgress < mwwhCount){
            path.lineTo(getWidth(),0);
            path.lineTo(getWidth(),getHeight());
            path.lineTo(mwwhCount- mCurrProgress,getHeight());
        }else if(mCurrProgress < m2whCount){
            path.lineTo(getWidth(),0);
            path.lineTo(getWidth(),getHeight());
            path.lineTo(0,getHeight());
            path1.moveTo(0,getHeight());
            path1.lineTo(0, m2whCount - mCurrProgress);
            canvas.drawPath(path1,paint);
        }else{
            path.lineTo(getWidth(),0);
            path.lineTo(getWidth(),getHeight());
            path.lineTo(0,getHeight());
            path.close();
        }
        canvas.drawPath(path,paint);
    }
}
