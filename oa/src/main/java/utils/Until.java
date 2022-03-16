package utils;

import java.sql.*;
import java.util.ResourceBundle;

public class Until {
    //  绑定属性配置文件
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");

    //  注册类名Driver
    private static String driver = bundle.getString("driver");

    //  数据库Url
    private static String url = bundle.getString("url");

    //  数据库账户名
    private static String user = bundle.getString("user");

    //  数据库密码
    private static String password = bundle.getString("password");

    //  注册
//  数据库
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //  获取数据库连接
    public static Connection getConnection()
            throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    //  释放数据库资源
    public static void close(Connection connection, Statement statement, ResultSet rs){
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
