package com.aserbao.aserbaoanimationsummart.sendgif;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;
import com.aserbao.aserbaoanimationsummart.sendgif.adapter.GiftMsgAdapter;

import org.dync.giftlibrary.util.GiftPanelControl;
import org.dync.giftlibrary.widget.GiftControl;
import org.dync.giftlibrary.widget.GiftFrameLayout;
import org.dync.giftlibrary.widget.GiftModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SendGifActivity extends AppCompatActivity {

    @BindView(R.id.gift_layout1)
    GiftFrameLayout giftLayout1;
    @BindView(R.id.gift_layout2)
    GiftFrameLayout giftLayout2;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.toolbox_pagers_face)
    ViewPager toolboxPagersFace;
    @BindView(R.id.face_dots_container)
    LinearLayout faceDotsContainer;
    @BindView(R.id.ll_portrait)
    LinearLayout llPortrait;
    @BindView(R.id.rv_gift)
    RecyclerView rvGift;
    @BindView(R.id.ll_landscape)
    LinearLayout llLandscape;
    @BindView(R.id.toolbox_tv_num_dsc)
    TextView toolboxTvNumDsc;
    @BindView(R.id.toolbox_tv_num)
    TextView toolboxTvNum;
    @BindView(R.id.toolbox_tv_recharge)
    TextView toolboxTvRecharge;
    @BindView(R.id.toolbox_tv_gift_num_dsc)
    TextView toolboxTvGiftNumDsc;
    @BindView(R.id.toolbox_tv_gift_num)
    TextView toolboxTvGiftNum;
    @BindView(R.id.toolbox_iv_face)
    ImageView toolboxIvFace;
    @BindView(R.id.giftToolBox)
    RelativeLayout giftToolBox;
    @BindView(R.id.giftLayout)
    LinearLayout giftLayout;
    @BindView(R.id.bottom)
    LinearLayout bottom;
    @BindView(R.id.btn_action)
    Button btnAction;


    private String mGifturl = "";
    private String mGiftName = "礼物";
    private String mGiftPrice = "";
    private GiftControl giftControl;
    private GiftMsgAdapter adapter;
    private GiftModel giftModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_gif);
        ButterKnife.bind(this);
        initialization();
    }

    private void initialization() {
        showGiftMsgList();
       /* List<GiftBean.GiftListBean> giftListBeen = fromNetData();//来自网络礼物图片
        List<GiftModel> giftModels = toGiftModel(giftListBeen);//转化为发送礼物的集合*/
        GiftPanelControl giftPanelControl = new GiftPanelControl(this, toolboxPagersFace, rvGift, faceDotsContainer);
        giftPanelControl.init(null);;//这里如果为null则加载本地礼物图片
        giftPanelControl.setGiftListener(new GiftPanelControl.GiftListener() {
            @Override
            public void getGiftInfo(String giftPic, String giftName, String giftPrice) {
                mGifturl = giftPic;
                mGiftName = giftName;
                mGiftPrice = giftPrice;
            }
        });
        giftControl = new GiftControl(giftLayout1, giftLayout2);
        toolboxTvGiftNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                showGiftDialog();
            }
        });
        toolboxIvFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mGiftName)) {
                    Toast.makeText(getApplication(), "你还没选择礼物呢", Toast.LENGTH_SHORT).show();
                } else {
                    String numStr = toolboxTvGiftNum.getText().toString();
                    if (!TextUtils.isEmpty(numStr)) {
                        int giftnum = Integer.parseInt(numStr);
                        if (giftnum == 0) {
                            return;
                        } else {
                            //这里最好不要直接new对象
                            giftModel = new GiftModel(mGiftName, "礼物名字", giftnum, mGifturl, "1234", "吕靓茜", "", System.currentTimeMillis());
                            giftControl.loadGift(giftModel);
                            adapter.add(mGiftName);
                        }
                    }
                }
            }
        });
    }

    private void showGiftDialog() {
        final GiftDialogFragment giftDialogFrament = new GiftDialogFragment();
        giftDialogFrament.show(getFragmentManager(), "GiftDialogFrament");
        giftDialogFrament.setGiftListener(new GiftDialogFragment.GiftListener() {
            @Override
            public void giftNum(String giftNum) {
                toolboxTvGiftNum.setText(giftNum);
                giftDialogFrament.dismiss();
            }
        });
    }

    private List<GiftModel> toGiftModel(List<GiftBean.GiftListBean> datas) {
        List<GiftModel> giftModels = new ArrayList<>();
        GiftModel giftModel;
        for (int i = 0; i < datas.size(); i++) {
            GiftBean.GiftListBean giftListBean = datas.get(i);
            giftModel = new GiftModel(giftListBean.getGiftName(), giftListBean.getGiftPic(), giftListBean.getGiftPrice());
            giftModels.add(giftModel);
        }
        return giftModels;
    }

    private List<GiftBean.GiftListBean> fromNetData() {
        return null;
    }

    private void showGiftMsgList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GiftMsgAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.btn_action)
    public void onViewClicked() {
        if (giftLayout.getVisibility() == View.VISIBLE) {
            giftLayout.setVisibility(View.GONE);
        } else {
            giftLayout.setVisibility(View.VISIBLE);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        //销毁动画
        if (giftControl != null) {
            giftControl.cleanAll();
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {// 横屏
//            Log.e(TAG, "onConfigurationChanged: " + "横屏");
            onConfigurationLandScape();

        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Log.e(TAG, "onConfigurationChanged: " + "竖屏");
            onConfigurationPortrait();
        }
    }

    private void onConfigurationPortrait() {
        llPortrait.setVisibility(View.VISIBLE);
        llLandscape.setVisibility(View.GONE);
    }

    private void onConfigurationLandScape() {
        llPortrait.setVisibility(View.GONE);
        llLandscape.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (giftLayout.getVisibility() == View.VISIBLE) {
                    giftLayout.setVisibility(View.GONE);
                }else{
                    giftLayout.setVisibility(View.VISIBLE);
                }
                break;
        }
        return super.onTouchEvent(event);
    }

}
