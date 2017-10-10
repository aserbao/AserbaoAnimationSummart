package com.aserbao.aserbaolibrary.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.aserbao.aserbaolibrary.R;
import com.aserbao.aserbaolibrary.popup.CommonPopupWindow;

public class AserbaoActivity extends AppCompatActivity implements CommonPopupWindow.ViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aserbao);

    }
    private CommonPopupWindow popupWindow;
    private void init() {
        popupWindow = new CommonPopupWindow.Builder(this)
                        .setView(R.layout.activity_aserbao)
                        .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                        .setAnimationStyle(1)
                        .setViewOnclickListener(this)
                        .setOutsideTouchable(true)
                         .create();
        popupWindow.showAtLocation(getCurrentFocus().getRootView(), Gravity.CENTER,0,0);
//        popupWindow.showAsDropDown(view);

    }

    @Override
    public void getChildView(View view, int layoutResId) {

    }

    public void show(View view) {
        init();
    }
}
