package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Contributor;
import com.ccsu.crawler.model.Fork;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContributorDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    private static Connection connection;

    public static void insert(Contributor contributor){
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_contributor(repositoryId,contributor,contributions) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,contributor.getRepositoryid());
            ps.setString(2,contributor.getContributor());
            ps.setInt(3,contributor.getContributions());
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
