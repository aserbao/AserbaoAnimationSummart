package com.aserbao.aserbaolibrary.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aserbao.aserbaolibrary.R;
import com.aserbao.aserbaolibrary.theme.ResideLayout;

public class ResideActivity extends AppCompatActivity {

    private ResideLayout mResideLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reside);
        mResideLayout = (ResideLayout) findViewById(R.id.reside_layout);
        initEvent();
    }

    private void initEvent() {
        mResideLayout.setPanelSlideListener(new ResideLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Toast.makeText(ResideActivity.this, "true", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPanelOpened(View panel) {
                Toast.makeText(ResideActivity.this, "true", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPanelClosed(View panel) {
                Toast.makeText(ResideActivity.this, "false", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mResideLayout.isOpen()) {
            mResideLayout.closePane();
        }else{
            mResideLayout.openPane();
        }
//        super.onBackPressed();
    }
}
