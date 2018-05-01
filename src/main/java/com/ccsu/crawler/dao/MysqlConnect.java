package com.ccsu.crawler.dao;

import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnect {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    static {
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            logger.info("抛出异常：" + e);
        }
    }

    public static Connection getConnect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/github?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "root123456";
        return DriverManager.getConnection(url, user, password);
    }

}
