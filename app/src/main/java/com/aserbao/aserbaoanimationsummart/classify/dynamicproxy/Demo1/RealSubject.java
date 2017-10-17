package com.aserbao.aserbaoanimationsummart.classify.dynamicproxy.Demo1;

import android.util.Log;

/**
 * description:
 * Created by aserbao on 2017/10/17.
 */


public class RealSubject implements Subject {
    private static final String TAG = "RealSubject";
    @Override
    public void request() {
        Log.e(TAG, "request: ");
    }
}
