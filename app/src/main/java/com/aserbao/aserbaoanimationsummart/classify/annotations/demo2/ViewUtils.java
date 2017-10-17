package com.aserbao.aserbaoanimationsummart.classify.annotations.demo2;

import android.app.Activity;
import android.view.View;

import com.aserbao.aserbaoanimationsummart.classify.annotations.demo2.annotations.ContentView;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo2.annotations.EventBase;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo2.annotations.OnClick;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo2.annotations.ViewInject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description:
 * Created by aserbao on 2017/10/17.
 */

public class ViewUtils {
    public static void injectContentView(Activity activity){
        Class a = activity.getClass();
        if (a.isAnnotationPresent(ContentView.class)) {
            // 得到activity这个类的ContentView注解
            ContentView contentView = (ContentView) a.getAnnotation(ContentView.class);
            // 得到注解的值
            int layoutId = contentView.value();
            // 使用反射调用setContentView
            try {
                Method method = a.getMethod("setContentView", int.class);
                method.setAccessible(true);
                method.invoke(activity, layoutId);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void injectViews(Activity activity){
        Class a = activity.getClass();
        Field[] fields = a.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ViewInject.class)) {
                ViewInject viewInject = field.getAnnotation(ViewInject.class);
                int viewId = viewInject.value();
                try {
                    Method method = a.getMethod("findViewById", int.class);
                    method.setAccessible(true);
                    Object invoke = method.invoke(activity, viewId);
                    field.setAccessible(true);
                    field.set(activity,invoke);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void injectEvents(Activity activity){
        Class<? extends Activity> aClass = activity.getClass();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(OnClick.class)) {
                //得到该方法上的OnClick注解
                OnClick onClick = method.getAnnotation(OnClick.class);
                //获取到OnClick注解的值
                int[] viewIds = onClick.value();
                //得到OnClick注解上的EventBase注解
                EventBase eventBase = onClick.annotationType().getAnnotation(EventBase.class);
                String listenerSetter = eventBase.listenerSetter();
                Class listenerType = eventBase.listenerType();
                String methodName = eventBase.methodName();
                //使用动态代理
                DynamicHandler handler = new DynamicHandler(activity);
                Object listener = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class<?>[] { listenerType }, handler);
                handler.addMethod(methodName, method);
                // 为每个view设置点击事件
                for (int viewId : viewIds) {
                    try {
                        Method findViewByIdMethod = aClass.getMethod("findViewById", int.class);
                        findViewByIdMethod.setAccessible(true);
                        View view  = (View) findViewByIdMethod.invoke(activity, viewId);
                        Method setEventListenerMethod = view.getClass().getMethod(listenerSetter, listenerType);
                        setEventListenerMethod.setAccessible(true);
                        setEventListenerMethod.invoke(view, listener);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
