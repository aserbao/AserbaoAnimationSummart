package com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.adapters;

import android.graphics.Color;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.BaseMultiItemQuickAdapter;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.BaseViewHolder;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.interfaces.MultiItemEntity;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.entity.MultipleItem;

import java.util.List;
import java.util.Random;

/**
 * description:
 * Created by aserbao on 2017/10/23.
 */


public class MultipalAdapter extends BaseMultiItemQuickAdapter<MultipleItem,BaseViewHolder> {
    int[] colors = {Color.WHITE,Color.GREEN,Color.CYAN,Color.WHITE,Color.BLACK,Color.RED,Color.BLUE,Color.DKGRAY};
    private final Random mRandom;

    public MultipalAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.item_text_view);
        addItemType(MultipleItem.IMG, R.layout.item_image_view);
        addItemType(MultipleItem.IMG_TEXT, R.layout.item_img_text_view);
        mRandom = new Random();
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.iv, item.getContent());
                break;
            case MultipleItem.IMG_TEXT:
            case MultipleItem.IMG:
                int i = helper.getLayoutPosition() %
                        4;
//                helper.setBackgroundColor(R.id.image_bg, colors[mRandom.nextInt(colors.length)]);

                switch (i) {
                    case 0:
                        helper.setImageResource(R.id.iv, R.drawable.tu1);
                        break;
                    case 1:
                        helper.setBackgroundColor(R.id.iv, Color.BLACK);
                        helper.setImageResource(R.id.iv, R.drawable.tu2);
                        break;
                    case 2:
                        helper.setImageResource(R.id.iv, R.drawable.tu3);
                        break;
                    case 3:
                        helper.setImageResource(R.id.iv, R.drawable.tu4);
                        break;
                }
                break;
        }
    }
}
