package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Branch;
import com.ccsu.crawler.model.Seed;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BranchDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    private static Connection connection;

    public static void insert(Branch branch){
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_branch(repositoryId,branchName) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,branch.getRepositoryid());
            ps.setString(2,branch.getBranchname());
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
