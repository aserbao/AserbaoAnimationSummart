package com.linj.imageloader;

import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

import java.lang.reflect.Field;
/**
 * http://blog.csdn.net/lmj623565791/article/details/41874561
 * @author zhy
 *
 */
public class ImageSizeUtil
{
	/**
	 * ��������Ŀ�͸��Լ�ͼƬʵ�ʵĿ�͸߼���SampleSize
	 * 
	 * @param options
	 * @param width
	 * @param height
	 * @return
	 */
	public static int caculateInSampleSize(Options options, int reqWidth,
			int reqHeight)
	{
		int width = options.outWidth;
		int height = options.outHeight;

		int inSampleSize = 1;

		if (width > reqWidth || height > reqHeight)
		{
			int widthRadio = Math.round(width * 1.0f / reqWidth);
			int heightRadio = Math.round(height * 1.0f / reqHeight);

			inSampleSize = Math.max(widthRadio, heightRadio);
		}

		return inSampleSize;
	}

	/**
	 * ����ImageView���ʵ���ѹ���Ŀ�͸�
	 * 
	 * @param imageView
	 * @return
	 */
	public static ImageSize getImageViewSize(ImageView imageView)
	{

		ImageSize imageSize = new ImageSize();
		DisplayMetrics displayMetrics = imageView.getContext().getResources()
				.getDisplayMetrics();
		

		LayoutParams lp = imageView.getLayoutParams();

		int width = imageView.getWidth();// ��ȡimageview��ʵ�ʿ��
		if (width <= 0)
		{
			width = lp.width;// ��ȡimageview��layout�������Ŀ��
		}
		if (width <= 0)
		{
			 //width = imageView.getMaxWidth();// ������ֵ
			width = getImageViewFieldValue(imageView, "mMaxWidth");
		}
		if (width <= 0)
		{
			width = displayMetrics.widthPixels;
		}

		int height = imageView.getHeight();// ��ȡimageview��ʵ�ʸ߶�
		if (height <= 0)
		{
			height = lp.height;// ��ȡimageview��layout�������Ŀ��
		}
		if (height <= 0)
		{
			height = getImageViewFieldValue(imageView, "mMaxHeight");// ������ֵ
		}
		if (height <= 0)
		{
			height = displayMetrics.heightPixels;
		}
		imageSize.width = width;
		imageSize.height = height;

		return imageSize;
	}

	public static class ImageSize
	{
		int width;
		int height;
	}
	
	/**
	 * ͨ�������ȡimageview��ĳ������ֵ
	 * 
	 * @param object
	 * @param fieldName
	 * @return
	 */
	private static int getImageViewFieldValue(Object object, String fieldName)
	{
		int value = 0;
		try
		{
			Field field = ImageView.class.getDeclaredField(fieldName);
			field.setAccessible(true);
			int fieldValue = field.getInt(object);
			if (fieldValue > 0 && fieldValue < Integer.MAX_VALUE)
			{
				value = fieldValue;
			}
		} catch (Exception e)
		{
		}
		return value;

	}

	
}
