package com.ccsu.crawler.dao;

import com.ccsu.crawler.model.Branch;
import com.ccsu.crawler.model.Seed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BranchDao {

    private Connection connection;

    private static String INSERT_SQL = "insert into tb_branch(repositoryId,branchName) values (?,?)";

    public BranchDao(){
        connection = MysqlConnect.getConnect();
    }

    public void closed(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Branch branch){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setLong(1,branch.getRepositoryid());
            ps.setString(2,branch.getBranchname());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
