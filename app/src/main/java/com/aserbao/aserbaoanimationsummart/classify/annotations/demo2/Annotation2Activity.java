package com.aserbao.aserbaoanimationsummart.classify.annotations.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo2.annotations.ContentView;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo2.annotations.OnClick;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo2.annotations.ViewInject;

import butterknife.ButterKnife;

@ContentView(R.layout.activity_annotation2)
public class Annotation2Activity extends AppCompatActivity {

    @ViewInject(R.id.annotation_btn1)
    Button mButton1;
    @ViewInject(R.id.annotation_btn2)
    Button mButton2;
    @ViewInject(R.id.annotation_text)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.injectContentView(this);
        ViewUtils.injectViews(this);
        ViewUtils.injectEvents(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    private void init() {
        mTextView.setText("The second part is already done");
    }

    @OnClick({R.id.annotation_btn1,  R.id.annotation_btn2})
    public void clickBtnInvoked(View view){
        switch (view.getId()){
            case R.id.annotation_btn1:
                Toast.makeText(this, "toast num one", Toast.LENGTH_SHORT).show();
                break;
            case R.id.annotation_btn2:
                Toast.makeText(this, "toast num two", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
