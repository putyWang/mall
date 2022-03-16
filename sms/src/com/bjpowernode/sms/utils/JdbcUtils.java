package com.bjpowernode.sms.utils;

import java.sql.*;

public class JdbcUtils {
//  注册数据库驱动
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection conn;
//  获取数据库连接
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testing";
        String user = "root";
        String password = "85854753";
            if (conn == null || conn.isClosed())
                conn = DriverManager.getConnection(url,user,password);
            return conn;
    }

//  关闭数据库资源
    public static void close(Connection conn, Statement st, ResultSet rs) throws SQLException {
        if(conn != null)
                conn.close();

        if(st != null)
                st.close();

        if(rs != null)
                rs.close();
    }
}
