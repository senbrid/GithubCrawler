package com.ccsu.crawler.dao.daoImpl;

import com.ccsu.crawler.dao.Dao;
import com.ccsu.crawler.model.Contributor;
import com.ccsu.crawler.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class ContributorDao implements Dao<Contributor> {

    private Connection connection;

    public int insert(Contributor contributor){
        int count = 0;
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_contributor(repositoryId,contributor,contributions) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,contributor.getRepositoryid());
            ps.setString(2,contributor.getContributor());
            ps.setInt(3,contributor.getContributions());
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
    public Contributor select(Map map) {
        return null;
    }

    @Override
    public int update(Map map) {
        return 0;
    }

}
