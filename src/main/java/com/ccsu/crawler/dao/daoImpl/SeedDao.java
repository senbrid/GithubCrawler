package com.ccsu.crawler.dao.daoImpl;

import com.ccsu.crawler.dao.Dao;
import com.ccsu.crawler.model.Seed;
import com.ccsu.crawler.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class SeedDao implements Dao<Seed>{

    private Connection connection;

    @Override
    public int insert(Seed seed){
        int count = 0;
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_seed(seedLogin,state) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setString(1,seed.getSeedlogin());
            ps.setInt(2,seed.getState());
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
    public Seed select(Map map) {
        String login = (String)map.get("login");
        ResultSet rs;
        Seed seed = null;
        try {
            connection = MysqlConnect.getConnect();
            String SELECTBYLOGIN_SQL = "select * from tb_seed where seedLogin = ? and state = 1";
            PreparedStatement ps = connection.prepareStatement(SELECTBYLOGIN_SQL);
            ps.setString(1,login);
            rs = ps.executeQuery();
            while (rs.next()){
                seed = new Seed();
                seed.setId(rs.getInt(1));
                seed.setSeedlogin(rs.getString(2));
                seed.setState(rs.getInt(3));
                seed.setUpdated(rs.getDate(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return seed;
    }

    @Override
    public int update(Map map) {
        int count = 0;
        int id = (int)map.get("id");
        try {
            connection = MysqlConnect.getConnect();
            String UPDATE_SQL = "UPDATE tb_seed set state = 0 where id = ?";
            PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
            ps.setInt(1,id);
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

    public static Seed select(){
        ResultSet rs;
        Seed seed = null;
        Connection connection = null;
        try {
            connection = MysqlConnect.getConnect();
            String SELECT_SQL = "select * from tb_seed where state = 1 limit 0,1";
            PreparedStatement ps = connection.prepareStatement(SELECT_SQL);
            rs = ps.executeQuery();
            while (rs.next()){
                seed = new Seed();
                seed.setId(rs.getInt(1));
                seed.setSeedlogin(rs.getString(2));
                seed.setState(rs.getInt(3));
                seed.setUpdated(rs.getDate(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return seed;
    }

}
