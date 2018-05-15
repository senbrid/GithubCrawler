package com.ccsu.crawler.dao.daoImpl;

import com.ccsu.crawler.dao.Dao;
import com.ccsu.crawler.model.Branch;
import com.ccsu.crawler.utils.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class BranchDao implements Dao<Branch> {

    private Connection connection;

    public int insert(Branch branch){
        int count = 0;
        try {
            connection = MysqlConnect.getConnect();
            String INSERT_SQL = "insert into tb_branch(repositoryId,branchName) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,branch.getRepositoryid());
            ps.setString(2,branch.getBranchname());
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
    public Branch select(Map map) {
        return null;
    }

    @Override
    public int update(Map map) {
        return 0;
    }

}
