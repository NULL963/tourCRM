package cn.crm.utils;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by LEMON on 2017/4/15.
 */
@Component
public class jdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Autowired
    public void setDataSource(DruidDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static DataSource getDataSoruce(){
        return dataSource;
    }
    public static Connection getConnection() {
        Connection conn = tl.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        tl.set(conn);
        return conn;
    }
/*    public static void StartTracsaction() {
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static void CommitTransaction() {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void closeConnection() {
        Connection conn = getConnection();
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            tl.remove();
        }

    }

}
