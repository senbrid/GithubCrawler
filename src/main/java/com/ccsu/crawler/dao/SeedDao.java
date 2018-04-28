package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Seed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeedDao {
    private Connection connection;

    private static String INSERT_SQL = "insert into tb_seed(seedLogin,state) values (?,?)";
    private static String SELECT_SQL = "select * from tb_seed where state = 1 limit 0,1";
    private static String SELECTBYLOGIN_SQL = "select * from tb_seed where seedLogin = ?";
    private static String UPDATE_SQL = "UPDATE tb_seed set state = 0 where id = ?";

    public SeedDao(){
        connection = MysqlConnect.getConnect();
    }

    public void closed(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Seed seed){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setString(1,seed.getSeedlogin());
            ps.setInt(2,seed.getState());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(int id){
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
            ps.setInt(1,id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Seed select(){
        ResultSet rs;
        Seed seed = null;
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_SQL);
            rs = ps.executeQuery();
            while (rs.next()){
                seed = new Seed();
                seed.setId(rs.getInt(1));
                seed.setSeedlogin(rs.getString(2));
                seed.setState(rs.getInt(3));
                seed.setUpdated(rs.getDate(4));
            }
            return seed;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Seed selectByLogin(String login){
        ResultSet rs;
        Seed seed = null;
        try {
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
            return seed;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
