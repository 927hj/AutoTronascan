package com.tron.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.servlet.http.Cookie;

/**
 * ${params}
 * 获取用户基础信息配置，对应接口名称
 * @Author:tron
 * @Date:2019-08-23 14:40
 */
public class TestConfig {

    //待消费监控登陆接口
    public static String loadtxinfoUrl;

    //用来存储cookies信息的变量
    public static CookieStore store;
    //声明http客户端
    public static DefaultHttpClient defaultHttpClient;
}
