package com.graduation.dao;

import com.graduation.model.Repository;
import com.graduation.model.RepositoryExample;
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

public interface RepositoryMapper {
    @SelectProvider(type=RepositorySqlProvider.class, method="countByExample")
    int countByExample(RepositoryExample example);

    @DeleteProvider(type=RepositorySqlProvider.class, method="deleteByExample")
    int deleteByExample(RepositoryExample example);

    @Delete({
        "delete from tb_repository",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tb_repository (id, name, ",
        "full_name, default_branch, ",
        "created_at, updated_at, ",
        "pushed_at, size, ",
        "star_count, watchers_count, ",
        "forks_count, language, ",
        "developerLogin, updated, ",
        "description)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{fullName,jdbcType=VARCHAR}, #{defaultBranch,jdbcType=VARCHAR}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{updatedAt,jdbcType=TIMESTAMP}, ",
        "#{pushedAt,jdbcType=TIMESTAMP}, #{size,jdbcType=INTEGER}, ",
        "#{starCount,jdbcType=INTEGER}, #{watchersCount,jdbcType=INTEGER}, ",
        "#{forksCount,jdbcType=INTEGER}, #{language,jdbcType=VARCHAR}, ",
        "#{developerlogin,jdbcType=VARCHAR}, #{updated,jdbcType=TIMESTAMP}, ",
        "#{description,jdbcType=LONGVARCHAR})"
    })
    int insert(Repository record);

    @InsertProvider(type=RepositorySqlProvider.class, method="insertSelective")
    int insertSelective(Repository record);

    @SelectProvider(type=RepositorySqlProvider.class, method="selectByExampleWithBLOBs")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="full_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="default_branch", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="created_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updated_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="pushed_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="size", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="star_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="watchers_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="forks_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="language", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="developerLogin", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Repository> selectByExampleWithBLOBs(RepositoryExample example);

    @SelectProvider(type=RepositorySqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="full_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="default_branch", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="created_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updated_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="pushed_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="size", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="star_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="watchers_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="forks_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="language", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="developerLogin", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Repository> selectByExample(RepositoryExample example);

    @Select({
        "select",
        "id, name, full_name, default_branch, created_at, updated_at, pushed_at, size, ",
        "star_count, watchers_count, forks_count, language, developerLogin, updated, ",
        "description",
        "from tb_repository",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="full_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="default_branch", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="created_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="updated_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="pushed_at", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="size", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="star_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="watchers_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="forks_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="language", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="developerLogin", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="description", javaType=String.class, jdbcType=JdbcType.LONGVARCHAR)
    })
    Repository selectByPrimaryKey(Long id);

    @UpdateProvider(type=RepositorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Repository record, @Param("example") RepositoryExample example);

    @UpdateProvider(type=RepositorySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Repository record, @Param("example") RepositoryExample example);

    @UpdateProvider(type=RepositorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Repository record, @Param("example") RepositoryExample example);

    @UpdateProvider(type=RepositorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Repository record);

    @Update({
        "update tb_repository",
        "set name = #{name,jdbcType=VARCHAR},",
          "full_name = #{fullName,jdbcType=VARCHAR},",
          "default_branch = #{defaultBranch,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "pushed_at = #{pushedAt,jdbcType=TIMESTAMP},",
          "size = #{size,jdbcType=INTEGER},",
          "star_count = #{starCount,jdbcType=INTEGER},",
          "watchers_count = #{watchersCount,jdbcType=INTEGER},",
          "forks_count = #{forksCount,jdbcType=INTEGER},",
          "language = #{language,jdbcType=VARCHAR},",
          "developerLogin = #{developerlogin,jdbcType=VARCHAR},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Repository record);

    @Update({
        "update tb_repository",
        "set name = #{name,jdbcType=VARCHAR},",
          "full_name = #{fullName,jdbcType=VARCHAR},",
          "default_branch = #{defaultBranch,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "pushed_at = #{pushedAt,jdbcType=TIMESTAMP},",
          "size = #{size,jdbcType=INTEGER},",
          "star_count = #{starCount,jdbcType=INTEGER},",
          "watchers_count = #{watchersCount,jdbcType=INTEGER},",
          "forks_count = #{forksCount,jdbcType=INTEGER},",
          "language = #{language,jdbcType=VARCHAR},",
          "developerLogin = #{developerlogin,jdbcType=VARCHAR},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Repository record);
}