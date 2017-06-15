package com.aserbao.aserbaoanimationsummart.media.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.media.camera.gles.FullFrameRect;
import com.aserbao.aserbaoanimationsummart.media.camera.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class CameraActivity extends FUBaseUIActivity  implements Camera.PreviewCallback,
        SurfaceTexture.OnFrameAvailableListener  {
    private static final String TAG = "CameraActivity";
    Camera mCamera;

    GLSurfaceView glSf;
    GLRenderer glRenderer;

    Handler mMainHandler;
    int cameraWidth = 1280;
    int cameraHeight = 720;

    byte[] mCameraNV21Byte;
    int mFrameId = 0;

    int mFacebeautyItem = 0; //美颜道具
    int mEffectItem = 0; //道具

    long resumeTimeStamp;
    boolean isFirstOnFrameAvailable;
    long frameAvailableTimeStamp;

    boolean VERBOSE_LOG = false;

    float mFacebeautyColorLevel = 0.5f;
    float mFacebeautyBlurLevel = 6.0f;
    float mFacebeautyCheeckThin = 1.0f;
    float mFacebeautyEnlargeEye = 1.0f;

    String mFilterName = FILTERS_NAME[0];
    public final static String[] FILTERS_NAME = {"nature", "delta", "electric", "slowlived", "tokyo", "warm"};

    String mEffectFileName = EFFECT_ITEM_FILE_NAME[1];
    public static final String[] EFFECT_ITEM_FILE_NAME = {"none", "tiara.mp3", "item0208.mp3",
            "YellowEar.mp3", "PrincessCrown.mp3", "Mood.mp3", "Deer.mp3", "BeagleDog.mp3", "item0501.mp3",
            "ColorCrown.mp3", "item0210.mp3",  "HappyRabbi.mp3", "item0204.mp3", "hartshorn.mp3"};
    int mCurrentCameraType;
    boolean mUseBeauty = true;

    long lastOneHundredFrameTimeStamp = 0;
    int currentFrameCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        mMainHandler = new MainHandler(this);
        glSf = (GLSurfaceView) findViewById(R.id.glsv);
        glSf.setEGLContextClientVersion(2);
        glRenderer = new GLRenderer();
        glSf.setRenderer(glRenderer);
        glSf.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");

        resumeTimeStamp = System.currentTimeMillis();
        isFirstOnFrameAvailable = true;

        super.onResume();

        openCamera(Camera.CameraInfo.CAMERA_FACING_FRONT,
                cameraWidth,
                cameraHeight);

        /**
         * 请注意这个地方, camera返回的图像并不一定是设置的大小（因为可能并不支持）
         */
        Camera.Size size = mCamera.getParameters().getPreviewSize();
        cameraWidth = size.width;
        cameraHeight = size.height;
        Log.e(TAG, "open camera size " + size.width + " " + size.height);

        AspectFrameLayout aspectFrameLayout = (AspectFrameLayout) findViewById(R.id.afl);
        aspectFrameLayout.setAspectRatio(1.0f * cameraHeight / cameraWidth);

        glSf.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();

        releaseCamera();

        mFrameId = 0;

        glSf.queueEvent(new Runnable() {
            @Override
            public void run() {
                //Note: 切忌使用一个已经destroy的item
                faceunity.fuDestroyItem(mEffectItem);
                mEffectItem = 0;
                faceunity.fuDestroyItem(mFacebeautyItem);
                mFacebeautyItem = 0;
                faceunity.fuOnDeviceLost();
            }
        });
        glRenderer.notifyPause();
        glSf.onPause();
    }


    @Override
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Log.d(TAG, "onFrameAvailable: ");
        if (isFirstOnFrameAvailable) {
            frameAvailableTimeStamp = System.currentTimeMillis();
            isFirstOnFrameAvailable = false;
            Log.e(TAG, "first frame available time cost " +
                    (frameAvailableTimeStamp - resumeTimeStamp));
        }
        if (VERBOSE_LOG) {
            Log.d(TAG, "onFrameAvailable");
        }
        glSf.requestRender();
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        Log.d(TAG, "onPreviewFrame: ");
        if (VERBOSE_LOG) {
            Log.d(TAG, "onPreviewFrame");
            Log.d(TAG, "onPreviewThread " + Thread.currentThread());
        }
        mCameraNV21Byte = data;
    }
    class GLRenderer implements GLSurfaceView.Renderer{
        FullFrameRect mFullScreenFUDisplay;
        FullFrameRect mFullScreenCamera;

        int mCameraTextureId;

        boolean isFirstOnDrawFrame;
        SurfaceTexture mCameraSurfaceTexture;

        int faceTrackingStatus = 0;

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            Log.d(TAG, "onSurfaceCreated: ");
            mFullScreenCamera = new FullFrameRect(new Texture2dProgram(
                    Texture2dProgram.ProgramType.TEXTURE_EXT));
            mCameraTextureId = mFullScreenCamera.createTextureObject();
            mCameraSurfaceTexture = new SurfaceTexture(mCameraTextureId);
            mMainHandler.sendMessage(mMainHandler.obtainMessage(
                    MainHandler.HANDLE_CAMERA_START_PREVIEW,
                    mCameraSurfaceTexture));

            mFullScreenFUDisplay = new FullFrameRect(new Texture2dProgram(
                    Texture2dProgram.ProgramType.TEXTURE_2D));
            try {
                InputStream is = getAssets().open("v3.mp3");
                byte[] v3data = new byte[is.available()];
                is.read(v3data);
                is.close();
                faceunity.fuSetup(v3data, null, authpack.A());
                faceunity.fuSetMaxFaces(1);

                if (mUseBeauty) {
                    is = getAssets().open("face_beautification.mp3");
                    byte[] itemData = new byte[is.available()];
                    is.read(itemData);
                    is.close();
                    mFacebeautyItem = faceunity.fuCreateItemFromPackage(itemData);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            isFirstOnDrawFrame = true;

        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            Log.d(TAG, "onSurfaceChanged: ");
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            Log.d(TAG, "onDrawFrame: ");
            if (isFirstOnDrawFrame) {
                //第一次onDrawFrame并不是由camera内容驱动的
                isFirstOnDrawFrame = false;
                return;
            }

            if (++currentFrameCnt == 100) {
                currentFrameCnt = 0;
                long tmp = System.currentTimeMillis();
                lastOneHundredFrameTimeStamp = tmp;
            }

            /**
             * 获取camera数据, 更新到texture
             */
            float[] mtx = new float[16];
            mCameraSurfaceTexture.updateTexImage();
            mCameraSurfaceTexture.getTransformMatrix(mtx);

            final int isTracking = faceunity.fuIsTracking();
            if (isTracking != faceTrackingStatus) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (isTracking == 0) {
                            Toast.makeText(CameraActivity.this, "未检测到人脸", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CameraActivity.this, "检测到人脸", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                faceTrackingStatus = isTracking;
            }
            if (VERBOSE_LOG) {
            }

            if (mEffectItem == 0) {
                try {
                    InputStream is = getAssets().open(mEffectFileName);
                    byte[] itemData = new byte[is.available()];
                    is.read(itemData);
                    is.close();
                    mEffectItem = faceunity.fuCreateItemFromPackage(itemData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            faceunity.fuItemSetParam(mEffectItem, "isAndroid", 1.0);

            faceunity.fuItemSetParam(mFacebeautyItem, "color_level", mFacebeautyColorLevel);
            faceunity.fuItemSetParam(mFacebeautyItem, "blur_level", mFacebeautyBlurLevel);
            faceunity.fuItemSetParam(mFacebeautyItem, "filter_name", mFilterName);
            faceunity.fuItemSetParam(mFacebeautyItem, "cheek_thinning", mFacebeautyCheeckThin);
            faceunity.fuItemSetParam(mFacebeautyItem, "eye_enlarging", mFacebeautyEnlargeEye);

            /**
             * 这里拿到fu处理过后的texture，可以对这个texture做后续操作，如硬编、预览。
             */
            boolean isOESTexture = true; //camera默认的是OES的
            int flags = isOESTexture ? faceunity.FU_ADM_FLAG_EXTERNAL_OES_TEXTURE : 0;
            int fuTex = faceunity.fuDualInputToTexture(mCameraNV21Byte, mCameraTextureId, flags,
                    cameraWidth, cameraHeight, mFrameId++, new int[] {mEffectItem, mFacebeautyItem});
            //int fuTex = faceunity.fuBeautifyImage(mCameraTextureId, flags,
            //            cameraWidth, cameraHeight, mFrameId++, new int[] {mEffectItem, mFacebeautyItem});
            //mFullScreenCamera.drawFrame(mCameraTextureId, mtx);
            mFullScreenFUDisplay.drawFrame(fuTex, mtx);
        }

        public void notifyPause() {
            Log.d(TAG, "notifyPause: ");
            faceTrackingStatus = 0;
            if (mFullScreenFUDisplay != null) {
                mFullScreenFUDisplay.release(false);
            }

            if (mFullScreenCamera != null) {
                mFullScreenCamera.release(false);
            }

            if (mCameraSurfaceTexture != null) {
                mCameraSurfaceTexture.release();
            }
        }
    }
    static class MainHandler extends Handler {

        static final int HANDLE_CAMERA_START_PREVIEW = 1;

        private WeakReference<CameraActivity> mActivityWeakReference;

        MainHandler(CameraActivity activity) {
            mActivityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            CameraActivity activity = mActivityWeakReference.get();
            switch (msg.what) {
                case HANDLE_CAMERA_START_PREVIEW:
                    activity.handleCameraStartPreview((SurfaceTexture) msg.obj);
                    break;
            }
        }
    }
    /**
     * set preview and start preview after the surface created
     * */
    private void handleCameraStartPreview(SurfaceTexture surfaceTexture) {
        mCamera.setPreviewCallback(this);
        try {
            mCamera.setPreviewTexture(surfaceTexture);
        } catch (IOException e) {
            e.printStackTrace();
        }
        surfaceTexture.setOnFrameAvailableListener(this);
        mCamera.startPreview();
    }


    private void openCamera(int cameraType, int desiredWidth, int desiredHeight) {
        Log.d(TAG, "openCamera");
        if (mCamera != null) {
            throw new RuntimeException("camera already initialized");
        }

        Camera.CameraInfo info = new Camera.CameraInfo();
        int cameraId = 0;
        int numCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numCameras; i++) {
            Camera.getCameraInfo(i, info);
            if (info.facing == cameraType) {
                cameraId = i;
                mCamera = Camera.open(i);
                mCurrentCameraType = cameraType;
                break;
            }
        }
        if (mCamera == null) {
            throw new RuntimeException("unable to open camera");
        }

        CameraUtils.setCameraDisplayOrientation(this, cameraId, mCamera);

        Camera.Parameters parameters = mCamera.getParameters();
        List<String> focusModes = parameters.getSupportedFocusModes();
        if (focusModes.contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO))
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
        mCamera.setDisplayOrientation(90);
        CameraUtils.choosePreviewSize(parameters, desiredWidth, desiredHeight);
        mCamera.setParameters(parameters);
    }

    private void releaseCamera() {
        Log.d(TAG, "releaseCamera: ");
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            try {
                mCamera.setPreviewTexture(null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            mCamera.release();
            mCamera = null;
            Log.e(TAG, "release camera");
        }
    }
}
