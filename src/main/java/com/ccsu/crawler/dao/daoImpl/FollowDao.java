package com.ccsu.crawler.dao.daoImpl;

import com.ccsu.crawler.dao.Dao;
import com.ccsu.crawler.model.Follow;
import com.ccsu.crawler.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class FollowDao implements Dao<Follow> {

    private Connection connection;

    @Override
    public int insert(Follow follow){
        int count = 0;
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_follow(followers,following) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setString(1,follow.getFollowers());
            ps.setString(2,follow.getFollowing());
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
    public Follow select(Map map){
        String followers = (String)map.get("followers");
        String following = (String)map.get("following");
        Follow follow = null;
        ResultSet rs;
        try {
            connection = MysqlConnect.getConnect();
            String SELECTDUPLICATE_SQL = "select * from tb_follow where followers = ? and following = ?";
            PreparedStatement ps = connection.prepareStatement(SELECTDUPLICATE_SQL);
            ps.setString(1,followers);
            ps.setString(2,following);
            rs = ps.executeQuery();
            while (rs.next()){
                follow = new Follow();
                follow.setId(rs.getInt(1));
                follow.setFollowers(rs.getString(2));
                follow.setFollowing(rs.getString(3));
                follow.setUpdated(rs.getDate(4));
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
        return follow;
    }

    @Override
    public int update(Map map) {
        return 0;
    }

}
