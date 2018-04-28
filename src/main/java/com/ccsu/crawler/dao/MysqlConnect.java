package com.ccsu.crawler.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnect {
    //驱动程序名
    private static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    private static String url = "jdbc:mysql://localhost:3306/github?useUnicode=true&characterEncoding=utf-8";
    //MySQL配置时的用户名
    private static String user = "root";
    //MySQL配置时的密码
    private static String password = "root123456";

    static {
        try {
            //加载驱动程序
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
