package com.aserbao.aserbaoanimationsummart.classify.module.ui.timepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.timepicker.wheelview.adapter
        .ArrayWheelAdapter;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.timepicker.wheelview.lib.WheelView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimePickerActivity extends AppCompatActivity {


    @BindView(R.id.wheel_view_hour)
    WheelView mWheelViewHour;
    @BindView(R.id.wheel_view_minuter)
    WheelView mWheelViewMinuter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private ArrayList<String> mArrayListHour;
    private ArrayList<String> mArrayListMinuter;

    private void initData() {
        mArrayListHour = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            mArrayListHour.add(String.valueOf(i));
        }
        mArrayListMinuter = new ArrayList<>();
        for (int i = 0; i < 59; i++) {
            mArrayListMinuter.add(String.valueOf(i));
        }
    }

    private void initView() {
        mWheelViewHour.setAdapter(new ArrayWheelAdapter<String>(mArrayListHour));
        mWheelViewMinuter.setAdapter(new ArrayWheelAdapter<String>(mArrayListMinuter));
    }
}
