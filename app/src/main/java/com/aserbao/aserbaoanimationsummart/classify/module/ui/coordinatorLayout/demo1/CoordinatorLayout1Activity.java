package com.aserbao.aserbaoanimationsummart.classify.module.ui.coordinatorLayout.demo1;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.aserbao.aserbaoanimationsummart.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoordinatorLayout1Activity extends AppCompatActivity {


    @BindView(R.id.main_backdrop)
    ImageView mMainBackdrop;
    @BindView(R.id.main_toolbar)
    Toolbar mMainToolbar;
    @BindView(R.id.main_collapsing)
    CollapsingToolbarLayout mMainCollapsing;
    @BindView(R.id.main_appbar)
    AppBarLayout mMainAppbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//状态栏半透明
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_coordinator_layout1);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(mMainToolbar);
    }
}
