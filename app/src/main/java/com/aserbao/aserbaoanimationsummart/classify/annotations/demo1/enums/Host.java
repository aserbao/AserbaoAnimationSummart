package com.aserbao.aserbaoanimationsummart.classify.annotations.demo1.enums;

/**
 * description:
 * Created by aserbao on 2017/10/16.
 */


public enum  Host {

    Aserbao_1("https://One"),
    Aserbao_2("https://Two"),
    Aserbao_3("https://Three");

    private String host;
    Host(String host){
        this.host = host;
    }

    public String getHost(){
        return host;
    }
}
