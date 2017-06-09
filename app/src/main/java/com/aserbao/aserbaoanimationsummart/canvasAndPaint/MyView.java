package com.aserbao.aserbaoanimationsummart.canvasAndPaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by aserbao on 2017 2017/6/9.0:40
 * Email:1142803753@qq.com
 * weixin: aserbao
 */

public class MyView extends View {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(54);
        int viewWidth = this.getWidth();
        int viewHeight = this.getHeight();
        canvas.drawCircle(viewWidth/2,viewHeight/2,100,paint);
        RectF rectF = new RectF(viewWidth / 2 - 50, viewHeight / 2 - 30, viewWidth / 2 + 50, viewHeight / 2 + 30);
        canvas.drawArc(rectF,45,90,false,paint);
    }
}
