package com.example.webproject.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class DBUtil {

    private static final QueryRunner runner = new QueryRunner();

    public static int update(String sql, Object... params) {
        try (Connection conn = JDBCUtil.getConnection()) {
            return runner.update(conn, sql, params);
        } catch (Exception e) {
            throw new RuntimeException("更新失败", e);
        }
    }

    public static <T> List<T> query(String sql, Class<T> cl, Object... params) {
        try (Connection conn = JDBCUtil.getConnection()) {
            return runner.query(conn, sql, new BeanListHandler<>(cl), params);
        } catch (Exception e) {
            throw new RuntimeException("查询失败", e);
        }
    }

    // 查询单行的结果
    public static <T> T querySingle(String sql, Class<T> cl, Object... params) {
        try (Connection conn = JDBCUtil.getConnection()) {
            return runner.query(conn, sql, new BeanHandler<>(cl), params);
        } catch (Exception e) {
            throw new RuntimeException("查询失败", e);
        }
    }

    public static <T> T queryScalar(String sql, Object... params) {
        try (Connection conn = JDBCUtil.getConnection()) {
            return runner.query(conn, sql, new ScalarHandler<>(), params);
        } catch (Exception e) {
            throw new RuntimeException("查询失败", e);
        }
    }
}
