package com.aserbao.aserbaoanimationsummart.media.record;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordActivity extends AppCompatActivity {

    File soundFile;
    MediaRecorder mRecorder;
    @BindView(R.id.start_record)
    Button mStartRecord;
    @BindView(R.id.stop_record)
    Button mStopRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ButterKnife.bind(this);
    }
    @Override
    protected void onDestroy() {
        if (soundFile != null && soundFile.exists()) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }
        super.onDestroy();
    }



    @OnClick({R.id.start_record, R.id.stop_record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_record:
                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(this, "请插入SD卡", Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        soundFile = new File(Environment.getExternalStorageDirectory().getCanonicalFile() + "/sound.amr");
                        mRecorder = new MediaRecorder();
                        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        mRecorder.setOutputFile(soundFile.getAbsolutePath());
                        mRecorder.prepare();
                        mRecorder.start();
                        Toast.makeText(this, "开始录制", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.stop_record:
                if (soundFile != null && soundFile.exists()) {
                    mRecorder.stop();
                    mRecorder.release();
                    mRecorder = null;
                    Toast.makeText(this, "录制完成，请到文件管理器中查找", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}
