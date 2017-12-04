package com.aserbao.aserbaoanimationsummart.classify.module.ui.progressbar.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.Iterator;

/**
 * Created by aserbao on 2017 2017/12/3.22:16
 * Email:1142803753@qq.com
 * weixin: aserbao
 */

public class ProgressView extends View{
    private boolean mStop,mProgressChanged;
    /** 闪动 */
    private final static int HANDLER_INVALIDATE_ACTIVE = 0;
    /** 录制中 */
    private final static int HANDLER_INVALIDATE_RECORDING = 1;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case HANDLER_INVALIDATE_ACTIVE:
                    invalidate();
//                    mActiveState = !mActiveState;
                    if (!mStop)
                        sendEmptyMessageDelayed(0, 300);
                    break;
                case HANDLER_INVALIDATE_RECORDING:
                    invalidate();
                    if (mProgressChanged)
                        sendEmptyMessageDelayed(0, 50);
                    break;
            }
            super.handleMessage(msg);
        }
    };
    private Paint mProgressPaint;
    private Paint mActivePaint,mThreePaint;
    private Paint mPausePaint;
    private MediaObject mMediaObject;
    private int mMaxDuration, mVLineWidth;


    public ProgressView(Context context) {
        super(context);
        init();
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mProgressPaint = new Paint();
        mActivePaint = new Paint();
        mPausePaint = new Paint();
        mThreePaint = new Paint();

        mVLineWidth = dipToPX(getContext(), 1);
//        setBackgroundColor(getResources().getColor(R.color.camera_bg));
        setBackgroundColor(Color.parseColor("#CCCCCC"));
        mProgressPaint.setColor(0xFF45C01A);

        mProgressPaint.setStyle(Paint.Style.FILL);

        mActivePaint.setColor(Color.parseColor("#ffffff"));
        mActivePaint.setStyle(Paint.Style.FILL);

        mPausePaint.setColor(Color.parseColor("#A0A0A0"));
        mPausePaint.setStyle(Paint.Style.FILL);

        mThreePaint.setColor(Color.parseColor("#000000"));
        mThreePaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int width = getMeasuredWidth(), height = getMeasuredHeight();
        int left = 0, right = 0, duration = 0;
        if(mMediaObject != null && mMediaObject.getMedaParts() != null ){
            Iterator<MediaObject.MediaPart> iterator = mMediaObject.getMedaParts().iterator();
            boolean hasNext = iterator.hasNext();
            int maxDuration = mMaxDuration;
            boolean hasOutDuration = false;
            int currentDuration = mMediaObject.getDuration();
            hasOutDuration = currentDuration > mMaxDuration;
            if (hasOutDuration)
                maxDuration = currentDuration;
            while (hasNext){
                MediaObject.MediaPart next = iterator.next();
                int partDuration = next.getDuration();
                left = right;
                right = left + (int) (partDuration * 1.0F / maxDuration * width);
                // 画进度
                if (hasOutDuration) {
                    // 超时拍摄
                    // 前段
                    right = left
                            + (int) ((mMaxDuration - duration) * 1.0F
                            / maxDuration * width);
                    canvas.drawRect(left, 0.0F, right, height,
                            mProgressPaint);

                    // 超出的段
                    left = right;
                    right = left
                            + (int) ((partDuration - (mMaxDuration - duration))
                            * 1.0F / maxDuration * width);
                    canvas.drawRect(left, 0.0F, right, height,
                            mProgressPaint);
                } else {
                    canvas.drawRect(left, 0.0F, right, height,
                            mProgressPaint);
                }
                hasNext = iterator.hasNext();
                if(hasNext){
                    canvas.drawRect(right - mVLineWidth, 0.0F, right, height,
                            mPausePaint);
                }
                duration += partDuration;
                // 画三秒
                if (duration < 3000) {
                    left = (int) (3000F / mMaxDuration * width);
                    canvas.drawRect(left, 0.0F, left + mVLineWidth, height, mThreePaint);
                }
            }
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mStop = false;
        mHandler.sendEmptyMessage(HANDLER_INVALIDATE_ACTIVE);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mStop = true;
        mHandler.removeMessages(HANDLER_INVALIDATE_ACTIVE);
    }

    public void setData(MediaObject mMediaObject) {
        this.mMediaObject = mMediaObject;
    }

    public void setMaxDuration(int duration) {
        this.mMaxDuration = duration;
    }

    public static int dipToPX(final Context ctx, float dip) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, ctx.getResources().getDisplayMetrics());
    }

}
