package com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.BaseQuickAdapter;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.BaseViewHolder;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.entity.HomeItem;

import java.util.List;

/**
 * description:
 * Created by aserbao on 2017/10/23.
 */


public class AnimationAdapter extends BaseQuickAdapter<HomeItem,BaseViewHolder> {

    public AnimationAdapter(@LayoutRes int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.text,item.getTitle());
    }
}
