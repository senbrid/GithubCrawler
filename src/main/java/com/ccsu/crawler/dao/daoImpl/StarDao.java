package com.ccsu.crawler.dao.daoImpl;

import com.ccsu.crawler.dao.Dao;
import com.ccsu.crawler.model.Star;
import com.ccsu.crawler.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class StarDao implements Dao<Star> {

    private Connection connection;

    public int insert(Star star){
        int count = 0;
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_star(repositoryId,starLogin) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,star.getRepositoryid());
            ps.setString(2,star.getStarlogin());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public Star select(Map map) {
        return null;
    }

    @Override
    public int update(Map map) {
        return 0;
    }

}
