package com.aserbao.aserbaoanimationsummart.classify.annotations.demo1.annotations;


import com.aserbao.aserbaoanimationsummart.classify.annotations.demo1.enums.Host;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description:
 * Created by aserbao on 2017/10/17.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RequestParamsUrl {
    //接口地址
    String url();

    //端口
    Host host() default Host.Aserbao_1;

    //缓存
    boolean isCache() default false;
}
