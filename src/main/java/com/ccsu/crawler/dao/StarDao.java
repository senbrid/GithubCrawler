package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Star;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StarDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    private static Connection connection;

    public static void insert(Star star){
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_star(repositoryId,starLogin) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,star.getRepositoryid());
            ps.setString(2,star.getStarlogin());
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

}
