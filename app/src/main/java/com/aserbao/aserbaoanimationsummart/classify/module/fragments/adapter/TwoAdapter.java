package com.aserbao.aserbaoanimationsummart.classify.module.fragments.adapter;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.fragments.customview.MyJZVideoPlayerStandard;
import com.aserbao.aserbaoanimationsummart.classify.module.fragments.entity.MultiItem;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.BaseMultiItemQuickAdapter;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.BaseViewHolder;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * description:
 * Created by aserbao on 2017/10/24.
 */


public class TwoAdapter extends BaseMultiItemQuickAdapter<MultiItem,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public TwoAdapter(List<MultiItem> data) {
        super(data);
        addItemType(MultiItem.FREEVIDEO, R.layout.fragment_two_free_video);
        addItemType(MultiItem.CHARGEVIDEO, R.layout.fragment_two_charge_video);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItem item) {
        switch (item.getItemType()){
            case MultiItem.FREEVIDEO:
                MyJZVideoPlayerStandard myJZVideoPlayerStandard = (MyJZVideoPlayerStandard) helper.getConvertView().findViewById(R.id.jz_video);
//                MyJZVideoPlayerStandard myJZVideoPlayerStandard1 = (MyJZVideoPlayerStandard) helper.getView(R.id.jz_video);
                myJZVideoPlayerStandard.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
                        , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "饺子快长大");
                break;
            case MultiItem.CHARGEVIDEO:
                MyJZVideoPlayerStandard myJZVideoPlayerStandard3 = (MyJZVideoPlayerStandard) helper.getConvertView().findViewById(R.id.jz_video);
//                MyJZVideoPlayerStandard myJZVideoPlayerStandard2 = (MyJZVideoPlayerStandard) helper.getView(R.id.jz_video);
                myJZVideoPlayerStandard3.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
                        , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "饺子快长大");
                break;
        }
    }
}
