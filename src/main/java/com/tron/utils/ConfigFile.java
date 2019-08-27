package com.tron.utils;

import com.tron.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ${params}
 *
 * @Author:tron
 * @Date:2019-08-23 14:44
 */
public class ConfigFile {

    //加载配置文件变量
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    //拼接url
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        //最终的测试地址6。6
        String testUrl;
        if(name == InterfaceName.LOADTXINFO){
            uri = bundle.getString("loadtxinfo.uri");
        }
        testUrl = address + uri;
        return testUrl;
    }
}
