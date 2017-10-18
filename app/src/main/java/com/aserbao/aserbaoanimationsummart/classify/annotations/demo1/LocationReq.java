package com.aserbao.aserbaoanimationsummart.classify.annotations.demo1;

import com.aserbao.aserbaoanimationsummart.classify.annotations.demo1.annotations.RequestParamsKey;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo1.annotations.RequestParamsUrl;
import com.aserbao.aserbaoanimationsummart.classify.annotations.demo1.enums.Host;

/**
 * description:
 * Created by aserbao on 2017/10/17.
 */

@RequestParamsUrl(url = "getLocation.php", isCache = true, host = Host.Aserbao_2)
public class LocationReq {
    @RequestParamsKey(key = "lat_key")
    public String lat;
    @RequestParamsKey(key = "lan_key")
    public String lan;
}
