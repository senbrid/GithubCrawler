package com.ccsu.crawler.dao.daoImpl;

import com.ccsu.crawler.dao.Dao;
import com.ccsu.crawler.model.Repository;
import com.ccsu.crawler.utils.MysqlConnect;

import java.sql.*;
import java.util.Map;

public class RepositoryDao implements Dao<Repository> {

    private Connection connection;

    public int insert(Repository repository) {
        int count = 0;
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_repository" +
                    "(id,name,full_name,description,default_branch,created_at,updated_at,pushed_at,size," +
                    "star_count,watchers_count,forks_count,language,developerLogin)" +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1, repository.getId());
            ps.setString(2, repository.getName());
            ps.setString(3, repository.getFullName());
            ps.setString(4, repository.getDescription());
            ps.setString(5, repository.getDefaultBranch());
            ps.setTimestamp(6, new Timestamp(repository.getCreatedAt() == null ? 0 : repository.getCreatedAt().getTime()));
            ps.setTimestamp(7, new Timestamp(repository.getUpdatedAt() == null ? 0 : repository.getUpdatedAt().getTime()));
            ps.setTimestamp(8, new Timestamp(repository.getPushedAt() == null ? 0 : repository.getPushedAt().getTime()));
            ps.setInt(9, repository.getSize());
            ps.setInt(10, repository.getStarCount());
            ps.setInt(11, repository.getWatchersCount());
            ps.setInt(12, repository.getForksCount());
            ps.setString(13, repository.getLanguage());
            ps.setString(14, repository.getDeveloperLogin());
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
    public Repository select(Map map) {
        ResultSet rs;
        Repository repository = null;
        Long id = (Long)map.get("id");
        try {
            connection = MysqlConnect.getConnect();
            //noinspection SqlDialectInspection
            String SELECT_SQL = "select * from tb_repository where id = ?";
            PreparedStatement ps = connection.prepareStatement(SELECT_SQL);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                repository = new Repository();
                repository.setId(rs.getLong(1));
                repository.setName(rs.getString(2));
                repository.setFullName(rs.getString(3));
                repository.setDescription(rs.getString(4));
                repository.setDefaultBranch(rs.getString(5));
                repository.setCreatedAt(rs.getDate(6));
                repository.setUpdatedAt(rs.getDate(7));
                repository.setPushedAt(rs.getDate(8));
                repository.setSize(rs.getInt(9));
                repository.setStarCount(rs.getInt(10));
                repository.setWatchersCount(rs.getInt(11));
                repository.setForksCount(rs.getInt(12));
                repository.setLanguage(rs.getString(13));
                repository.setDeveloperLogin(rs.getString(14));
                repository.setUpdated(rs.getDate(15));
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
        return repository;
    }

    @Override
    public int update(Map map) {
        return 0;
    }

}
