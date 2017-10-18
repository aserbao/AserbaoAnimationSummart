package com.aserbao.aserbaoanimationsummart.classify.annotations.demo1;

import com.aserbao.aserbaoanimationsummart.classify.annotations.demo1.annotations.RequestParamsKey;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo1.annotations.RequestParamsUrl;

import java.lang.reflect.Field;

/**
 * description:
 * Created by aserbao on 2017/10/17.
 */


public class RequestParam {
    public RequestParam() {
    }
    public static String getParam(Class<?> _clazz,Object _object){
        Class<?> clazz = _clazz;
        Field[] fields = clazz.getDeclaredFields();
        try {
            return requestParam(fields, clazz, _object);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取请求路径
     *
     * @param fields
     * @param clazz
     * @param _object
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    private static String requestParam(Field[] fields, Class<?> clazz, Object _object) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder request = new StringBuilder();
        RequestParamsUrl requestParamsUrl = (RequestParamsUrl) clazz.getAnnotation(RequestParamsUrl.class);
        if (requestParamsUrl != null) {
            String url = requestParamsUrl.url();
            boolean isCache = requestParamsUrl.isCache();
            String host = requestParamsUrl.host().getHost();
            request.append(host);
            request.append(url);
            request.append("?");
            System.out.println("请求端口:" + host);
            System.out.println("请求地址:" + url);
            System.out.println("是否缓存:" + isCache);
        }
        for (Field field : fields) {
            RequestParamsKey requestParamsKey = field.getAnnotation(RequestParamsKey.class);
            if (requestParamsKey != null) {
                String key = requestParamsKey.key();
                String Value = (String) field.get(_object);
                request.append(key);
                request.append("=");
                request.append(Value);
                request.append("&");
            }
        }
        request.deleteCharAt(request.length() - 1);
        System.out.println("请求路径：" + request.toString());
        return request.toString();
    }
}
