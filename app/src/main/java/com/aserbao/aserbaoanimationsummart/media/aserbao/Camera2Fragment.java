package com.aserbao.aserbaoanimationsummart.media.aserbao;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

import com.aserbao.aserbaoanimationsummart.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * description:
 * Created by aserbao on 2017/10/16.
 */

public class Camera2Fragment extends Fragment implements View.OnClickListener{
    private TextureView mTextureView;
    private File mFile;
    private HandlerThread mBackgroundThread;
    private Handler mBackgroundHandler;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera2,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.picture).setOnClickListener(this);
        mTextureView = (TextureView) view.findViewById(R.id.texture);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFile = getOutputMediaFile();
    }

    @Override
    public void onResume() {
        super.onResume();
        startBackgroundThread();
        if(mTextureView.isAvailable()){
            openCamera(mTextureView.getWidth(), mTextureView.getHeight());
        }else{
//            mTextureView.setSurfaceTextureListener(mSurfaceTextureListener);
        }
    }
    public static Camera2Fragment newInstance(){
        return new Camera2Fragment();
    }
    @Override
    public void onClick(View v) {

    }

    /**
     * @return 获取输出路径
     */
    private File getOutputMediaFile(){
        //get the mobile Pictures directory
        File picDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        //get the current time
        String timeStamp = new SimpleDateFormat("yyyy-MMdd-HHmmss").format(new Date());
        return new File(picDir.getPath() + File.separator + "hejunlin_camera2_"+ timeStamp + ".jpg");
    }
    /**
     * Starts a background thread and its {@link Handler}.
     */
    private void startBackgroundThread() {
        mBackgroundThread = new HandlerThread("CameraBackground");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
    }

    private void openCamera(int width, int height) {

    }

}
