package com.aserbao.aserbaoanimationsummart.canvasAndPaint;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;

public class CustomProgressBar extends View
{
	/**
	 * ��һȦ����ɫ
	 */
	private int mFirstColor;
	/**
	 * �ڶ�Ȧ����ɫ
	 */
	private int mSecondColor;
	/**
	 * Ȧ�Ŀ��
	 */
	private int mCircleWidth;
	/**
	 * ����
	 */
	private Paint mPaint;
	/**
	 * ��ǰ����
	 */
	private int mProgress;

	/**
	 * �ٶ�
	 */
	private int mSpeed;

	/**
	 * �Ƿ�Ӧ�ÿ�ʼ��һ��
	 */
	private boolean isNext = false;

	public CustomProgressBar(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public CustomProgressBar(Context context)
	{
		this(context, null);
	}

	/**
	 * ��Ҫ�ĳ�ʼ�������һЩ�Զ����ֵ
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public CustomProgressBar(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyle, 0);
		int n = a.getIndexCount();

		for (int i = 0; i < n; i++)
		{
			int attr = a.getIndex(i);
			switch (attr)
			{
			case R.styleable.CustomProgressBar_firstColor:
				mFirstColor = a.getColor(attr, Color.GREEN);
				break;
			case R.styleable.CustomProgressBar_secondColor:
				mSecondColor = a.getColor(attr, Color.RED);
				break;
			case R.styleable.CustomProgressBar_circleWidth:
				mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
						TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
				break;
			case R.styleable.CustomProgressBar_speed:
				mSpeed = a.getInt(attr, 20);// Ĭ��20
				break;
			}
		}
		a.recycle();
		mPaint = new Paint();
		// ��ͼ�߳�
		new Thread()
		{
			public void run()
			{
				while (true)
				{
					mProgress++;
					if (mProgress == 360)
					{
						mProgress = 0;
						if (!isNext)
							isNext = true;
						else
							isNext = false;
					}
					postInvalidate();
					try
					{
						Thread.sleep(mSpeed);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			};
		}.start();

	}

	@Override
	protected void onDraw(Canvas canvas)
	{

		int centre = getWidth() / 2; // ��ȡԲ�ĵ�x����
		int radius = centre - mCircleWidth / 2;// �뾶
		mPaint.setStrokeWidth(mCircleWidth); // ����Բ���Ŀ��
		mPaint.setAntiAlias(true); // �������
		mPaint.setStyle(Paint.Style.STROKE); // ���ÿ���
		RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius); // ���ڶ����Բ������״�ʹ�С�Ľ���
		if (!isNext)
		{// ��һ��ɫ��Ȧ�������ڶ���ɫ��
			mPaint.setColor(mFirstColor); // ����Բ������ɫ
			canvas.drawCircle(centre, centre, radius, mPaint); // ����Բ��
			mPaint.setColor(mSecondColor); // ����Բ������ɫ
			canvas.drawArc(oval, -90, mProgress, false, mPaint); // ���ݽ��Ȼ�Բ��
		} else
		{
			mPaint.setColor(mSecondColor); // ����Բ������ɫ
			canvas.drawCircle(centre, centre, radius, mPaint); // ����Բ��
			mPaint.setColor(mFirstColor); // ����Բ������ɫ
			canvas.drawArc(oval, -90, mProgress, false, mPaint); // ���ݽ��Ȼ�Բ��
		}

	}

}
