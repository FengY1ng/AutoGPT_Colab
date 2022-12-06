package com.gxy.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConn {
        private static  String url="jdbc:mysql://localhost:3306/dm_1?serverTimezone=Asia/Shanghai&useSSL=false&characterEncoding=utf8";
        private static String username="root";
        private static String password="123456";
        private static String driverName="com.mysql.cj.jdbc.Driver";

        public static Connection getConnection() throws ClassNotFoundException, SQLException {
                Class.forName(driverName);
                Connection connection = DriverManager.getConnection(url, username, password);
                return connection;
        }
}
