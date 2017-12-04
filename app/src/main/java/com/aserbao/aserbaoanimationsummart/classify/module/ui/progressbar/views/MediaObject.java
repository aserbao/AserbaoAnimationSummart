package com.aserbao.aserbaoanimationsummart.classify.module.ui.progressbar.views;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by aserbao on 2017 2017/12/3.11:27
 * Email:1142803753@qq.com
 * weixin: aserbao
 */

public class MediaObject {
    public final static int DEFAULT_MAX_DURATION = 15 * 1000;

    /** 获取所有分块 */
    private LinkedList<MediaPart> mMediaList = new LinkedList<MediaPart>();

    public MediaPart buildMediaPart(String path,int duration){
        MediaPart mediaPart = new MediaPart();
        mediaPart.duration = duration;
        mediaPart.mediaPath = path;
        mMediaList.add(mediaPart);
        return mediaPart;
    };
    public int getDuration() {
        int duration = 0;
        if (mMediaList != null) {
            for (MediaPart part : mMediaList) {
                duration += part.getDuration();
            }
        }
        return duration;
    }
    public LinkedList<MediaPart> getMedaParts() {
        return mMediaList;
    }
    public static class MediaPart implements Serializable{
        public int index;
        public String mediaPath;
        public int duration;

        public String getMediaPath() {
            return mediaPath;
        }

        public int getDuration() {
            return duration;
        }

    }

}
