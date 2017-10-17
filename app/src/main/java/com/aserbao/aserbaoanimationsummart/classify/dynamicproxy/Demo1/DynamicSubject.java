package com.aserbao.aserbaoanimationsummart.classify.dynamicproxy.Demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description:
 * Created by aserbao on 2017/10/17.
 */


public class DynamicSubject implements InvocationHandler {
    private Object sub;

    public DynamicSubject(Object sub) {
        this.sub = sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling"+  method);

        method.invoke(sub, args);

        System.out.println("after calling"+  method);

        return null;
    }
}
