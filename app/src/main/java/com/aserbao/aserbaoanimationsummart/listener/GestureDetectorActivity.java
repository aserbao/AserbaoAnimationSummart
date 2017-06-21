package com.aserbao.aserbaoanimationsummart.listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;

public class GestureDetectorActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{
    GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector);
        detector = new GestureDetector(this);
    }

    //将该activity上的触碰事件交给GestureDetector处理
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Toast.makeText(this, "onDown", Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Toast.makeText(this, "onShowPress", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(this, "onSingleTapUp", Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(this, "onScroll", Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(this, "onLongPress", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float minMove = 120;         //最小滑动距离
        float minVelocity = 0;      //最小滑动速度
        float beginX = e1.getX();
        float endX = e2.getX();
        float beginY = e1.getY();
        float endY = e2.getY();

        if(beginX-endX>minMove&&Math.abs(velocityX)>minVelocity){   //左滑
            Toast.makeText(this,velocityX+"左滑",Toast.LENGTH_SHORT).show();
        }else if(endX-beginX>minMove&&Math.abs(velocityX)>minVelocity){   //右滑
            Toast.makeText(this,velocityX+"右滑",Toast.LENGTH_SHORT).show();
        }else if(beginY-endY>minMove&&Math.abs(velocityY)>minVelocity){   //上滑
            Toast.makeText(this,velocityX+"上滑",Toast.LENGTH_SHORT).show();
        }else if(endY-beginY>minMove&&Math.abs(velocityY)>minVelocity){   //下滑
            Toast.makeText(this,velocityX+"下滑",Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void btn_test_click(View view) {
        Toast.makeText(this, "按钮可以点击", Toast.LENGTH_SHORT).show();
    }
}
