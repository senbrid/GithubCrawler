package com.ccsu.crawler.dao.daoImpl;

import com.ccsu.crawler.dao.Dao;
import com.ccsu.crawler.model.Fork;
import com.ccsu.crawler.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class ForkDao implements Dao<Fork> {

    private Connection connection;

    @Override
    public int insert(Fork fork){
        int count = 0;
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_fork(repositoryId,forkLogin) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,fork.getRepositoryid());
            ps.setString(2,fork.getForklogin());
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
    public Fork select(Map map) {
        return null;
    }

    @Override
    public int update(Map map) {
        return 0;
    }

}
