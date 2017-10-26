package com.aserbao.aserbaoanimationsummart.classify.module.fragments.entity;

import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.interfaces.MultiItemEntity;

/**
 * description:
 * Created by aserbao on 2017/10/24.
 */


public class MultiItem implements MultiItemEntity {
    public static final int FREEVIDEO = 1;
    public static final int CHARGEVIDEO = 2;
    public static final int OTHER = 3;

    public static final int FREEVIDEO_SPAN = 2;
    public static final int CHARGEVIDEO_SPAN = 1;
    public static final int OTHER_SPAN = 3;

    private int zanNum;
    private int zanCount;
    private String[] mStrings;
    private String videoUrl;
    private String userHeadUrl;
    private String userName;
    private int itemType;
    private int spanSize;

    public MultiItem(int zanNum, int zanCount, String[] strings, String videoUrl, String userHeadUrl, String userName, int itemType, int spanSize) {
        this.zanNum = zanNum;
        this.zanCount = zanCount;
        mStrings = strings;
        this.videoUrl = videoUrl;
        this.userHeadUrl = userHeadUrl;
        this.userName = userName;
        this.itemType = itemType;
        this.spanSize = spanSize;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public int getZanNum() {
        return zanNum;
    }

    public void setZanNum(int zanNum) {
        this.zanNum = zanNum;
    }

    public int getZanCount() {
        return zanCount;
    }

    public void setZanCount(int zanCount) {
        this.zanCount = zanCount;
    }

    public String[] getStrings() {
        return mStrings;
    }

    public void setStrings(String[] strings) {
        mStrings = strings;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getUserHeadUrl() {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl) {
        this.userHeadUrl = userHeadUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
