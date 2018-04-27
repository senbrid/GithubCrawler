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
        "delete from tb_seed",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_seed (id, seedLogin, ",
        "state, updated)",
        "values (#{id,jdbcType=INTEGER}, #{seedlogin,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=INTEGER}, #{updated,jdbcType=TIMESTAMP})"
    })
    int insert(Repository record);

    @InsertProvider(type=RepositorySqlProvider.class, method="insertSelective")
    int insertSelective(Repository record);

    @SelectProvider(type=RepositorySqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="seedLogin", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="state", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Repository> selectByExample(RepositoryExample example);

    @Select({
        "select",
        "id, seedLogin, state, updated",
        "from tb_seed",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="seedLogin", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="state", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="updated", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Repository selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RepositorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Repository record, @Param("example") RepositoryExample example);

    @UpdateProvider(type=RepositorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Repository record, @Param("example") RepositoryExample example);

    @UpdateProvider(type=RepositorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Repository record);

    @Update({
        "update tb_seed",
        "set seedLogin = #{seedlogin,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Repository record);
}