package com.ccsu.crawler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperDao {

    private Connection con;

    public DeveloperDao(){
        con = MysqlConnect.getConnect();
    }

    public void insert(String sql){
        ResultSet rs;
        String job;
        String id;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery(sql);
            while(rs.next()){
                //获取stuname这列数据
                job = rs.getString("job");
                //获取stuid这列数据
                id = rs.getString("ename");
                //输出结果
                System.out.println(id + "\t" + job);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
