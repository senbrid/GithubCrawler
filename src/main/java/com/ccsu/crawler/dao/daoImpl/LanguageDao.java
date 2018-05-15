package com.ccsu.crawler.dao.daoImpl;

import com.ccsu.crawler.dao.Dao;
import com.ccsu.crawler.model.Language;
import com.ccsu.crawler.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class LanguageDao implements Dao<Language> {

    private Connection connection;

    public int insert(Language language){
        int count = 0;
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_language(repositoryId,language,size) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,language.getRepositoryid());
            ps.setString(2,language.getLanguage());
            ps.setInt(3,language.getSize());
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
    public Language select(Map map) {
        return null;
    }

    @Override
    public int update(Map map) {
        return 0;
    }

}
