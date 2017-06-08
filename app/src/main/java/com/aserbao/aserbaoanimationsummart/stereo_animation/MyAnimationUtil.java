package com.aserbao.aserbaoanimationsummart.stereo_animation;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MyAnimationUtil
{
	/**
	 * These flags are used when parsing AnimatorSet objects
	 */
	private static final int TOGETHER = 0;
	private static final int SEQUENTIALLY = 1;

	/**
	 * Returns the current animation time in milliseconds. This time should be
	 * used when invoking {@link Animation#setStartTime(long)}. Refer to
	 * {@link SystemClock} for more information about the different
	 * available clocks. The clock used by this method is <em>not</em> the
	 * "wall" clock (it is not {@link System#currentTimeMillis}).
	 *
	 * @return the current animation time in milliseconds
	 *
	 * @see SystemClock
	 */
	public static long currentAnimationTimeMillis()
	{
		return SystemClock.uptimeMillis();
	}

	/**
	 * Loads an {@link Animation} object from a resource
	 * 
	 * @param context
	 *            Application context used to access resources
	 * @param id
	 *            The resource id of the animation to load
	 * @return The animation object reference by the specified id
	 * @throws NotFoundException
	 *             when the animation cannot be loaded
	 */
	public static Animation loadAnimation(Context context, int id)
			throws NotFoundException
	{

		XmlResourceParser parser = null;
		try
		{
			parser = context.getResources().getAnimation(id);
			return createAnimationFromXml(context, parser);
		} catch (XmlPullParserException ex)
		{
			NotFoundException rnf = new NotFoundException(
					"Can't load animation resource ID #0x"
							+ Integer.toHexString(id));
			rnf.initCause(ex);
			throw rnf;
		} catch (IOException ex)
		{
			NotFoundException rnf = new NotFoundException(
					"Can't load animation resource ID #0x"
							+ Integer.toHexString(id));
			rnf.initCause(ex);
			throw rnf;
		} finally
		{
			if (parser != null)
				parser.close();
		}
	}

	private static Animation createAnimationFromXml(Context c,
			XmlPullParser parser) throws XmlPullParserException, IOException
	{

		return createAnimationFromXml(c, parser, null,
				Xml.asAttributeSet(parser));
	}

	// 从动画的XML文件创建动画
	private static Animation createAnimationFromXml(Context c,
			XmlPullParser parser, AnimationSet parent, AttributeSet attrs)
			throws XmlPullParserException, IOException
	{

		Animation anim = null;

		// Make sure we are on a start tag.
		int type;
		int depth = parser.getDepth();

		while (((type = parser.next()) != XmlPullParser.END_TAG || parser
				.getDepth() > depth) && type != XmlPullParser.END_DOCUMENT)
		{

			if (type != XmlPullParser.START_TAG)
			{
				continue;
			}
			// 开始标签的名称
			String name = parser.getName();
			/**
			 * 如果是set标签 则创建AnimationSet动画集合 然后递归调用 参数 c context attrs 属性集
			 * 代表duration startOffset等属性
			 */

			if (name.equals("set"))
			{
				anim = new AnimationSet(c, attrs);
				createAnimationFromXml(c, parser, (AnimationSet) anim, attrs);
				/**
				 * 如果是alpha标签 则创建AlphaAnimation动画集合 
				 * 参数 c :context  
				 * 参数attrs: 属性集代表duration、 startOffset等属性
				 */
			} else if (name.equals("alpha"))
			{
				anim = new AlphaAnimation(c, attrs);
				/**
				 * 如果是scale标签 则创建ScaleAnimation动画集合 
				 * 参数 c :context  
				 * 参数attrs: 属性集代表duration、 startOffset等属性
				 */
			} else if (name.equals("scale"))
			{
				anim = new ScaleAnimation(c, attrs);
				
				/**
				 * 如果是rotate标签 则创建RotateAnimation动画集合 
				 * 参数 c :context  
				 * 参数attrs: 属性集代表duration、 startOffset等属性
				 */
			} else if (name.equals("rotate"))
			{
				anim = new RotateAnimation(c, attrs);
				/**
				 * 如果是translate标签 则创建TranslateAnimation动画集合 
				 * 参数 c :context  
				 * 参数attrs: 属性集代表duration、 startOffset等属性
				 */
			} else if (name.equals("translate"))
			{
				anim = new TranslateAnimation(c, attrs);
			}else{
				try {
	                anim = (Animation) Class.forName(name).getConstructor(Context.class, AttributeSet.class).newInstance(c, attrs);
	            } catch (Exception te) {
	                throw new RuntimeException("Unknown animation name: " + parser.getName() + " error:" + te.getMessage());
	            }
			}
			
			
        }

        if (parent != null) {
            parent.addAnimation(anim);
        }
    

    return anim;

}
}


	