package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Language;
import com.ccsu.crawler.model.Star;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StarDao {

    private Connection connection;

    private static String INSERT_SQL = "insert into tb_star(repositoryId,starLogin) values (?,?)";

    public StarDao(){
        connection = MysqlConnect.getConnect();
    }

    public void closed(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Star star){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,star.getRepositoryid());
            ps.setString(2,star.getStarlogin());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
