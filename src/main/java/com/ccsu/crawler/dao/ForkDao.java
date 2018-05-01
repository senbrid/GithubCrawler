package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Fork;
import com.ccsu.crawler.model.Star;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ForkDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    private static Connection connection;

    public static void insert(Fork fork){
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_fork(repositoryId,forkLogin) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,fork.getRepositoryid());
            ps.setString(2,fork.getForklogin());
            ps.executeUpdate();
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
    }

}
