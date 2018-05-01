package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Follow;
import com.ccsu.crawler.model.Seed;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FollowDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    private static Connection connection;

    private static String SELECT_SQL = "select * from tb_follow where login = ?";

    public static void insert(Follow follow){
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_follow(followers,following) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setString(1,follow.getFollowers());
            ps.setString(2,follow.getFollowing());
            ps.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            logger.info(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                //e.printStackTrace();
                logger.info(e.getMessage());
            }
        }
    }

    public static int selectDuplicate(String followers,String following){
        int count = 0;
        try {
            connection = MysqlConnect.getConnect();
            String SELECTDUPLICATE_SQL = "select * from tb_follow where followers = ? and following = ?";
            PreparedStatement ps = connection.prepareStatement(SELECTDUPLICATE_SQL);
            ps.setString(1,followers);
            ps.setString(2,following);
            count = ps.executeQuery().getRow();
        } catch (SQLException e) {
            //e.printStackTrace();
            logger.info(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                //e.printStackTrace();
                logger.info(e.getMessage());
            }
        }
        return count;
    }

    public static Seed select(){
        ResultSet rs;
        Seed seed = null;
        try {
            connection = MysqlConnect.getConnect();
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
            logger.info(e+"");
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                //e.printStackTrace();
                logger.info(e+"");
            }
        }
        return seed;
    }

}
