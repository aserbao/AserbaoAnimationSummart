package com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.adapters.MultipalAdapter;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.BaseQuickAdapter;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.entity.MultipleItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MultipleItemUserActivity extends AppCompatActivity {

    @BindView(R.id.animation_user_rv)
    RecyclerView mAnimationUserRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        List<MultipleItem> data = getMultipleItemData();
        MultipalAdapter adapter = new MultipalAdapter(data);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        mAnimationUserRv.setLayoutManager(layoutManager);
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return data.get(position).getSpanSize();
            }
        });
        mAnimationUserRv.setAdapter(adapter);
    }

    public static List<MultipleItem> getMultipleItemData() {
        List<MultipleItem> list = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            list.add(new MultipleItem(MultipleItem.IMG, MultipleItem.IMG_SPAN_SIZE));
            list.add(new MultipleItem(MultipleItem.TEXT, MultipleItem.TEXT_SPAN_SIZE, "BaseRecyclerViewAdapter"));
            list.add(new MultipleItem(MultipleItem.IMG_TEXT, MultipleItem.IMG_TEXT_SPAN_SIZE));
            list.add(new MultipleItem(MultipleItem.IMG_TEXT, MultipleItem.IMG_TEXT_SPAN_SIZE_MIN));
            list.add(new MultipleItem(MultipleItem.IMG_TEXT, MultipleItem.IMG_TEXT_SPAN_SIZE_MIN));
        }
        return list;
    }
}
