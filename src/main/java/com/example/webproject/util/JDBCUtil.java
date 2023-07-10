package com.example.webproject.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

    private static final DataSource ds;

    static {
        try {
            Properties properties = new Properties();
            ClassLoader cl = JDBCUtil.class.getClassLoader();
            properties.load(cl.getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException("数据源配置失败", e);
        }
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (Exception e) {
            throw new RuntimeException("获取连接失败", e);
        }
    }

    // 在数据库连接池技术中，close不是真的断掉连接
    // 而是把使用的Connection对象放回连接池
    public static void close(ResultSet set, Statement statement, Connection conn) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("资源关闭失败", e);
        }
    }
}
