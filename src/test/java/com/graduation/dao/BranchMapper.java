package com.graduation.dao;

import com.graduation.model.Branch;
import com.graduation.model.BranchExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BranchMapper {
    @SelectProvider(type=BranchSqlProvider.class, method="countByExample")
    int countByExample(BranchExample example);

    @DeleteProvider(type=BranchSqlProvider.class, method="deleteByExample")
    int deleteByExample(BranchExample example);

    @Delete({
        "delete from tb_branch",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_branch (id, repositoryId, ",
        "branchName, updated)",
        "values (#{id,jdbcType=INTEGER}, #{repositoryid,jdbcType=BIGINT}, ",
        "#{branchname,jdbcType=VARCHAR}, #{updated,jdbcType=TIMESTAMP})"
    })
    int insert(Branch record);

    @InsertProvider(type=BranchSqlProvider.class, method="insertSelective")
    int insertSelective(Branch record);

    @SelectProvider(type=BranchSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="branchName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Branch> selectByExample(BranchExample example);

    @Select({
        "select",
        "id, repositoryId, branchName, updated",
        "from tb_branch",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="branchName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Branch selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BranchSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Branch record, @Param("example") BranchExample example);

    @UpdateProvider(type=BranchSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Branch record, @Param("example") BranchExample example);

    @UpdateProvider(type=BranchSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Branch record);

    @Update({
        "update tb_branch",
        "set repositoryId = #{repositoryid,jdbcType=BIGINT},",
          "branchName = #{branchname,jdbcType=VARCHAR},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Branch record);
}