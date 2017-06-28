package com.aserbao.aserbaoanimationsummart.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.aserbao.aserbaoanimationsummart.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DispatchActivity extends AppCompatActivity {
    private static final String TAG = "DispatchActivity";
   /* @BindView(R.id.btn_dispatch_test)
    Button mBtnDispatchTest;*/
    private Button mButtonTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
        mButtonTest = (Button) findViewById(R.id.btn_dispatch_test);
        mButtonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
            }
        });
        mButtonTest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "onTouch: "+event.getAction());
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: "+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

}
