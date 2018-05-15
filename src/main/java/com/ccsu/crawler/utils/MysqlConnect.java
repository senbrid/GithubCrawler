package com.ccsu.crawler.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnect {

    static {
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/github?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "root123456";
        return DriverManager.getConnection(url, user, password);
    }

}
