package com.tron.cases;

import com.tron.config.TestConfig;
import com.tron.model.InterfaceName;
import com.tron.model.LoadTxInfoCase;
import com.tron.utils.ConfigFile;
import com.tron.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.tron.utils.DatabaseUtil.getSqlSession;

/**
 * ${params}
 *
 * @Author:tron
 * @Date:2019-08-23 15:13
 */
public class LoadTxInfoTest {
    @BeforeTest(groups = "loadTrue",description = "测试准备工作，获取HttpClient对象")
    public void beforeTest(){

        TestConfig.defaultHttpClient = new DefaultHttpClient();
        TestConfig.loadtxinfoUrl = ConfigFile.getUrl(InterfaceName.LOADTXINFO);
    }
    @Test(groups = "loadTrue",description = "用户登陆成功")
    public void loadTrue() throws IOException {
        SqlSession session = getSqlSession();
        LoadTxInfoCase loadCase= session.selectOne("loadCase","1");
        System.out.println(loadCase.toString());
        System.out.println(TestConfig.loadtxinfoUrl);
    }
    @Test(groups = "loadFalse",description = "用户登陆失败")
    public void loadFalse() throws IOException {
        SqlSession session = getSqlSession();
        LoadTxInfoCase loadCase= session.selectOne("loadCase","2");
        System.out.println(loadCase.toString());
        System.out.println(TestConfig.loadtxinfoUrl);
    }
}
