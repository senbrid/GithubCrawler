package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Fork;
import com.ccsu.crawler.model.Star;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ForkDao {

    private Connection connection;

    private static String INSERT_SQL = "insert into tb_fork(repositoryId,forkLogin) values (?,?)";

    public ForkDao(){
        connection = MysqlConnect.getConnect();
    }

    public void closed(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Fork fork){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,fork.getRepositoryid());
            ps.setString(2,fork.getForklogin());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
