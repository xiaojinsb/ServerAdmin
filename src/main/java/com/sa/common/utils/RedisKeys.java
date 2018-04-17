package com.sa.common.utils;

/**
 * @Author: moe
 * @Date: 2018/04/16
 * @Description: Redis所有Keys
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }
}
