package com.aserbao.aserbaoanimationsummart;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by aserbao on 2017 2017/12/13.22:00
 * Email:1142803753@qq.com
 * weixin: aserbao
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
