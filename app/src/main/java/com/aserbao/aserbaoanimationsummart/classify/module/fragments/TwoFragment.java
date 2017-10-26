package com.aserbao.aserbaoanimationsummart.classify.module.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.fragments.adapter.TwoAdapter;
import com.aserbao.aserbaoanimationsummart.classify.module.fragments.entity.MultiItem;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    @BindView(R.id.two_fragment)
    RecyclerView mTwoRecyclerView;
    private ArrayList<MultiItem> mItems;

    public TwoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    private void initView() {
        TwoAdapter adapter = new TwoAdapter(mItems);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return mItems.get(position).getSpanSize();
            }
        });
        mTwoRecyclerView.setLayoutManager(manager);
        mTwoRecyclerView.setAdapter(adapter);
    }

    private void initData() {
        mItems = new ArrayList<>();
        String[] s = {"不怎么样","也就这样而已"};
        for (int i = 0; i < 4; i++) {
            mItems.add(new MultiItem(100,100,s,"http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4", "http://www.qq1234.org/uploads/allimg/121119/1_121119144404_1.jpg","share",MultiItem.FREEVIDEO,MultiItem.FREEVIDEO_SPAN));
            mItems.add(new MultiItem(200,200,s,"http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4", "http://www.qq1234.org/uploads/allimg/121119/1_121119144404_1.jpg","share",MultiItem.CHARGEVIDEO,MultiItem.CHARGEVIDEO_SPAN));
            mItems.add(new MultiItem(300,300,s,"http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4", "http://www.qq1234.org/uploads/allimg/121119/1_121119144404_1.jpg","share",MultiItem.CHARGEVIDEO,MultiItem.CHARGEVIDEO_SPAN));
            mItems.add(new MultiItem(400,400,s,"http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4", "http://www.qq1234.org/uploads/allimg/121119/1_121119144404_1.jpg","share",MultiItem.FREEVIDEO,MultiItem.FREEVIDEO_SPAN));
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
