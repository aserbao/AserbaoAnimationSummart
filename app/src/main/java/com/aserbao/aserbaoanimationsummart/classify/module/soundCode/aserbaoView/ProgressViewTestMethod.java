package com.aserbao.aserbaoanimationsummart.classify.module.soundCode.aserbaoView;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.WindowId;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import java.util.ArrayList;

/**
 * Created by aserbao on 2017 2017/12/13.21:52
 * Email:1142803753@qq.com
 * weixin: aserbao
 */

public class ProgressViewTestMethod extends View {
    private static final String TAG = "ProgressView";

    private Paint mPaint;
    private float sweepAngle = 180;

    public ProgressViewTestMethod(Context context) {
        super(context);
        Log.d(TAG, "ProgressView: [context]");
        initView();
    }

    public ProgressViewTestMethod(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "ProgressView: [context, attrs]");
        initView();
    }

    public ProgressViewTestMethod(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "ProgressView: [context, attrs, defStyleAttr]");
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(15);
        mPaint.setAlpha(200);
        mPaint.setAntiAlias(true);
//        mHandler.sendEmptyMessage(0);
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ProgressViewTestMethod(Context context, @Nullable AttributeSet attrs, int
            defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Log.d(TAG, "ProgressViewTestMethod: ");
    }

    @Override
    public String toString() {
        Log.d(TAG, "toString: ");
        return super.toString();
    }

    @Override
    public int getVerticalFadingEdgeLength() {
        Log.d(TAG, "getVerticalFadingEdgeLength: " + "==================返回垂直方向边框渐变的长度");
        return super.getVerticalFadingEdgeLength();
    }

    @Override
    public void setFadingEdgeLength(@Px int length) {
        Log.d(TAG, "setFadingEdgeLength: " + "=============== 设置垂直边框渐变长度");
        super.setFadingEdgeLength(length);
    }

    @Override
    public int getHorizontalFadingEdgeLength() {
        Log.d(TAG, "getHorizontalFadingEdgeLength: " + "===============获得水平方向边框渐变的长度");
        return super.getHorizontalFadingEdgeLength();
    }

    @Override
    public int getVerticalScrollbarWidth() {
        Log.d(TAG, "getVerticalScrollbarWidth: " + "===============获取垂直滚动条宽度");
        return super.getVerticalScrollbarWidth();
    }

    @Override
    protected int getHorizontalScrollbarHeight() {
        Log.d(TAG, "getHorizontalScrollbarHeight: " + "===============获取水平滚动条高度");
        return super.getHorizontalScrollbarHeight();
    }

    @Override
    public void setVerticalScrollbarPosition(int position) {
        Log.d(TAG, "setVerticalScrollbarPosition: " + "===============设置水平滚动条位置");
        super.setVerticalScrollbarPosition(position);
    }

    @Override
    public int getVerticalScrollbarPosition() {
        Log.d(TAG, "getVerticalScrollbarPosition: " + "===============拿到水平滚动条位置");
        return super.getVerticalScrollbarPosition();
    }

    @Override
    public void setScrollIndicators(int indicators) {
        Log.d(TAG, "setScrollIndicators: " + "===============修改滚动指示指示器");
        super.setScrollIndicators(indicators);
    }

    @Override
    public void setScrollIndicators(int indicators,
                                    int mask) {
        Log.d(TAG, "setScrollIndicators: " + "===============修改滚动指示指示器");
        super.setScrollIndicators(indicators, mask);
    }

    @Override
    public int getScrollIndicators() {
        Log.d(TAG, "getScrollIndicators: " + "===============获得滚动指示指示器");
        return super.getScrollIndicators();
    }

    @Override
    public void setOnScrollChangeListener(OnScrollChangeListener l) {
        Log.d(TAG, "setOnScrollChangeListener: " + "===============设置滚动改变监听");
        super.setOnScrollChangeListener(l);
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        Log.d(TAG, "setOnFocusChangeListener: " + "===============设置焦点改变监听");
        super.setOnFocusChangeListener(l);
    }

    @Override
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener) {
        Log.d(TAG, "addOnLayoutChangeListener: " + "===============设置布局改变监听");
        super.addOnLayoutChangeListener(listener);
    }

    @Override
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener) {
        Log.d(TAG, "removeOnLayoutChangeListener: " + "===============设置移除布局监听");
        super.removeOnLayoutChangeListener(listener);
    }

    @Override
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        Log.d(TAG, "addOnAttachStateChangeListener: " + "===============设置依附状态改变监听");
        super.addOnAttachStateChangeListener(listener);
    }

    @Override
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        Log.d(TAG, "removeOnAttachStateChangeListener: " + "===============移除依附状态监听");
        super.removeOnAttachStateChangeListener(listener);
    }

    @Override
    public OnFocusChangeListener getOnFocusChangeListener() {
        Log.d(TAG, "getOnFocusChangeListener: " + "===============获取焦点状态改变监听");
        return super.getOnFocusChangeListener();
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        Log.d(TAG, "setOnClickListener: " + "===============这个不多说，设置点击事件监听");
        super.setOnClickListener(l);
    }

    @Override
    public boolean hasOnClickListeners() {
        Log.d(TAG, "hasOnClickListeners: " + "===============判断该View是否有点击事件");
        return super.hasOnClickListeners();
    }

    @Override
    public void setOnLongClickListener(@Nullable OnLongClickListener l) {
        Log.d(TAG, "setOnLongClickListener: " + "=============== 设置长按事件监听");
        super.setOnLongClickListener(l);
    }

    @Override
    public void setOnContextClickListener(@Nullable OnContextClickListener l) {
        Log.d(TAG, "setOnContextClickListener: " + "===============设置上下文点击监听");
        super.setOnContextClickListener(l);
    }

    @Override
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
        Log.d(TAG, "setOnCreateContextMenuListener: " + "===============设置创建菜单监听");
        super.setOnCreateContextMenuListener(l);
    }

    @Override
    public boolean performClick() {
        Log.d(TAG, "performClick: " + "===============模拟人触发点击事件,带有播放声音效果，看源码");
        return super.performClick();
    }

    @Override
    public boolean callOnClick() {
        Log.d(TAG, "callOnClick: " + "===============直接调用View的点击事件");
        return super.callOnClick();
    }

    @Override
    public boolean performLongClick() {
        Log.d(TAG, "performLongClick: " + "===============模拟常按");
        return super.performLongClick();
    }

    @Override
    public boolean performLongClick(float x, float y) {
        Log.d(TAG, "performLongClick: " + "===============模拟常按的位置");
        return super.performLongClick(x, y);
    }

    @Override
    public boolean performContextClick(float x, float y) {
        Log.d(TAG, "performContextClick: " + "===============模拟上指定位置下文点击");
        return super.performContextClick(x, y);
    }

    @Override
    public boolean performContextClick() {
        Log.d(TAG, "performContextClick: " + "===============模拟上下文点击");
        return super.performContextClick();
    }

    @Override
    public boolean showContextMenu() {
        Log.d(TAG, "showContextMenu: " + "===============显示上下文菜单");
        return super.showContextMenu();
    }

    @Override
    public boolean showContextMenu(float x, float y) {
        Log.d(TAG, "showContextMenu: " + "===============显示指定位置上下文菜单");
        return super.showContextMenu(x, y);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return super.startActionMode(callback);
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        return super.startActionMode(callback, type);
    }

    @Override
    public void setOnKeyListener(OnKeyListener l) {
        super.setOnKeyListener(l);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
    }

    @Override
    public void setOnGenericMotionListener(OnGenericMotionListener l) {
        super.setOnGenericMotionListener(l);
    }

    @Override
    public void setOnHoverListener(OnHoverListener l) {
        super.setOnHoverListener(l);
    }

    @Override
    public void setOnDragListener(OnDragListener l) {
        super.setOnDragListener(l);
    }

    @Override
    public boolean requestRectangleOnScreen(Rect rectangle) {
        return super.requestRectangleOnScreen(rectangle);
    }

    @Override
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        return super.requestRectangleOnScreen(rectangle, immediate);
    }

    @Override
    public void clearFocus() {
        super.clearFocus();
    }

    @Override
    public boolean hasFocus() {
        return super.hasFocus();
    }

    @Override
    public boolean hasFocusable() {
        return super.hasFocusable();
    }

    @Override
    public void sendAccessibilityEvent(int eventType) {
        super.sendAccessibilityEvent(eventType);
    }

    @Override
    public void announceForAccessibility(CharSequence text) {
        super.announceForAccessibility(text);
    }

    @Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        super.sendAccessibilityEventUnchecked(event);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return super.dispatchPopulateAccessibilityEvent(event);
    }

    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
    }

    @Override
    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super.createAccessibilityNodeInfo();
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    @Override
    public void onProvideStructure(ViewStructure structure) {
        super.onProvideStructure(structure);
    }

    @Override
    public void onProvideVirtualStructure(ViewStructure structure) {
        super.onProvideVirtualStructure(structure);
    }

    @Override
    public void dispatchProvideStructure(ViewStructure structure) {
        super.dispatchProvideStructure(structure);
    }

    @Override
    public void setAccessibilityDelegate(@Nullable AccessibilityDelegate delegate) {
        super.setAccessibilityDelegate(delegate);
    }

    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return super.getAccessibilityNodeProvider();
    }

    @Override
    public CharSequence getContentDescription() {
        return super.getContentDescription();
    }

    @Override
    public void setContentDescription(CharSequence contentDescription) {
        super.setContentDescription(contentDescription);
    }

    @Override
    public void setAccessibilityTraversalBefore(int beforeId) {
        super.setAccessibilityTraversalBefore(beforeId);
    }

    @Override
    public int getAccessibilityTraversalBefore() {
        return super.getAccessibilityTraversalBefore();
    }

    @Override
    public void setAccessibilityTraversalAfter(int afterId) {
        super.setAccessibilityTraversalAfter(afterId);
    }

    @Override
    public int getAccessibilityTraversalAfter() {
        return super.getAccessibilityTraversalAfter();
    }

    @Override
    public int getLabelFor() {
        return super.getLabelFor();
    }

    @Override
    public void setLabelFor(@IdRes int id) {
        super.setLabelFor(id);
    }

    @Override
    public boolean isFocused() {
        return super.isFocused();
    }

    @Override
    public View findFocus() {
        return super.findFocus();
    }

    @Override
    public boolean isScrollContainer() {
        return super.isScrollContainer();
    }

    @Override
    public void setScrollContainer(boolean isScrollContainer) {
        super.setScrollContainer(isScrollContainer);
    }

    @Override
    public int getDrawingCacheQuality() {
        return super.getDrawingCacheQuality();
    }

    @Override
    public void setDrawingCacheQuality(@IntDef(value = {View.DRAWING_CACHE_QUALITY_LOW, View
            .DRAWING_CACHE_QUALITY_HIGH, View.DRAWING_CACHE_QUALITY_AUTO}) int quality) {
        super.setDrawingCacheQuality(quality);
    }

    @Override
    public boolean getKeepScreenOn() {
        return super.getKeepScreenOn();
    }

    @Override
    public void setKeepScreenOn(boolean keepScreenOn) {
        super.setKeepScreenOn(keepScreenOn);
    }

    @Override
    public int getNextFocusLeftId() {
        return super.getNextFocusLeftId();
    }

    @Override
    public void setNextFocusLeftId(int nextFocusLeftId) {
        super.setNextFocusLeftId(nextFocusLeftId);
    }

    @Override
    public int getNextFocusRightId() {
        return super.getNextFocusRightId();
    }

    @Override
    public void setNextFocusRightId(int nextFocusRightId) {
        super.setNextFocusRightId(nextFocusRightId);
    }

    @Override
    public int getNextFocusUpId() {
        return super.getNextFocusUpId();
    }

    @Override
    public void setNextFocusUpId(int nextFocusUpId) {
        super.setNextFocusUpId(nextFocusUpId);
    }

    @Override
    public int getNextFocusDownId() {
        return super.getNextFocusDownId();
    }

    @Override
    public void setNextFocusDownId(int nextFocusDownId) {
        super.setNextFocusDownId(nextFocusDownId);
    }

    @Override
    public int getNextFocusForwardId() {
        return super.getNextFocusForwardId();
    }

    @Override
    public void setNextFocusForwardId(int nextFocusForwardId) {
        super.setNextFocusForwardId(nextFocusForwardId);
    }

    @Override
    public boolean isShown() {
        return super.isShown();
    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        return super.fitSystemWindows(insets);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        return super.onApplyWindowInsets(insets);
    }

    @Override
    public void setOnApplyWindowInsetsListener(OnApplyWindowInsetsListener listener) {
        super.setOnApplyWindowInsetsListener(listener);
    }

    @Override
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        return super.dispatchApplyWindowInsets(insets);
    }

    @Override
    public WindowInsets getRootWindowInsets() {
        return super.getRootWindowInsets();
    }

    @Override
    public WindowInsets computeSystemWindowInsets(WindowInsets in, Rect outLocalInsets) {
        return super.computeSystemWindowInsets(in, outLocalInsets);
    }

    @Override
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        super.setFitsSystemWindows(fitSystemWindows);
    }

    @Override
    public boolean getFitsSystemWindows() {
        return super.getFitsSystemWindows();
    }

    @Override
    public void requestFitSystemWindows() {
        super.requestFitSystemWindows();
    }

    @Override
    public void requestApplyInsets() {
        super.requestApplyInsets();
    }

    @Override
    public int getVisibility() {
        return super.getVisibility();
    }

    @Override
    public void setVisibility(@IntDef(value = {View.VISIBLE, View.INVISIBLE, View.GONE}) int
                                          visibility) {
        super.setVisibility(visibility);
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    @Override
    public void setFocusable(boolean focusable) {
        super.setFocusable(focusable);
    }

    @Override
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {
        super.setFocusableInTouchMode(focusableInTouchMode);
    }

    @Override
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        super.setSoundEffectsEnabled(soundEffectsEnabled);
    }

    @Override
    public boolean isSoundEffectsEnabled() {
        return super.isSoundEffectsEnabled();
    }

    @Override
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) {
        super.setHapticFeedbackEnabled(hapticFeedbackEnabled);
    }

    @Override
    public boolean isHapticFeedbackEnabled() {
        return super.isHapticFeedbackEnabled();
    }

    @Override
    public void setLayoutDirection(@IntDef(value = {View.LAYOUT_DIRECTION_LTR, View
            .LAYOUT_DIRECTION_RTL, View.LAYOUT_DIRECTION_INHERIT, View.LAYOUT_DIRECTION_LOCALE})
                                               int layoutDirection) {
        super.setLayoutDirection(layoutDirection);
    }

    @Override
    public int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    @Override
    public boolean hasTransientState() {
        return super.hasTransientState();
    }

    @Override
    public void setHasTransientState(boolean hasTransientState) {
        super.setHasTransientState(hasTransientState);
    }

    @Override
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override
    public boolean isLaidOut() {
        return super.isLaidOut();
    }

    @Override
    public void setWillNotDraw(boolean willNotDraw) {
        super.setWillNotDraw(willNotDraw);
    }

    @Override
    public boolean willNotDraw() {
        return super.willNotDraw();
    }

    @Override
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing) {
        super.setWillNotCacheDrawing(willNotCacheDrawing);
    }

    @Override
    public boolean willNotCacheDrawing() {
        return super.willNotCacheDrawing();
    }

    @Override
    public boolean isClickable() {
        return super.isClickable();
    }

    @Override
    public void setClickable(boolean clickable) {
        super.setClickable(clickable);
    }

    @Override
    public boolean isLongClickable() {
        return super.isLongClickable();
    }

    @Override
    public void setLongClickable(boolean longClickable) {
        super.setLongClickable(longClickable);
    }

    @Override
    public boolean isContextClickable() {
        return super.isContextClickable();
    }

    @Override
    public void setContextClickable(boolean contextClickable) {
        super.setContextClickable(contextClickable);
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        super.dispatchSetPressed(pressed);
    }

    @Override
    public boolean isPressed() {
        return super.isPressed();
    }

    @Override
    public boolean isSaveEnabled() {
        return super.isSaveEnabled();
    }

    @Override
    public void setSaveEnabled(boolean enabled) {
        super.setSaveEnabled(enabled);
    }

    @Override
    public boolean getFilterTouchesWhenObscured() {
        return super.getFilterTouchesWhenObscured();
    }

    @Override
    public void setFilterTouchesWhenObscured(boolean enabled) {
        super.setFilterTouchesWhenObscured(enabled);
    }

    @Override
    public boolean isSaveFromParentEnabled() {
        return super.isSaveFromParentEnabled();
    }

    @Override
    public void setSaveFromParentEnabled(boolean enabled) {
        super.setSaveFromParentEnabled(enabled);
    }

    @Override
    public View focusSearch(int direction) {
        return super.focusSearch(direction);
    }

    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        return super.dispatchUnhandledMove(focused, direction);
    }

    @Override
    public ArrayList<View> getFocusables(
            int direction) {
        return super.getFocusables(direction);
    }

    @Override
    public void addFocusables(ArrayList<View> views, @IntDef(value = {View.FOCUS_BACKWARD, View
            .FOCUS_FORWARD, View.FOCUS_LEFT, View.FOCUS_UP, View.FOCUS_RIGHT, View.FOCUS_DOWN})
            int direction) {
        super.addFocusables(views, direction);
    }

    @Override
    public void addFocusables(ArrayList<View> views, @IntDef(value = {View.FOCUS_BACKWARD, View
            .FOCUS_FORWARD, View.FOCUS_LEFT, View.FOCUS_UP, View.FOCUS_RIGHT, View.FOCUS_DOWN})
            int direction, @IntDef(value = {View.FOCUSABLES_ALL, View.FOCUSABLES_TOUCH_MODE},
            flag = true) int focusableMode) {
        super.addFocusables(views, direction, focusableMode);
    }

    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, @IntDef(value
            = {View.FIND_VIEWS_WITH_TEXT, View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION}, flag = true)
            int flags) {
        super.findViewsWithText(outViews, searched, flags);
    }

    @Override
    public ArrayList<View> getTouchables() {
        return super.getTouchables();
    }

    @Override
    public void addTouchables(ArrayList<View> views) {
        super.addTouchables(views);
    }

    @Override
    public boolean isAccessibilityFocused() {
        return super.isAccessibilityFocused();
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    @Override
    public int getImportantForAccessibility() {
        return super.getImportantForAccessibility();
    }

    @Override
    public void setAccessibilityLiveRegion(int mode) {
        super.setAccessibilityLiveRegion(mode);
    }

    @Override
    public int getAccessibilityLiveRegion() {
        return super.getAccessibilityLiveRegion();
    }

    @Override
    public void setImportantForAccessibility(@IntDef(value = {View
            .IMPORTANT_FOR_ACCESSIBILITY_AUTO, View.IMPORTANT_FOR_ACCESSIBILITY_YES, View.IMPORTANT_FOR_ACCESSIBILITY_NO, View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS}) int mode) {
        super.setImportantForAccessibility(mode);
    }

    @Override
    public boolean isImportantForAccessibility() {
        return super.isImportantForAccessibility();
    }

    @Override
    public ViewParent getParentForAccessibility() {
        return super.getParentForAccessibility();
    }

    @Override
    public void addChildrenForAccessibility(ArrayList<View> outChildren) {
        super.addChildrenForAccessibility(outChildren);
    }

    @Override
    public boolean dispatchNestedPrePerformAccessibilityAction(int action, Bundle arguments) {
        return super.dispatchNestedPrePerformAccessibilityAction(action, arguments);
    }

    @Override
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        return super.performAccessibilityAction(action, arguments);
    }

    @Override
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
    }

    @Override
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    @Override
    public void dispatchFinishTemporaryDetach() {
        super.dispatchFinishTemporaryDetach();
    }

    @Override
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    @Override
    public KeyEvent.DispatcherState getKeyDispatcherState() {
        return super.getKeyDispatcherState();
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        return super.dispatchKeyEventPreIme(event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        return super.onFilterTouchEventForSecurity(event);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        return super.dispatchTrackballEvent(event);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        return super.dispatchGenericMotionEvent(event);
    }

    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        return super.dispatchHoverEvent(event);
    }

    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        return super.dispatchGenericPointerEvent(event);
    }

    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        return super.dispatchGenericFocusedEvent(event);
    }

    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        super.dispatchWindowFocusChanged(hasFocus);
    }

    @Override
    public boolean hasWindowFocus() {
        return super.hasWindowFocus();
    }

    @Override
    protected void dispatchVisibilityChanged(@NonNull View changedView, @IntDef(value = {View
            .VISIBLE, View.INVISIBLE, View.GONE}) int visibility) {
        super.dispatchVisibilityChanged(changedView, visibility);
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, @IntDef(value = {View.VISIBLE,
            View.INVISIBLE, View.GONE}) int visibility) {
        super.onVisibilityChanged(changedView, visibility);
    }

    @Override
    public void dispatchDisplayHint(@IntDef(value = {View.VISIBLE, View.INVISIBLE, View.GONE})
                                                int hint) {
        super.dispatchDisplayHint(hint);
    }

    @Override
    protected void onDisplayHint(@IntDef(value = {View.VISIBLE, View.INVISIBLE, View.GONE}) int hint) {
        super.onDisplayHint(hint);
    }

    @Override
    public void dispatchWindowVisibilityChanged(@IntDef(value = {View.VISIBLE, View.INVISIBLE,
            View.GONE}) int visibility) {
        super.dispatchWindowVisibilityChanged(visibility);
    }

    @Override
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
    }

    @Override
    public int getWindowVisibility() {
        return super.getWindowVisibility();
    }

    @Override
    public void getWindowVisibleDisplayFrame(Rect outRect) {
        super.getWindowVisibleDisplayFrame(outRect);
    }

    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        super.dispatchConfigurationChanged(newConfig);
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean isInTouchMode() {
        return super.isInTouchMode();
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        return super.onKeyPreIme(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        return super.onCheckIsTextEditor();
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return super.onCreateInputConnection(outAttrs);
    }

    @Override
    public boolean checkInputConnectionProxy(View view) {
        return super.checkInputConnectionProxy(view);
    }

    @Override
    public void createContextMenu(ContextMenu menu) {
        super.createContextMenu(menu);
    }

    @Override
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return super.getContextMenuInfo();
    }

    @Override
    protected void onCreateContextMenu(ContextMenu menu) {
        super.onCreateContextMenu(menu);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return super.onGenericMotionEvent(event);
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        return super.onHoverEvent(event);
    }

    @Override
    public boolean isHovered() {
        return super.isHovered();
    }

    @Override
    public void setHovered(boolean hovered) {
        super.setHovered(hovered);
    }

    @Override
    public void onHoverChanged(boolean hovered) {
        super.onHoverChanged(hovered);
    }

    @Override
    public void cancelLongPress() {
        super.cancelLongPress();
    }

    @Override
    public void setTouchDelegate(TouchDelegate delegate) {
        super.setTouchDelegate(delegate);
    }

    @Override
    public TouchDelegate getTouchDelegate() {
        return super.getTouchDelegate();
    }

    @Override
    public void bringToFront() {
        super.bringToFront();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    public void setScrollX(@Px int value) {
        super.setScrollX(value);
    }

    @Override
    public void setScrollY(@Px int value) {
        super.setScrollY(value);
    }

    @Override
    public void getDrawingRect(Rect outRect) {
        super.getDrawingRect(outRect);
    }

    @Override
    public Matrix getMatrix() {
        return super.getMatrix();
    }

    @Override
    public float getCameraDistance() {
        return super.getCameraDistance();
    }

    @Override
    public void setCameraDistance(float distance) {
        super.setCameraDistance(distance);
    }

    @Override
    public float getRotation() {
        return super.getRotation();
    }

    @Override
    public void setRotation(float rotation) {
        super.setRotation(rotation);
    }

    @Override
    public float getRotationY() {
        return super.getRotationY();
    }

    @Override
    public void setRotationY(float rotationY) {
        super.setRotationY(rotationY);
    }

    @Override
    public float getRotationX() {
        return super.getRotationX();
    }

    @Override
    public void setRotationX(float rotationX) {
        super.setRotationX(rotationX);
    }

    @Override
    public float getScaleX() {
        return super.getScaleX();
    }

    @Override
    public void setScaleX(float scaleX) {
        super.setScaleX(scaleX);
    }

    @Override
    public float getScaleY() {
        return super.getScaleY();
    }

    @Override
    public void setScaleY(float scaleY) {
        super.setScaleY(scaleY);
    }

    @Override
    public float getPivotX() {
        return super.getPivotX();
    }

    @Override
    public void setPivotX(float pivotX) {
        super.setPivotX(pivotX);
    }

    @Override
    public float getPivotY() {
        return super.getPivotY();
    }

    @Override
    public void setPivotY(float pivotY) {
        super.setPivotY(pivotY);
    }

    @Override
    public float getAlpha() {
        return super.getAlpha();
    }

    @Override
    public void forceHasOverlappingRendering(boolean hasOverlappingRendering) {
        super.forceHasOverlappingRendering(hasOverlappingRendering);
    }

    @Override
    public boolean hasOverlappingRendering() {
        return super.hasOverlappingRendering();
    }

    @Override
    public void setAlpha(@FloatRange(from = 0.0, to = 1.0) float alpha) {
        super.setAlpha(alpha);
    }

    @Override
    public boolean isDirty() {
        return super.isDirty();
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public void setX(@Px float x) {
        super.setX(x);
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public void setY(@Px float y) {
        super.setY(y);
    }

    @Override
    public float getZ() {
        return super.getZ();
    }

    @Override
    public void setZ(@Px float z) {
        super.setZ(z);
    }

    @Override
    public float getElevation() {
        return super.getElevation();
    }

    @Override
    public void setElevation(@Px float elevation) {
        super.setElevation(elevation);
    }

    @Override
    public float getTranslationX() {
        return super.getTranslationX();
    }

    @Override
    public void setTranslationX(@Px float translationX) {
        super.setTranslationX(translationX);
    }

    @Override
    public float getTranslationY() {
        return super.getTranslationY();
    }

    @Override
    public void setTranslationY(@Px float translationY) {
        super.setTranslationY(translationY);
    }

    @Override
    public float getTranslationZ() {
        return super.getTranslationZ();
    }

    @Override
    public void setTranslationZ(float translationZ) {
        super.setTranslationZ(translationZ);
    }

    @Override
    public StateListAnimator getStateListAnimator() {
        return super.getStateListAnimator();
    }

    @Override
    public void setStateListAnimator(StateListAnimator stateListAnimator) {
        super.setStateListAnimator(stateListAnimator);
    }

    @Override
    public void setClipToOutline(boolean clipToOutline) {
        super.setClipToOutline(clipToOutline);
    }

    @Override
    public void setOutlineProvider(ViewOutlineProvider provider) {
        super.setOutlineProvider(provider);
    }

    @Override
    public ViewOutlineProvider getOutlineProvider() {
        return super.getOutlineProvider();
    }

    @Override
    public void invalidateOutline() {
        super.invalidateOutline();
    }

    @Override
    public void getHitRect(Rect outRect) {
        super.getHitRect(outRect);
    }

    @Override
    public void getFocusedRect(Rect r) {
        super.getFocusedRect(r);
    }

    @Override
    public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
        return super.getGlobalVisibleRect(r, globalOffset);
    }

    @Override
    public void offsetTopAndBottom(@Px int offset) {
        super.offsetTopAndBottom(offset);
    }

    @Override
    public void offsetLeftAndRight(@Px int offset) {
        super.offsetLeftAndRight(offset);
    }

    @Override
    public ViewGroup.LayoutParams getLayoutParams() {
        return super.getLayoutParams();
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
    }

    @Override
    public void scrollTo(@Px int x, @Px int y) {
        super.scrollTo(x, y);
    }

    @Override
    public void scrollBy(@Px int x, @Px int y) {
        super.scrollBy(x, y);
    }

    @Override
    protected boolean awakenScrollBars() {
        return super.awakenScrollBars();
    }

    @Override
    protected boolean awakenScrollBars(int startDelay) {
        return super.awakenScrollBars(startDelay);
    }

    @Override
    protected boolean awakenScrollBars(int startDelay, boolean invalidate) {
        return super.awakenScrollBars(startDelay, invalidate);
    }

    @Override
    public void invalidate(Rect dirty) {
        super.invalidate(dirty);
    }

    @Override
    public void invalidate(int l, int t, int r, int b) {
        super.invalidate(l, t, r, b);
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    @Override
    public boolean isOpaque() {
        return super.isOpaque();
    }

    @Override
    public Handler getHandler() {
        return super.getHandler();
    }

    @Override
    public boolean post(Runnable action) {
        return super.post(action);
    }

    @Override
    public boolean postDelayed(Runnable action, long delayMillis) {
        return super.postDelayed(action, delayMillis);
    }

    @Override
    public void postOnAnimation(Runnable action) {
        super.postOnAnimation(action);
    }

    @Override
    public void postOnAnimationDelayed(Runnable action, long delayMillis) {
        super.postOnAnimationDelayed(action, delayMillis);
    }

    @Override
    public boolean removeCallbacks(Runnable action) {
        return super.removeCallbacks(action);
    }

    @Override
    public void postInvalidate() {
        super.postInvalidate();
    }

    @Override
    public void postInvalidate(int left, int top, int right, int bottom) {
        super.postInvalidate(left, top, right, bottom);
    }

    @Override
    public void postInvalidateDelayed(long delayMilliseconds) {
        super.postInvalidateDelayed(delayMilliseconds);
    }

    @Override
    public void postInvalidateDelayed(long delayMilliseconds, int left, int top, int right, int
            bottom) {
        super.postInvalidateDelayed(delayMilliseconds, left, top, right, bottom);
    }

    @Override
    public void postInvalidateOnAnimation() {
        super.postInvalidateOnAnimation();
    }

    @Override
    public void postInvalidateOnAnimation(int left, int top, int right, int bottom) {
        super.postInvalidateOnAnimation(left, top, right, bottom);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
    }

    @Override
    public boolean isHorizontalFadingEdgeEnabled() {
        return super.isHorizontalFadingEdgeEnabled();
    }

    @Override
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled) {
        super.setHorizontalFadingEdgeEnabled(horizontalFadingEdgeEnabled);
    }

    @Override
    public boolean isVerticalFadingEdgeEnabled() {
        return super.isVerticalFadingEdgeEnabled();
    }

    @Override
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) {
        super.setVerticalFadingEdgeEnabled(verticalFadingEdgeEnabled);
    }

    @Override
    protected float getTopFadingEdgeStrength() {
        return super.getTopFadingEdgeStrength();
    }

    @Override
    protected float getBottomFadingEdgeStrength() {
        return super.getBottomFadingEdgeStrength();
    }

    @Override
    protected float getLeftFadingEdgeStrength() {
        return super.getLeftFadingEdgeStrength();
    }

    @Override
    protected float getRightFadingEdgeStrength() {
        return super.getRightFadingEdgeStrength();
    }

    @Override
    public boolean isHorizontalScrollBarEnabled() {
        return super.isHorizontalScrollBarEnabled();
    }

    @Override
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        super.setHorizontalScrollBarEnabled(horizontalScrollBarEnabled);
    }

    @Override
    public boolean isVerticalScrollBarEnabled() {
        return super.isVerticalScrollBarEnabled();
    }

    @Override
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        super.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
    }

    @Override
    public void setScrollbarFadingEnabled(boolean fadeScrollbars) {
        super.setScrollbarFadingEnabled(fadeScrollbars);
    }

    @Override
    public boolean isScrollbarFadingEnabled() {
        return super.isScrollbarFadingEnabled();
    }

    @Override
    public int getScrollBarDefaultDelayBeforeFade() {
        return super.getScrollBarDefaultDelayBeforeFade();
    }

    @Override
    public void setScrollBarDefaultDelayBeforeFade(int scrollBarDefaultDelayBeforeFade) {
        super.setScrollBarDefaultDelayBeforeFade(scrollBarDefaultDelayBeforeFade);
    }

    @Override
    public int getScrollBarFadeDuration() {
        return super.getScrollBarFadeDuration();
    }

    @Override
    public void setScrollBarFadeDuration(int scrollBarFadeDuration) {
        super.setScrollBarFadeDuration(scrollBarFadeDuration);
    }

    @Override
    public int getScrollBarSize() {
        return super.getScrollBarSize();
    }

    @Override
    public void setScrollBarSize(@Px int scrollBarSize) {
        super.setScrollBarSize(scrollBarSize);
    }

    @Override
    public void setScrollBarStyle(@IntDef(value = {View.SCROLLBARS_INSIDE_OVERLAY, View.SCROLLBARS_INSIDE_INSET, View.SCROLLBARS_OUTSIDE_OVERLAY, View.SCROLLBARS_OUTSIDE_INSET}) int style) {
        super.setScrollBarStyle(style);
    }

    @Override
    public int getScrollBarStyle() {
        return super.getScrollBarStyle();
    }

    @Override
    protected int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override
    protected int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override
    protected int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override
    protected int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    @Override
    protected int computeVerticalScrollOffset() {
        return super.computeVerticalScrollOffset();
    }

    @Override
    protected int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return super.canScrollHorizontally(direction);
    }

    @Override
    public boolean canScrollVertically(int direction) {
        return super.canScrollVertically(direction);
    }

    @Override
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
    }

    @Override
    public void onRtlPropertiesChanged(@IntDef(value = {View.LAYOUT_DIRECTION_LTR, View
            .LAYOUT_DIRECTION_RTL}) int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
    }

    @Override
    public boolean canResolveLayoutDirection() {
        return super.canResolveLayoutDirection();
    }

    @Override
    public boolean isLayoutDirectionResolved() {
        return super.isLayoutDirectionResolved();
    }

    @Override
    protected int getWindowAttachCount() {
        return super.getWindowAttachCount();
    }

    @Override
    public IBinder getWindowToken() {
        return super.getWindowToken();
    }

    @Override
    public WindowId getWindowId() {
        return super.getWindowId();
    }

    @Override
    public IBinder getApplicationWindowToken() {
        return super.getApplicationWindowToken();
    }

    @Override
    public Display getDisplay() {
        return super.getDisplay();
    }

    @Override
    public void onCancelPendingInputEvents() {
        super.onCancelPendingInputEvents();
    }

    @Override
    public void saveHierarchyState(SparseArray<Parcelable> container) {
        super.saveHierarchyState(container);
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        super.dispatchSaveInstanceState(container);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override
    public void restoreHierarchyState(SparseArray<Parcelable> container) {
        super.restoreHierarchyState(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        super.dispatchRestoreInstanceState(container);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }

    @Override
    public long getDrawingTime() {
        return super.getDrawingTime();
    }

    @Override
    public void setDuplicateParentStateEnabled(boolean enabled) {
        super.setDuplicateParentStateEnabled(enabled);
    }

    @Override
    public boolean isDuplicateParentStateEnabled() {
        return super.isDuplicateParentStateEnabled();
    }

    @Override
    public void setLayerType(int layerType, @Nullable Paint paint) {
        super.setLayerType(layerType, paint);
    }

    @Override
    public void setLayerPaint(@Nullable Paint paint) {
        super.setLayerPaint(paint);
    }

    @Override
    public int getLayerType() {
        return super.getLayerType();
    }

    @Override
    public void buildLayer() {
        super.buildLayer();
    }

    @Override
    public void setDrawingCacheEnabled(boolean enabled) {
        super.setDrawingCacheEnabled(enabled);
    }

    @Override
    public boolean isDrawingCacheEnabled() {
        return super.isDrawingCacheEnabled();
    }

    @Override
    public Bitmap getDrawingCache() {
        return super.getDrawingCache();
    }

    @Override
    public Bitmap getDrawingCache(boolean autoScale) {
        return super.getDrawingCache(autoScale);
    }

    @Override
    public void destroyDrawingCache() {
        super.destroyDrawingCache();
    }

    @Override
    public void setDrawingCacheBackgroundColor(@ColorInt int color) {
        super.setDrawingCacheBackgroundColor(color);
    }

    @Override
    public int getDrawingCacheBackgroundColor() {
        return super.getDrawingCacheBackgroundColor();
    }

    @Override
    public void buildDrawingCache() {
        super.buildDrawingCache();
    }

    @Override
    public void buildDrawingCache(boolean autoScale) {
        super.buildDrawingCache(autoScale);
    }

    @Override
    public boolean isInEditMode() {
        return super.isInEditMode();
    }

    @Override
    protected boolean isPaddingOffsetRequired() {
        return super.isPaddingOffsetRequired();
    }

    @Override
    protected int getLeftPaddingOffset() {
        return super.getLeftPaddingOffset();
    }

    @Override
    protected int getRightPaddingOffset() {
        return super.getRightPaddingOffset();
    }

    @Override
    protected int getTopPaddingOffset() {
        return super.getTopPaddingOffset();
    }

    @Override
    protected int getBottomPaddingOffset() {
        return super.getBottomPaddingOffset();
    }

    @Override
    public boolean isHardwareAccelerated() {
        return super.isHardwareAccelerated();
    }

    @Override
    public void setClipBounds(Rect clipBounds) {
        super.setClipBounds(clipBounds);
    }

    @Override
    public Rect getClipBounds() {
        return super.getClipBounds();
    }

    @Override
    public boolean getClipBounds(Rect outRect) {
        return super.getClipBounds(outRect);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override
    public int getSolidColor() {
        return super.getSolidColor();
    }

    @Override
    public boolean isLayoutRequested() {
        return super.isLayoutRequested();
    }

    @Override
    public void layout(@Px int l, @Px int t, @Px int r, @Px int b) {
        super.layout(l, t, r, b);
    }

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    public void invalidateDrawable(@NonNull Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override
    public void scheduleDrawable(@NonNull Drawable who, @NonNull Runnable what, long when) {
        super.scheduleDrawable(who, what, when);
    }

    @Override
    public void unscheduleDrawable(@NonNull Drawable who, @NonNull Runnable what) {
        super.unscheduleDrawable(who, what);
    }

    @Override
    public void unscheduleDrawable(Drawable who) {
        super.unscheduleDrawable(who);
    }

    @Override
    protected boolean verifyDrawable(@NonNull Drawable who) {
        return super.verifyDrawable(who);
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    @Override
    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
    }

    @Override
    public void dispatchDrawableHotspotChanged(float x, float y) {
        super.dispatchDrawableHotspotChanged(x, y);
    }

    @Override
    public void refreshDrawableState() {
        super.refreshDrawableState();
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        return super.onCreateDrawableState(extraSpace);
    }

    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    }

    @Override
    public void setBackgroundColor(@ColorInt int color) {
        super.setBackgroundColor(color);
    }

    @Override
    public void setBackgroundResource(@DrawableRes int resid) {
        super.setBackgroundResource(resid);
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
    }

    @Override
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
    }

    @Override
    public Drawable getBackground() {
        return super.getBackground();
    }

    @Override
    public void setBackgroundTintList(@Nullable ColorStateList tint) {
        super.setBackgroundTintList(tint);
    }

    @Nullable
    @Override
    public ColorStateList getBackgroundTintList() {
        return super.getBackgroundTintList();
    }

    @Override
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode tintMode) {
        super.setBackgroundTintMode(tintMode);
    }

    @Nullable
    @Override
    public PorterDuff.Mode getBackgroundTintMode() {
        return super.getBackgroundTintMode();
    }

    @Override
    public Drawable getForeground() {
        return super.getForeground();
    }

    @Override
    public void setForeground(Drawable foreground) {
        super.setForeground(foreground);
    }

    @Override
    public int getForegroundGravity() {
        return super.getForegroundGravity();
    }

    @Override
    public void setForegroundGravity(int gravity) {
        super.setForegroundGravity(gravity);
    }

    @Override
    public void setForegroundTintList(@Nullable ColorStateList tint) {
        super.setForegroundTintList(tint);
    }

    @Nullable
    @Override
    public ColorStateList getForegroundTintList() {
        return super.getForegroundTintList();
    }

    @Override
    public void setForegroundTintMode(@Nullable PorterDuff.Mode tintMode) {
        super.setForegroundTintMode(tintMode);
    }

    @Nullable
    @Override
    public PorterDuff.Mode getForegroundTintMode() {
        return super.getForegroundTintMode();
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }

    @Override
    public void setPadding(@Px int left, @Px int top, @Px int right, @Px int bottom) {
        super.setPadding(left, top, right, bottom);
    }

    @Override
    public void setPaddingRelative(@Px int start, @Px int top, @Px int end, @Px int bottom) {
        super.setPaddingRelative(start, top, end, bottom);
    }

    @Override
    public int getPaddingTop() {
        return super.getPaddingTop();
    }

    @Override
    public int getPaddingBottom() {
        return super.getPaddingBottom();
    }

    @Override
    public int getPaddingLeft() {
        return super.getPaddingLeft();
    }

    @Override
    public int getPaddingStart() {
        return super.getPaddingStart();
    }

    @Override
    public int getPaddingRight() {
        return super.getPaddingRight();
    }

    @Override
    public int getPaddingEnd() {
        return super.getPaddingEnd();
    }

    @Override
    public boolean isPaddingRelative() {
        return super.isPaddingRelative();
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
    }

    @Override
    protected void dispatchSetSelected(boolean selected) {
        super.dispatchSetSelected(selected);
    }

    @Override
    public boolean isSelected() {
        return super.isSelected();
    }

    @Override
    public void setActivated(boolean activated) {
        super.setActivated(activated);
    }

    @Override
    protected void dispatchSetActivated(boolean activated) {
        super.dispatchSetActivated(activated);
    }

    @Override
    public boolean isActivated() {
        return super.isActivated();
    }

    @Override
    public ViewTreeObserver getViewTreeObserver() {
        return super.getViewTreeObserver();
    }

    @Override
    public View getRootView() {
        return super.getRootView();
    }

    @Override
    public void getLocationOnScreen(@Size(value = 2) int[] outLocation) {
        super.getLocationOnScreen(outLocation);
    }

    @Override
    public void getLocationInWindow(@Size(value = 2) int[] outLocation) {
        super.getLocationInWindow(outLocation);
    }

    @Override
    public void setId(@IdRes int id) {
        super.setId(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public Object getTag() {
        return super.getTag();
    }

    @Override
    public void setTag(Object tag) {
        super.setTag(tag);
    }

    @Override
    public Object getTag(int key) {
        return super.getTag(key);
    }

    @Override
    public void setTag(int key, Object tag) {
        super.setTag(key, tag);
    }

    @Override
    public int getBaseline() {
        return super.getBaseline();
    }

    @Override
    public boolean isInLayout() {
        return super.isInLayout();
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
    }

    @Override
    public void forceLayout() {
        super.forceLayout();
    }

    @Override
    protected int getSuggestedMinimumHeight() {
        return super.getSuggestedMinimumHeight();
    }

    @Override
    protected int getSuggestedMinimumWidth() {
        return super.getSuggestedMinimumWidth();
    }

    @Override
    public int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override
    public void setMinimumHeight(int minHeight) {
        super.setMinimumHeight(minHeight);
    }

    @Override
    public int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override
    public void setMinimumWidth(int minWidth) {
        super.setMinimumWidth(minWidth);
    }

    @Override
    public Animation getAnimation() {
        return super.getAnimation();
    }

    @Override
    public void startAnimation(Animation animation) {
        super.startAnimation(animation);
    }

    @Override
    public void clearAnimation() {
        super.clearAnimation();
    }

    @Override
    public void setAnimation(Animation animation) {
        super.setAnimation(animation);
    }

    @Override
    protected void onAnimationStart() {
        super.onAnimationStart();
    }

    @Override
    protected void onAnimationEnd() {
        super.onAnimationEnd();
    }

    @Override
    protected boolean onSetAlpha(int alpha) {
        return super.onSetAlpha(alpha);
    }

    @Override
    public void playSoundEffect(int soundConstant) {
        super.playSoundEffect(soundConstant);
    }

    @Override
    public boolean performHapticFeedback(int feedbackConstant) {
        return super.performHapticFeedback(feedbackConstant);
    }

    @Override
    public boolean performHapticFeedback(int feedbackConstant, int flags) {
        return super.performHapticFeedback(feedbackConstant, flags);
    }

    @Override
    public void setSystemUiVisibility(int visibility) {
        super.setSystemUiVisibility(visibility);
    }

    @Override
    public int getSystemUiVisibility() {
        return super.getSystemUiVisibility();
    }

    @Override
    public int getWindowSystemUiVisibility() {
        return super.getWindowSystemUiVisibility();
    }

    @Override
    public void onWindowSystemUiVisibilityChanged(int visible) {
        super.onWindowSystemUiVisibilityChanged(visible);
    }

    @Override
    public void dispatchWindowSystemUiVisiblityChanged(int visible) {
        super.dispatchWindowSystemUiVisiblityChanged(visible);
    }

    @Override
    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener l) {
        super.setOnSystemUiVisibilityChangeListener(l);
    }

    @Override
    public void dispatchSystemUiVisibilityChanged(int visibility) {
        super.dispatchSystemUiVisibilityChanged(visibility);
    }

    @Override
    public boolean onDragEvent(DragEvent event) {
        return super.onDragEvent(event);
    }

    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        return super.dispatchDragEvent(event);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int
            scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean
            isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY,
                maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }

    @Override
    public int getOverScrollMode() {
        return super.getOverScrollMode();
    }

    @Override
    public void setOverScrollMode(int overScrollMode) {
        super.setOverScrollMode(overScrollMode);
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        super.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return super.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        return super.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        super.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        return super.hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable @Size(value = 2) int[] offsetInWindow) {
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, @Nullable @Size(value = 2) int[] consumed, @Nullable @Size(value = 2) int[] offsetInWindow) {
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return super.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return super.dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override
    public void setTextDirection(@IntDef(value = {View.TEXT_DIRECTION_INHERIT, View.TEXT_DIRECTION_LTR, View.TEXT_DIRECTION_RTL, View.TEXT_DIRECTION_ANY_RTL, View.TEXT_DIRECTION_LOCALE, View.TEXT_DIRECTION_FIRST_STRONG, View.TEXT_DIRECTION_FIRST_STRONG_LTR, View.TEXT_DIRECTION_FIRST_STRONG_RTL}) int textDirection) {
        super.setTextDirection(textDirection);
    }

    @Override
    public int getTextDirection() {
        return super.getTextDirection();
    }

    @Override
    public boolean canResolveTextDirection() {
        return super.canResolveTextDirection();
    }

    @Override
    public boolean isTextDirectionResolved() {
        return super.isTextDirectionResolved();
    }

    @Override
    public void setTextAlignment(@IntDef(value = {View.TEXT_ALIGNMENT_INHERIT, View.TEXT_ALIGNMENT_GRAVITY, View.TEXT_ALIGNMENT_CENTER, View.TEXT_ALIGNMENT_TEXT_START, View.TEXT_ALIGNMENT_TEXT_END, View.TEXT_ALIGNMENT_VIEW_START, View.TEXT_ALIGNMENT_VIEW_END}) int textAlignment) {
        super.setTextAlignment(textAlignment);
    }

    @Override
    public int getTextAlignment() {
        return super.getTextAlignment();
    }

    @Override
    public boolean canResolveTextAlignment() {
        return super.canResolveTextAlignment();
    }

    @Override
    public boolean isTextAlignmentResolved() {
        return super.isTextAlignmentResolved();
    }

    @Override
    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        return super.onResolvePointerIcon(event, pointerIndex);
    }

    @Override
    public void setPointerIcon(PointerIcon pointerIcon) {
        super.setPointerIcon(pointerIcon);
    }

    @Override
    public PointerIcon getPointerIcon() {
        return super.getPointerIcon();
    }

    @Override
    public ViewPropertyAnimator animate() {
        return super.animate();
    }

    @Override
    public String getTransitionName() {
        return super.getTransitionName();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
