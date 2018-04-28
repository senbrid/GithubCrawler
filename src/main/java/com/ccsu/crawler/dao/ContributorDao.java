package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Contributor;
import com.ccsu.crawler.model.Fork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContributorDao {

    private Connection connection;

    private static String INSERT_SQL = "insert into tb_contributor(repositoryId,contributor,contributions) values (?,?,?)";

    public ContributorDao(){
        connection = MysqlConnect.getConnect();
    }

    public void closed(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Contributor contributor){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,contributor.getRepositoryid());
            ps.setString(2,contributor.getContributor());
            ps.setInt(3,contributor.getContributions());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
