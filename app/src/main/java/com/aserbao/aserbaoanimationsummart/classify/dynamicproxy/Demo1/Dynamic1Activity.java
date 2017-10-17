package com.aserbao.aserbaoanimationsummart.classify.dynamicproxy.Demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.R;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Dynamic1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic1);
    }

    public void btn_dynamic1_result(View view) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler invocationHandler = new DynamicSubject(realSubject);
        Class<? extends RealSubject> aClass = realSubject.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), invocationHandler);
        subject.request();
    }
}
