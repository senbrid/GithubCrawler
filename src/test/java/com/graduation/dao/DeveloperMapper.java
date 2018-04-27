package com.graduation.dao;

import com.graduation.model.Developer;
import com.graduation.model.DeveloperExample;
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

public interface DeveloperMapper {
    @SelectProvider(type=DeveloperSqlProvider.class, method="countByExample")
    int countByExample(DeveloperExample example);

    @DeleteProvider(type=DeveloperSqlProvider.class, method="deleteByExample")
    int deleteByExample(DeveloperExample example);

    @Delete({
        "delete from tb_developer",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tb_developer (id, login, ",
        "avatar_url, name, ",
        "company, location, ",
        "blog, email, bio, ",
        "type, public_repos, ",
        "followers, following, ",
        "created_at, updated_at, ",
        "updated)",
        "values (#{id,jdbcType=BIGINT}, #{login,jdbcType=VARCHAR}, ",
        "#{avatarUrl,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{company,jdbcType=VARCHAR}, #{location,jdbcType=VARCHAR}, ",
        "#{blog,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{bio,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{publicRepos,jdbcType=INTEGER}, ",
        "#{followers,jdbcType=INTEGER}, #{following,jdbcType=INTEGER}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{updatedAt,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP})"
    })
    int insert(Developer record);

    @InsertProvider(type=DeveloperSqlProvider.class, method="insertSelective")
    int insertSelective(Developer record);

    @SelectProvider(type=DeveloperSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="login", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="avatar_url", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="company", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="location", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="blog", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="bio", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="public_repos", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="followers", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="following", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updated_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Developer> selectByExample(DeveloperExample example);

    @Select({
        "select",
        "id, login, avatar_url, name, company, location, blog, email, bio, type, public_repos, ",
        "followers, following, created_at, updated_at, updated",
        "from tb_developer",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="login", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="avatar_url", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="company", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="location", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="blog", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="bio", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="public_repos", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="followers", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="following", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updated_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Developer selectByPrimaryKey(Long id);

    @UpdateProvider(type=DeveloperSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Developer record, @Param("example") DeveloperExample example);

    @UpdateProvider(type=DeveloperSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Developer record, @Param("example") DeveloperExample example);

    @UpdateProvider(type=DeveloperSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Developer record);

    @Update({
        "update tb_developer",
        "set login = #{login,jdbcType=VARCHAR},",
          "avatar_url = #{avatarUrl,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "company = #{company,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=VARCHAR},",
          "blog = #{blog,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "bio = #{bio,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "public_repos = #{publicRepos,jdbcType=INTEGER},",
          "followers = #{followers,jdbcType=INTEGER},",
          "following = #{following,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Developer record);
}