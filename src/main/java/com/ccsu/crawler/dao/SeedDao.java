package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Seed;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeedDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    private static Connection connection;

    public static void insert(Seed seed){
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_seed(seedLogin,state) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setString(1,seed.getSeedlogin());
            ps.setInt(2,seed.getState());
            ps.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            logger.info("抛出异常：" + e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                //e.printStackTrace();
                logger.info("抛出异常：" + e);
            }
        }
    }

    public static void update(int id){
        try {
            connection = MysqlConnect.getConnect();
            String UPDATE_SQL = "UPDATE tb_seed set state = 0 where id = ?";
            PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            logger.info("抛出异常：" + e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                //e.printStackTrace();
                logger.info("抛出异常：" + e);
            }
        }
    }

    public static Seed select(){
        ResultSet rs;
        Seed seed = null;
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
            //e.printStackTrace();
            logger.info("抛出异常：" + e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                //e.printStackTrace();
                logger.info("抛出异常：" + e);
            }
        }
        return seed;
    }

    public static Seed selectByLogin(String login){
        ResultSet rs;
        Seed seed = null;
        try {
            connection = MysqlConnect.getConnect();
            String SELECTBYLOGIN_SQL = "select * from tb_seed where seedLogin = ?";
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
            //e.printStackTrace();
            logger.info("抛出异常：" + e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                //e.printStackTrace();
                logger.info("抛出异常：" + e);
            }
        }
        return seed;
    }
}
