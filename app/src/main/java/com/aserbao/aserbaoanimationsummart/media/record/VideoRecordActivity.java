package com.aserbao.aserbaoanimationsummart.media.record;

import android.graphics.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Size;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;

import java.io.File;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoRecordActivity extends AppCompatActivity {

    @BindView(R.id.sView)
    SurfaceView sView;
    @BindView(R.id.start)
    Button mStart;
    @BindView(R.id.stop)
    Button mStop;
    private MediaRecorder mRecorder;
    private File videoFile;
    private boolean isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_record);
        ButterKnife.bind(this);
        // 设置分辨率
        sView.getHolder().setFixedSize(320, 240);
        // 设置该组件让屏幕不会自动关闭
        sView.getHolder().setKeepScreenOn(true);
    }

    @OnClick({R.id.start, R.id.stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start:
                if (!Environment.getExternalStorageState().equals(
                        android.os.Environment.MEDIA_MOUNTED))
                {
                    Toast.makeText(VideoRecordActivity.this
                            , "SD卡不存在，请插入SD卡！"
                            , Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    videoFile = new File(Environment
                            .getExternalStorageDirectory()
                            .getCanonicalFile() + "/myvideo.mp4");
                mRecorder = new MediaRecorder();
                mRecorder.reset();
                mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                mRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                mRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
                mRecorder.setVideoSize(320, 240);//每个手机的屏幕视频都不一样，需要调整
                mRecorder.setVideoFrameRate(4);
                mRecorder.setOutputFile(videoFile.getAbsolutePath());
                mRecorder.setPreviewDisplay(sView.getHolder().getSurface());  // ①
                mRecorder.prepare();
                mRecorder.start();
                    Toast.makeText(this, videoFile.toString(), Toast.LENGTH_SHORT).show();
                    mStart.setEnabled(false);
                    mStop.setEnabled(true);
                isRecording = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.stop:
                if (isRecording) {
                    // 停止录制
                    mRecorder.stop();
                    // 释放资源
                    mRecorder.release();
                    mRecorder = null;
                    // 让record按钮可用
                    mStart.setEnabled(true);
                    // 让stop按钮不可用
                    mStop.setEnabled(false);
                }
                break;
        }
    }
}
