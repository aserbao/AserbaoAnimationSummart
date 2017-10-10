package com.aserbao.aserbaoanimationsummart.classify.logic.rxJava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aserbao.aserbaoanimationsummart.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

public class RxJavaActivity extends AppCompatActivity {

    @BindView(R.id.rx_tv)
    TextView mRxTv;
    private Observable<String> mStringObservable;
    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        ButterKnife.bind(this);
    }

    public void btn_send(View view) {
        mStringObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        });
    }

    public void accept_send(View view) {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        if (mCompositeSubscription != null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mStringObservable.subscribe(subscriber);
    }
}
