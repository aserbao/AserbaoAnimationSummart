package com.aserbao.aserbaoanimationsummart.classify.screen;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * description:
 * Created by aserbao on 2017/10/30.
 */


public class Screen extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.SCREEN_OFF")){
                System.out.println("屏幕锁屏了");
            }else if (action.equals("android.intent.action.SCREEN_ON")){
                System.out.println("屏幕解锁了");
            }
        }
}
