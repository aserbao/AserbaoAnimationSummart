package com.linj.video.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/** 
 * @ClassName: VideoSurfaceView 
 * @Description:  ��MediaPlayer�󶨵�SurfaceView�����Բ�����Ƶ
 * @author LinJ
 * @date 2015-1-21 ����2:38:53 
 *  
 */
public class VideoPlayerView extends SurfaceView implements VideoPlayerOperation {
	private final static String TAG="VideoSurfaceView";
	private MediaPlayer mMediaPlayer;
	public VideoPlayerView(Context context){
		super(context);
		init();
	}
	public VideoPlayerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();

	}
	/**  
	 *   ��ʼ��
	 */
	private void init() {
		mMediaPlayer=new MediaPlayer();
		//��ʼ������
		getHolder().addCallback(callback);
	}
	/**  
	 *  ���ò�������������
	 *  @param listener   
	 */
	protected void setPalyerListener(PlayerListener listener){
		mMediaPlayer.setOnCompletionListener(listener);
		mMediaPlayer.setOnSeekCompleteListener(listener);
		mMediaPlayer.setOnPreparedListener(listener);
	}
	/**  
	 *  ��ȡ��ǰ�������Ƿ��ڲ���״̬
	 *  @return   
	 */
	@Override
	public boolean isPlaying(){
		return mMediaPlayer.isPlaying();
	}

	/**  
	 *  ��ȡ��ǰ����ʱ�䣬��λ����
	 *  @return   
	 */
	@Override
	public int getCurrentPosition(){
		if(isPlaying())
			return mMediaPlayer.getCurrentPosition();
		return 0;
	}



	@Override
	public void pausedPlay() {
		mMediaPlayer.pause();
	}
	@Override
	public void resumePlay() {
		// TODO Auto-generated method stub
		mMediaPlayer.start();
	}

	/**  
	 *   ���õ�ǰ����λ��
	 */
	@Override
	public void seekPosition(int position){
		if(isPlaying())
			mMediaPlayer.pause();
		//�����õ�ʱ��ֵ������Ƶ��󳤶�ʱ��ֹͣ����
		if(position<0||position>mMediaPlayer.getDuration()){
			mMediaPlayer.stop();
			return;
		}
		//����ʱ��
		mMediaPlayer.seekTo(position);
	}

	/**  
	 *   ֹͣ����
	 */
	@Override
	public void stopPlay() {
		mMediaPlayer.stop();
		mMediaPlayer.reset();
	}

	private SurfaceHolder.Callback callback=new SurfaceHolder.Callback() {

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			mMediaPlayer.setDisplay(getHolder());  		
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {

		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			if(mMediaPlayer.isPlaying())
				mMediaPlayer.stop();
			mMediaPlayer.reset();
		}
	};
	@Override
	public void playVideo(String path) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException{

		if(mMediaPlayer!=null&&mMediaPlayer.isPlaying()){
			mMediaPlayer.stop();
		}
		mMediaPlayer.reset(); //reset�������ò���������
		mMediaPlayer.setDataSource(path);
		mMediaPlayer.prepare();
	}

	/** 
	 * @ClassName: PlayerListener 
	 * @Description:  ���Ͻӿڣ�containerʵ�ָýӿ�
	 * @author LinJ
	 * @date 2015-1-23 ����3:09:15 
	 *  
	 */
	public interface PlayerListener extends  OnCompletionListener,
	OnSeekCompleteListener,OnPreparedListener{

	}
}
