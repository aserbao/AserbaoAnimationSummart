package com.aserbao.aserbaoanimationsummart.classify.module.soundCode.aserbaoView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by aserbao on 2017 2017/12/13.21:52
 * Email:1142803753@qq.com
 * weixin: aserbao
 */

public class ProgressView extends View {
    private static final String TAG = "ProgressView";

    private Paint mPaint;
    private float sweepAngle = 180;

    public ProgressView(Context context) {
        super(context);
        Log.d(TAG, "ProgressView: [context]");
        initView();
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "ProgressView: [context, attrs]");
        initView();
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "ProgressView: [context, attrs, defStyleAttr]");
        initView();
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(sweepAngle < 360){
                sweepAngle ++ ;
            }else{
                sweepAngle = 0;
            }
            invalidate();
            sendEmptyMessageDelayed(0,50);
        }
    };

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(15);
        mPaint.setAlpha(200);
        mPaint.setAntiAlias(true);
//        mHandler.sendEmptyMessage(0);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(TAG, "onFinishInflate: ");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure: [widthMeasureSpec, heightMeasureSpec]");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout: [changed, left, top, right, bottom]");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, "onSizeChanged: [w, h, oldw, oldh]");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rect = new RectF(100, 100, 300, 300);
        canvas.drawArc(rect,0,sweepAngle,false,mPaint);
        Log.d(TAG, "onDraw: [canvas]");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyDown: [keyCode, event]");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyUp: [keyCode, event]");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Log.d(TAG, "onTrackballEvent: [event]");
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: [event]");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus,int direction, @Nullable Rect previouslyFocusedRect) {
        Log.d(TAG, "onFocusChanged: [gainFocus, direction, previouslyFocusedRect]");
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        Log.d(TAG, "onWindowFocusChanged: [hasWindowFocus]");
        super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override
    protected void onAttachedToWindow() {
        Log.d(TAG, "onAttachedToWindow: []");
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow: []");
        super.onDetachedFromWindow();
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        Log.d(TAG, "onWindowVisibilityChanged: [visibility]");
        super.onWindowVisibilityChanged(visibility);
    }
}
