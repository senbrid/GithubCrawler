package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Language;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LanguageDao {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(DeveloperDao.class);

    private static Connection connection;

    public static void insert(Language language){
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_language(repositoryId,language,size) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,language.getRepositoryid());
            ps.setString(2,language.getLanguage());
            ps.setInt(3,language.getSize());
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
