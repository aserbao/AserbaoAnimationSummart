package com.aserbao.aserbaoanimationsummart.classify.screen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

    //当手机重启会执行这个方法
    @Override
    public void onReceive(Context context, Intent intent) {

        //开启mainActivity
        Intent intent2 = new Intent(context,ScreenListenerActivity.class);
        //☆ 如果在广播里面开启Activity 要设置一个任务栈环境
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //在广播接收者里面开启activity
        context.startActivity(intent2);

    }

}