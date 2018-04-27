package com.graduation.dao;

import com.graduation.model.Contributor;
import com.graduation.model.ContributorExample;
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

public interface ContributorMapper {
    @SelectProvider(type=ContributorSqlProvider.class, method="countByExample")
    int countByExample(ContributorExample example);

    @DeleteProvider(type=ContributorSqlProvider.class, method="deleteByExample")
    int deleteByExample(ContributorExample example);

    @Delete({
        "delete from tb_contributor",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_contributor (id, repositoryId, ",
        "contributor, contributions, ",
        "updated)",
        "values (#{id,jdbcType=INTEGER}, #{repositoryid,jdbcType=BIGINT}, ",
        "#{contributor,jdbcType=VARCHAR}, #{contributions,jdbcType=INTEGER}, ",
        "#{updated,jdbcType=TIMESTAMP})"
    })
    int insert(Contributor record);

    @InsertProvider(type=ContributorSqlProvider.class, method="insertSelective")
    int insertSelective(Contributor record);

    @SelectProvider(type=ContributorSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="contributor", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="contributions", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Contributor> selectByExample(ContributorExample example);

    @Select({
        "select",
        "id, repositoryId, contributor, contributions, updated",
        "from tb_contributor",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="repositoryId", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="contributor", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="contributions", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Contributor selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ContributorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Contributor record, @Param("example") ContributorExample example);

    @UpdateProvider(type=ContributorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Contributor record, @Param("example") ContributorExample example);

    @UpdateProvider(type=ContributorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Contributor record);

    @Update({
        "update tb_contributor",
        "set repositoryId = #{repositoryid,jdbcType=BIGINT},",
          "contributor = #{contributor,jdbcType=VARCHAR},",
          "contributions = #{contributions,jdbcType=INTEGER},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Contributor record);
}