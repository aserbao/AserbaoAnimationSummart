package com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.adapters.AnimationAdapter;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.base.BaseQuickAdapter;
import com.aserbao.aserbaoanimationsummart.classify.module.ui.recyclerview.entity.HomeItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {
    private static final Class<?>[] ACTIVITY = {MultipleItemUserActivity.class,RecyclerViewActivity.class,RecyclerViewActivity.class,RecyclerViewActivity.class,RecyclerViewActivity.class,RecyclerViewActivity.class,RecyclerViewActivity.class,RecyclerViewActivity.class,RecyclerViewActivity.class,RecyclerViewActivity.class,RecyclerViewActivity.class};
    private static final String[] TITLE = {"Animation", "MultipleItem", "Header/Footer", "PullToRefresh", "Section", "EmptyView", "DragAndSwipe", "ItemClick", "ExpandableItem", "DataBinding", "UpFetchData"};
    private static final int[] IMG = {R.mipmap.deer,R.mipmap.beagledog,R.mipmap.ic_bg,R.mipmap.diamond2x,R.mipmap.deer,R.mipmap.beagledog,R.mipmap.ic_bg,R.mipmap.diamond2x,R.mipmap.deer,R.mipmap.beagledog,R.mipmap.ic_bg,R.mipmap.diamond2x};

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private ArrayList<HomeItem> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            item.setImageResource(IMG[i]);
            mDataList.add(item);
        }
    }

    private void initView() {
        AnimationAdapter adapter = new AnimationAdapter(R.layout.home_item_view, mDataList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        adapter.addHeaderView(top);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Toast.makeText(RecyclerViewActivity.this, "加载更多成功", Toast.LENGTH_SHORT).show();
            }
        },mRecyclerView);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(RecyclerViewActivity.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
