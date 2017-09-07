package com.aserbao.aserbaoanimationsummart.aCustom;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.aserbao.aserbaoanimationsummart.R;

/**
 * description:
 * Created by aserbao on 2017/9/7.
 */


public class CustomProgressView extends FrameLayout {
    private ProgressBar mPbOne;
    private ProgressBar mPbTwo;

    public CustomProgressView(@NonNull Context context) {
        this(context,null);
    }

    public CustomProgressView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomProgressView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.custom_progress_view, this);
        mPbOne = ((ProgressBar) view.findViewById(R.id.custom_pb_one));
        mPbTwo = ((ProgressBar) view.findViewById(R.id.custom_pb_two));
    }
}
