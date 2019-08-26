package com.tron.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

//import java.io.IOException;
import java.io.IOException;
import java.io.Reader;


/**
 * ${params}
 *
 * @Author:tron
 * @Date:2019-08-23 15:00
 */
public class DatabaseUtil {

    public static SqlSession getSqlSession() throws IOException {
        //获取配置的资源文件

        Reader reader = Resources.getResourceAsReader("src/main/resources/databaseConfig.xml");
        //获取到的SqlSessionFactory,使用类加载器加载xml文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //获取到sqlsession对象，该就能执行配置文件中的sql语句
        SqlSession session = factory.openSession();
        return session;
    }
}
