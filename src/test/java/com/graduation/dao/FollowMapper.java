package com.graduation.dao;

import com.graduation.model.Follow;
import com.graduation.model.FollowExample;
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

public interface FollowMapper {
    @SelectProvider(type=FollowSqlProvider.class, method="countByExample")
    int countByExample(FollowExample example);

    @DeleteProvider(type=FollowSqlProvider.class, method="deleteByExample")
    int deleteByExample(FollowExample example);

    @Delete({
        "delete from tb_follow",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_follow (id, followers, ",
        "following, updated)",
        "values (#{id,jdbcType=INTEGER}, #{followers,jdbcType=VARCHAR}, ",
        "#{following,jdbcType=VARCHAR}, #{updated,jdbcType=TIMESTAMP})"
    })
    int insert(Follow record);

    @InsertProvider(type=FollowSqlProvider.class, method="insertSelective")
    int insertSelective(Follow record);

    @SelectProvider(type=FollowSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="followers", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="following", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Follow> selectByExample(FollowExample example);

    @Select({
        "select",
        "id, followers, following, updated",
        "from tb_follow",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="followers", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="following", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Follow selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FollowSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Follow record, @Param("example") FollowExample example);

    @UpdateProvider(type=FollowSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Follow record, @Param("example") FollowExample example);

    @UpdateProvider(type=FollowSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Follow record);

    @Update({
        "update tb_follow",
        "set followers = #{followers,jdbcType=VARCHAR},",
          "following = #{following,jdbcType=VARCHAR},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Follow record);
}