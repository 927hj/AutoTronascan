package com.tron.cases;

import com.tron.config.TestConfig;
import com.tron.model.InterfaceName;
import com.tron.model.LoadTxInfoCase;
import com.tron.utils.ConfigFile;
import com.tron.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
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
        System.out.println(TestConfig.loadtxinfoUrl+"?knock="+loadCase.getKnock());

        //连接接口的测试代码
        String result = getResult(loadCase);
        //判断返回结果是否符合预期
        //Assert.(String.valueOf(result));
    }
    @Test(groups = "loadFalse",description = "用户登陆失败")
    public void loadFalse() throws IOException {
        SqlSession session = getSqlSession();
        LoadTxInfoCase loadCase= session.selectOne("loadCase","2");
        System.out.println(loadCase.toString());
        System.out.println(TestConfig.loadtxinfoUrl+"?knock="+loadCase.getKnock());
        //连接接口的测试代码
        String result = getResultFalse(loadCase);
        //System.out.println(result.getClass().toString());
        //判断返回结果是否符合预期
        Assert.assertEquals("invalid password",result);
    }

    private String getResult(LoadTxInfoCase loadTxInfoCase) throws IOException {
        //下面是接口的测试代码
        HttpGet get = new HttpGet(TestConfig.loadtxinfoUrl+"?knock="+loadTxInfoCase.getKnock());
        JSONObject param = new JSONObject();
        param.put("knock",loadTxInfoCase.getKnock());
        //设置请求头信息，设置header
        get.setHeader("content-type","application/json?");
        //将参数信息添加到方法中
        //StringEntity entity = new StringEntity(param.toString(),"utf-8");
        //声明一个对象来进行响应结果的存放
        String result;
        //执行get方法
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }

    private String getResultFalse(LoadTxInfoCase loadTxInfoCase) throws IOException {
        //下面是接口的测试代码
        HttpGet get = new HttpGet(TestConfig.loadtxinfoUrl+"?knock="+loadTxInfoCase.getKnock());
        JSONObject param = new JSONObject();
        param.put("knock",loadTxInfoCase.getKnock());
        //设置请求头信息，设置header
        get.setHeader("content-type","application/json?");
        //将参数信息添加到方法中
        //StringEntity entity = new StringEntity(param.toString(),"utf-8");
        //声明一个对象来进行响应结果的存放
        String result;
        //执行get方法
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();
        return result;
    }
}
