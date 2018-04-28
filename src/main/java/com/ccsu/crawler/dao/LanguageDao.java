package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LanguageDao {

    private Connection connection;

    private static String INSERT_SQL = "insert into tb_language(repositoryId,language,size) values (?,?,?)";

    public LanguageDao(){
        connection = MysqlConnect.getConnect();
    }

    public void closed(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Language language){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,language.getRepositoryid());
            ps.setString(2,language.getLanguage());
            ps.setInt(3,language.getSize());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
